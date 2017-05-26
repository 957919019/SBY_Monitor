package com.sby.practice.model;

import android.app.Activity;
import android.content.Context;

import com.sby.http.HttpRequestCallback;


/**
 * 主界面model接口
 * Created by kowal on 2016/12/13.
 */

public interface MainModel
{
    /**
     * 获取所有飞机点
     */
    void getFlights(Context context,String token, HttpRequestCallback callback);

    /**
     * 报告点
     */
    void getReportPoint(Context context, String token,HttpRequestCallback  callback);

    /**
     * 固定空域
     */
    void getFixedAirspace(Context context,String token, HttpRequestCallback callback);

    /**
     * 护林航线
     */
    void getRangerRoute(Context context,String token, HttpRequestCallback  callback);

    /**
     * 农化机场
     */
    void getAirportConversion(Context context,String token, HttpRequestCallback callback);

    /**
     * 护林机场
     */
    void getRangerAirport(Context context, String token,HttpRequestCallback callback);

    /**
     * 民航机场
     */
    void getCivilAviationAirport(Context context,String token, HttpRequestCallback callback);

    /**
     * 禁飞区
     */
    void getNoFlyZone(Context context,String token, HttpRequestCallback callback);

    /**
     * 加油点
     */
    void getRefuelingPoint(Context context,String token, HttpRequestCallback callback);

    /**
     * 民航航线
     */
    void getCivilAviationRoute(Context context,String token, HttpRequestCallback callback);

    /**
     * 获取飞机筛选结果
     */
    void getFlightChoose(Context context,String token, HttpRequestCallback callback);

    /**
     * 获取起降机场
     */
    void getQjJiang(Context context,String token,HttpRequestCallback callback);

    /**
     * 获取飞机编号
     */
    void getFltNo(Context context,String token,HttpRequestCallback callback);

    /**
     * 获取飞机型号
     */
    void getFltType(Context context,String token,HttpRequestCallback callback);

    /**
     * 获取飞行员
     */
    void getFlter(Context context,String token,HttpRequestCallback callback);

    /**
     * 获取作业类型
     */
    void getWorkType(Context context,String token,HttpRequestCallback callback);

    void getRelTimeFlt(Activity activity, String token, HttpRequestCallback callback);

    void getMovingFlt(Activity activity, String start, String end ,HttpRequestCallback callback);
}
