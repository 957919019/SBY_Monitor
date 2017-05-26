package com.sby.practice.model.modelImol;

import android.content.Context;
import android.net.ConnectivityManager;

import com.sby.constant.API;
import com.sby.constant.Constant;
import com.sby.http.NetworkUtils;
import com.sby.http.HttpRequestCallback;
import com.sby.http.OkHttpUtils;
import com.sby.http.RequestParams;
import com.sby.practice.model.RegisterModel;
import com.sby.utils.ACache;

/**
 * 注册Model实现类
 * Created by kowal on 2016/11/22.
 */

public class RegisterModelImpl implements RegisterModel
{
    ACache mCache;

    /**
     * 注册
     */
    @Override
    public void onRegister(Context context, String coName, String phone, String pwd, HttpRequestCallback callBack)
    {
        RequestParams params = new RequestParams();
        params.put("coName", coName);
        params.put("phone", phone);
        params.put("pwd", pwd);

        mCache = ACache.get(context);
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.post(context, API.REGISTER, params, callBack);
    }

    /**
     * 验证码
     *
     * @param context
     * @param phone
     * @param callBack
     */
    @Override
    public void getCode(Context context, String phone, HttpRequestCallback callBack)
    {
        RequestParams params = new RequestParams();
        params.put("phone", phone);

        mCache = ACache.get(context);
        int netType = NetworkUtils.getNetworkType(context);

        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString(Constant.MOBILE_ON) != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.VALIDATION_CODE, params, callBack);
        }
    }

}
