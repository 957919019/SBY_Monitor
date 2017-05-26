package com.sby.practice.model;

import android.content.Context;

import com.sby.http.HttpRequestCallback;


/**
 * Created by kowal on 2016/12/4.
 */

public interface StatisticsDataModel
{
    /**
     * 获取今天数据《包括在：执行飞机数，飞行员，飞机时长》
     * @param context
     * @param token
     */
    void getToday(Context context, String token,HttpRequestCallback callBack);

    /**
     * 获取历史数据的搜索选项，包括：飞机编号，飞行员
     * @param context
     * @param token
     */
    void getHistory(Context context, String token, HttpRequestCallback callBack);

    /**
     * 根据条件搜索飞行时长
     * @param context
     * @param num 飞机编号
     * @param poileId 飞行员ID
     * @param startTime 开始时间
     * @param token token
     * @param endTime 结束时间
     */
    void getFlyTimes(Context context, int num, int poileId,
                    String startTime, String endTime, String token, HttpRequestCallback  callBack);
}
