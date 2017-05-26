package com.sby.practice.ui.view;

/**
 * 统计数据的View'
 * Created by kowal on 2016/12/4.
 */

public interface StatisticsDataView
{
    void showTip(String str); // 提示

    void showTodayData(); // 加载数据

    void showHistoryData(); // 加载历史数据选项

    void showFlightNum(); // 显示飞机编号

    String startDate();

    String endData();

    String getFilghtNum();

    String getPoile();

    void showPro();

    void disPro();

}
