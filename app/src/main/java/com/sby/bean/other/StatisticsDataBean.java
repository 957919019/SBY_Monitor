package com.sby.bean.other;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kowal on 2016/12/4.
 */

public class StatisticsDataBean implements Serializable
{
    private int carryoutFilght; // 执行飞机数
    private List<PoileBean> poileList; // 飞行员集合
    private String todayFlightTime; // 今日飞行时长

    private List<FlightBean> flightBeen; // 飞机编号集合
    private List<PoileBean> poileLists; // 搜索的飞行员集合

}
