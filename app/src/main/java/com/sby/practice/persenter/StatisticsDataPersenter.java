package com.sby.practice.persenter;

import android.content.Context;

/**
 * 统计数据persenter接口
 * Created by kowal on 2016/12/4.
 */

public interface StatisticsDataPersenter
{
    /**
     * 获取今天数据《包括在：执行飞机数，飞行员，飞机时长》
     * @param context
     * @param token
     */
    void getTodayData(Context context, String token);

    /**
     * 获取历史数据的搜索选项，包括：飞机编号，飞行员
     * @param context
     * @param token
     */
    void getHistoryData(Context context, String token);

    /**
     * 根据条件搜索飞行时长
     * @param context
     * @param num 飞机编号
     * @param poileId 飞行员ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    void getFlyTime(Context context, int num, int poileId,
                    String startTime, String endTime,String token);


}
