package com.sby.practice.model.modelImol;

import android.content.Context;

import com.sby.http.HttpRequestCallback;
import com.sby.practice.model.StatisticsDataModel;
import com.sby.utils.ACache;

/**
 * Created by kowal on 2016/12/4.
 */

public class StatisticsDataModelImpl implements StatisticsDataModel
{
    ACache mCache;

    /**
     * 获取今天数据
     *
     * @param context
     * @param token
     */
    @Override
    public void getToday(Context context, String token, HttpRequestCallback callBack)
    {
//        RequestParams params = new RequestParams();
//        params.put("token", token);
//
//        mCache = ACache.get(context);
//        int netType = NetworkUtils.getNetworkType(context);
//
//        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
//                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString(Constant.MOBILE_ON) != null)) // 或使用移动网并且开启了3G模式
//        {
//            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
//            okHttpUtils.sendDatafForClicent(context, API.REGISTER,
//                    params, callBack);
//        } else
//        {
//            callBack.onFinish();
//        }
    }

    /**
     * 获取历史数据
     *
     * @param context
     * @param token
     * @param callBack
     */
    @Override
    public void getHistory(Context context, String token, HttpRequestCallback callBack)
    {
//        RequestParams params = new RequestParams();
//        params.put("token", token);
//
//        mCache = ACache.get(context);
//        int netType = NetworkUtils.getNetworkType(context);
//
//        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
//                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString(Constant.MOBILE_ON) != null)) // 或使用移动网并且开启了3G模式
//        {
//            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
//            okHttpUtils.sendDatafForClicent(context, API.REGISTER,
//                    params, callBack);
//        } else
//        {
//            callBack.onFinish();
//        }
    }

    /**
     * 根据条件查询历史数据
     *
     * @param context
     * @param num       飞机编号
     * @param poileId   飞行员ID
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param token
     * @param callBack
     */
    @Override
    public void getFlyTimes(Context context, int num, int poileId,
                            String startTime, String endTime,
                            String token, HttpRequestCallback callBack)
    {
//        RequestParams params = new RequestParams();
//        params.put("num", num + "");
//        params.put("poileId", poileId + "");
//        params.put("startTime", startTime);
//        params.put("endTime", endTime);
//        params.put("token", token);
//
//        mCache = ACache.get(context);
//        int netType = NetworkUtils.getNetworkType(context);
//
//        if (netType == ConnectivityManager.TYPE_WIFI ||   // 当WIFI连接时
//                (netType == ConnectivityManager.TYPE_MOBILE && mCache.getAsString(Constant.MOBILE_ON) != null)) // 或使用移动网并且开启了3G模式
//        {
//            OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
//            okHttpUtils.sendDatafForClicent(context, API.REGISTER,
//                    params, callBack);
//        } else
//        {
//            callBack.onFinish();
//        }
    }
}
