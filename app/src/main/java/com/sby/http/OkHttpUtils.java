package com.sby.http;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.google.gson.Gson;
import com.sby.constant.Constant;
import com.sby.utils.Logger;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求工具类
 * Created by kowal on 2016/9/22.
 */

public class OkHttpUtils
{
    private static final String TAG = OkHttpUtils.class.getSimpleName();
    private OkHttpClient client; //声明客户端
    private volatile static OkHttpUtils okHttpUtils; //防止多个线程同时访问所造成的安全隐患

    private static final MediaType JSON = MediaType.parse("application/json;charset=utf-8"); //定义提交类型Json
    private static final MediaType STRING = MediaType.parse("text/x-markdown;charset=utf-8"); //定义提交类型String

    private Gson gson;
    private Handler httpHandler;

    //构造方法
    public OkHttpUtils()
    {
        //初始化
        client = new OkHttpClient();
        httpHandler = new Handler(Looper.getMainLooper());
        gson = new Gson();
    }


    //单例模式
    public static OkHttpUtils getInstance()
    {
        OkHttpUtils okUtils = null;
        if (okHttpUtils == null)
        {
            //线程同步
            synchronized (OkHttpUtils.class)
            {
                if (okUtils == null)
                {
                    okUtils = new OkHttpUtils();
                    okHttpUtils = okUtils;
                }
            }
        } else
        {
            okUtils = new OkHttpUtils();
        }
        return okUtils;
    }

    public void get(Context context, final String methodName, final HttpRequestCallback callback)
    {
        Request request = new Request.Builder().tag(getTagByContext(context)).url(Constant.uri + methodName).get().build();
        client.newCall(request).enqueue(getCallback(callback));
    }

    /**
     * 向服务器提交表单
     */
    public void post(Context context, final String methodName, RequestParams params, final HttpRequestCallback callback)
    {
        //post提交
        Request request = new Request.Builder().tag(getTagByContext(context)).url(Constant.uri + methodName).post(params.toParams()).build();
        client.newCall(request).enqueue(getCallback(callback));
    }

    public void post(Context context, final String methodName, RequestBody params, final HttpRequestCallback callback)
    {
        Logger.e("发送", methodName);
        //post提交
        Request request = new Request.Builder().tag(getTagByContext(context)).url(Constant.uri + methodName).post(params).build();
        client.newCall(request).enqueue(getCallback(callback));
    }

    /**
     * 实时获取灰机
     * @param activity
     * @param url
     * @param params
     * @param callback
     * @throws IOException
     */
    public void intercept(Activity activity, String url, String params, final HttpRequestCallback callback) throws IOException
    {
        RequestBody body = RequestBody.create(MediaType.parse("application/soap+xml; charset=utf-8"), params);
        Logger.e("发送的是：", url);
        Request request = new Request.Builder().tag(getTagByContext(activity)).url(url).post(body).build();
        client.newCall(request).enqueue(getCallback(callback));
    }

    /**
     * 重新封装一层callback 添加onStart 和 onFinish
     *
     * @param callback
     * @return
     */
    private Callback getCallback(final HttpRequestCallback callback)
    {
        if (callback != null)
        {
            callback.onStart();
        }
        return new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                if (callback != null)
                {
                    HttpResult httpResult = new HttpResult(HttpHandler.HTTP_FAILURE);
                    httpResult.callback = callback;
                    httpResult.exception = new HttpException(e);
                    httpResult.call = call;
                    httpHandler.post(new HttpHandler(httpResult));
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                if (callback != null)
                {
                    if (response.code() == 200)
                    {
                        HttpResult httpResult = new HttpResult(HttpHandler.HTTP_SUCCESS);
                        httpResult.callback = callback;
                        httpResult.response = response.body().string();
                        httpResult.call = call;
                        httpHandler.post(new HttpHandler(httpResult));
                    } else
                    {
                        HttpResult httpResult = new HttpResult(HttpHandler.HTTP_FAILURE);
                        httpResult.callback = callback;
                        httpResult.call = call;
                        httpResult.exception = new HttpException(response.code());
                        httpHandler.post(new HttpHandler(httpResult));
                    }
                }
            }
        };
    }

    class HttpResult
    {
        private HttpRequestCallback callback;
        private String response;
        private HttpException exception;
        private Call call;
        private int what;

        private Message msg;

        public HttpResult(int what)
        {
            this.msg = new Message();
            this.what = what;
        }

        public Message getMessage()
        {
            this.msg.what = what;
            msg.obj = this;
            return msg;

        }
    }

    class HttpHandler implements Runnable
    {
        public static final int HTTP_SUCCESS = 1;
        public static final int HTTP_FAILURE = 2;

        private HttpResult httpResult;

        public HttpHandler(HttpResult httpResult)
        {
            this.httpResult = httpResult;
        }

        @Override
        public void run()
        {
            httpResult.callback.onFinish();

            if (httpResult.what == HTTP_SUCCESS)
            {
                // 当返回的类型是String
                if (httpResult.callback.type == String.class)
                {
                    httpResult.callback.onResponse(httpResult.response);
                } else
                {
                    try
                    {

                        Object object = com.alibaba.fastjson.JSON.parseObject(httpResult.response, httpResult.callback.type);
                        httpResult.callback.onResponse(object);
                    } catch (Exception e)
                    {
                        if (httpResult.response.startsWith("<?xml version"))
                        {
                            // 返回XML
                            httpResult.callback.onResponse(httpResult.response);
                        }
                        // 解析异常
                        httpResult.callback.onFailure(httpResult.call, new HttpException(HttpException.EXCEPTION_DATA));
                    }
                }
            } else
            {
                httpResult.callback.onFailure(httpResult.call, httpResult.exception);
            }
        }
    }

    /**
     * 通过context 生成http 请求tag
     * tag 用来标识 http 请求，可通过tag 来取消请求
     *
     * @param context
     * @return
     */
    private String getTagByContext(Context context)
    {
        return context != null ? context.getClass().getName() : null;
    }

}
