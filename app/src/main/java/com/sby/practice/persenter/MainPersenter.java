package com.sby.practice.persenter;

import android.app.Activity;
import android.content.Context;

/**
 * 主界面Persenter接口
 * Created by kowal on 2016/12/13.
 */

public interface MainPersenter
{
    /**
     * 获取所有飞机点
     */
    void getFlights(Context context);

    /**
     * 获取所有报告点
     */
    void getReportPoint(Context context);

    /**
     * 获取所有固定空域
     */
    void getFixedAirspace(Context context);

    /**
     * 获取所有护林航线
     */
    void getRangerRoute(Context context);

    /**
     * 获取所有农化机场
     */
    void getAirportConversion(Context context);

    /**
     * 获取所有护林机场
     */
    void getRangerAirport(Context context);

    /**
     * 获取所有民航机场
     */
    void getCivilAviationAirport(Context context);

    /**
     * 获取所有禁飞区
     */
    void getNoFlyZone(Context context);

    /**
     * 获取所有加油点
     */
    void getRefuelingPoint(Context context);

    /**
     * 获取所有民航航线
     */
    void getCivilAviationRoute(Context context);

    /**
     * 获取飞机筛选结果
     */
    void getFlightChoose(Context context);

    /**
     * 实时获取飞机飞行状态
     * @param activity
     */
    void getRelTimeFlt(Activity activity);
    /**
     * 实时获取飞机飞行状态
     * @param activity
     */
    void getMovingFlt(Activity activity, String start, String end);

    /***************************** 获取飞机筛选 *****************************/

//    /**
//     * 获取起降机场
//     */
//    void getQjJiang(Context context);
//
//    /**
//     * 获取飞机编号
//     */
//    void getFltNo(Context context);
//
//    /**
//     * 获取飞机型号
//     */
//    void getFltType(Context context);
//
//    /**
//     * 获取飞行员
//     */
//    void getFlter(Context context);
//
//    /**
//     * 获取作业类型
//     */
//    void getWorkType(Context context);
}
