package com.sby.practice.model.modelImol;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

import com.alibaba.fastjson.JSON;
import com.sby.bean.other.MonitorTime;
import com.sby.constant.API;
import com.sby.http.HttpRequestCallback;
import com.sby.http.NetworkUtils;
import com.sby.http.OkHttpUtils;
import com.sby.http.RequestParams;
import com.sby.practice.model.MainModel;
import com.sby.utils.ACache;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 主界面Model实现类
 * Created by kowal on 2016/12/13.
 */

public class MainModelImpl implements MainModel
{
    ACache mCache;
    /**
     * 获取所有飞机点
     */
    @Override
    public void getFlights(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("token", token);

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.VALIDATION_CODE, params, callback);
        }
    }

    /**
     * 报告点
     */
    @Override
    public void getReportPoint(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("token", token);

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post( context,API.REPORT_POINT, params, callback);
        }
    }

    /**
     * 固定空域
     */
    @Override
    public void getFixedAirspace(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.FIXEDAIR_SPACE, params, callback);
        }
    }

    /**
     * 护林航线
     */
    @Override
    public void getRangerRoute(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("token", token);

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.VALIDATION_CODE, params, callback);
        }
    }

    /**
     * 农化机场
     */
    @Override
    public void getAirportConversion(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("airportUseType", "农化机场");

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.AIR_PORT, params, callback);
        }
    }

    /**
     * 护林机场
     */
    @Override
    public void getRangerAirport(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("airportUseType", "护林机场");

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post( context,API.AIR_PORT, params, callback);
        } else
        {
            callback.onFinish();
        }
    }

    /**
     * 民航机场
     */
    @Override
    public void getCivilAviationAirport(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("airportUseType", "民航机场");

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.AIR_PORT, params, callback);
        } else
        {
            callback.onFinish();
        }
    }

    /**
     * 禁飞区
     */
    @Override
    public void getNoFlyZone(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("token", token);

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.VALIDATION_CODE, params, callback);
        } else
        {
            callback.onFinish();
        }
    }

    /**
     * 加油点
     */
    @Override
    public void getRefuelingPoint(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("token", token);

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post(context, API.VALIDATION_CODE, params, callback);
        } else
        {
            callback.onFinish();
        }
    }

    /**
     * 民航航线
     */
    @Override
    public void getCivilAviationRoute(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("token", token);

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post( context,API.VALIDATION_CODE, params, callback);
        } else
        {
            callback.onFinish();
        }
    }

    /**
     * 获取飞机筛选结果
     */
    @Override
    public void getFlightChoose(Context context, String token, HttpRequestCallback callback)
    {
        mCache = ACache.get(context);
        RequestParams params = new RequestParams();
        params.put("token", token);

        int netType = NetworkUtils.getNetworkType(context);
        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString("mobileOn") != null)) // 或使用移动网并且开启了3G模式
        {
            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
            okHttpUtils.post( context,API.VALIDATION_CODE, params, callback);
        } else
        {
            callback.onFinish();
        }
    }

    @Override
    public void getQjJiang(Context context, String token, HttpRequestCallback callback)
    {

    }

    @Override
    public void getFltNo(Context context, String token, HttpRequestCallback callback)
    {

    }

    @Override
    public void getFltType(Context context, String token, HttpRequestCallback callback)
    {

    }

    @Override
    public void getFlter(Context context, String token, HttpRequestCallback callback)
    {

    }

    @Override
    public void getWorkType(Context context, String token, HttpRequestCallback callback)
    {

    }

    @Override
    public void getRelTimeFlt(Activity activity, String token, HttpRequestCallback callback)
    {
        String uri = "http://192.168.1.127:8081/WebService1.asmx?op=QueryJzxx";

//        String start = "2010/01/01 00:00:00";
//        String end = "2080/12/12 00:00:00";
        String content = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <QueryJzxx xmlns=\"http://tempuri.org/\">\n" +
                "      <startDate>2010/01/01 00:00:00</startDate>\n" +
                "      <endDate>2080/12/12 00:00:00</endDate>\n" +
                "    </QueryJzxx>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        try
        {
            okHttpUtils.intercept(activity ,uri,  content, callback);
        } catch (IOException e)
        {
            e.printStackTrace();
        }



    }

    @Override
    public void getMovingFlt(Activity activity, String start, String end, HttpRequestCallback callback)
    {
        MonitorTime time = new MonitorTime();
        time.setStartDate(start);
        time.setEndDate(end);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), JSON.toJSONString(time));
        
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.post(activity, API.MONITOR, body, callback);
    }
}
