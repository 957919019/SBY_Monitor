package com.sby.practice.persenter.persenterImpl;

import android.content.Context;

import com.sby.http.HttpException;
import com.sby.http.HttpRequestCallback;
import com.sby.practice.model.StatisticsDataModel;
import com.sby.practice.model.modelImol.StatisticsDataModelImpl;
import com.sby.practice.persenter.StatisticsDataPersenter;
import com.sby.practice.ui.view.StatisticsDataView;

import okhttp3.Call;

/**
 * Created by kowal on 2016/12/4.
 */

public class StatisticsDataPersenterimpl implements StatisticsDataPersenter
{
    private StatisticsDataView statisticsDataView;
    private StatisticsDataModel statisticsDataModel;

    public StatisticsDataPersenterimpl(StatisticsDataView statisticsDataView)
    {
        this.statisticsDataView = statisticsDataView;
        statisticsDataModel = new StatisticsDataModelImpl();
    }


    /**
     * 获取今日数据
     * @param context
     * @param token
     */
    @Override
    public void getTodayData(Context context, String token)
    {
        statisticsDataModel.getToday(context, token, new HttpRequestCallback()
        {
            @Override
            public void onStart()
            {
                statisticsDataView.showPro();
            }

            @Override
            public void onFinish()
            {
                statisticsDataView.showTip("无可用网络！");
            }

            @Override
            public void onResponse(Object o)
            {
                statisticsDataView.disPro();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                statisticsDataView.disPro();
                statisticsDataView.showTip(e.getMessage());
            }
        });
    }

    /**
     * 获取历史数据
     * @param context
     * @param token
     */
    @Override
    public void getHistoryData(Context context, String token)
    {
        statisticsDataModel.getHistory(context, token, new HttpRequestCallback()
        {
            @Override
            public void onStart()
            {
                statisticsDataView.showPro();
            }

            @Override
            public void onFinish()
            {
                statisticsDataView.showTip("无可用网络！");
            }

            @Override
            public void onResponse(Object o)
            {
                statisticsDataView.disPro();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                statisticsDataView.disPro();
                statisticsDataView.showTip(e.getMessage());
            }
        });
    }


    /**
     * 根据条件获取飞行时长
     * @param context
     * @param num 飞机编号
     * @param poileId 飞行员ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    @Override
    public void getFlyTime(Context context, int num, int poileId, String startTime, String endTime,String token)
    {
        statisticsDataModel.getFlyTimes(context, num, poileId, startTime, endTime, token, new HttpRequestCallback()
        {
            @Override
            public void onStart()
            {
                statisticsDataView.showPro();
            }

            @Override
            public void onFinish()
            {
                statisticsDataView.showTip("无可用网络！");
            }

            @Override
            public void onResponse(Object o)
            {
                statisticsDataView.disPro();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                statisticsDataView.disPro();
                statisticsDataView.showTip(e.getMessage());
            }
        });
    }
}
