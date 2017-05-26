package com.sby.practice.ui.aty.options;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.sby.practice.R;
import com.sby.practice.persenter.StatisticsDataPersenter;
import com.sby.practice.persenter.persenterImpl.StatisticsDataPersenterimpl;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.practice.ui.view.StatisticsDataView;
import com.sby.utils.DateUtils;
import com.sby.widget.popupWindow.CalendarSelector;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 统计数据
 */
public class StatisticsData extends BaseActivity implements StatisticsDataView
{
    @BindView(R.id.activity_statistics_data_tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_statistics_data_tv_flightNum) // 执行飞机数
            TextView tv_flightNum;
    @BindView(R.id.activity_statistics_data_sp_pilot) // 飞行员
            Spinner sp_pilot;
    @BindView(R.id.activity_statistics_data_tv_todayTime) // 飞行时长
            TextView tv_todayTime;
    @BindView(R.id.activity_statistics_data_tv_startTime) // 起始时间，结束时间
            TextView tv_startTime;
    @BindView(R.id.activity_statistics_data_tv_endTime)
    TextView tv_endTime;
    @BindView(R.id.activity_statistics_data_sp_flightNum) // 飞机编号
            Spinner sp_flightNum;
    @BindView(R.id.activity_statistics_data_sp_searchPilot) // 飞行员
            Spinner sp_searchPilot;
    @BindView(R.id.activity_statistics_data_bt_search) // 搜搜
            Button bt_search;
    @BindView(R.id.activity_statistics_data_tv_result) // 搜索结果
            TextView tv_result;

    private Activity activity = StatisticsData.this;
    private StatisticsDataPersenter statisticsDataPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_data);
        ButterKnife.bind(this);

        initWidget();
    }

    /**
     * 初始化控件
     */
    private void initWidget()
    {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        statisticsDataPersenter = new StatisticsDataPersenterimpl(this);
    }

    /**
     * 单击事件
     *
     * @param view
     */
    @OnClick({R.id.activity_statistics_data_tv_startTime,
            R.id.activity_statistics_data_tv_endTime,
            R.id.activity_statistics_data_bt_search})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.activity_statistics_data_tv_startTime:
                //选取开始时间
                new CalendarSelector(activity).showPop(view).setOnMediaClick(new CalendarSelector.OnMediaClick()
                {
                    @Override
                    public void onFinish(String data)
                    {

                        Date startTime = DateUtils.StrToDate(data); // 获取选择的值
                        // 比较选取的时间与本地时间(选取时间不得大于系统时间)
                        if (DateUtils.compareWithSyatemDate(startTime))
                        {
                            tv_startTime.setText(data);
                        } else
                        {
                            showToast(getString(R.string.re_choose_time_please));
                            tv_startTime.setText("");
                        }
                    }
                });
                break;
            case R.id.activity_statistics_data_tv_endTime:
                new CalendarSelector(activity).showPop(view).setOnMediaClick(new CalendarSelector.OnMediaClick()
                {
                    @Override
                    public void onFinish(String data)
                    {
                        Date endTime = DateUtils.strToDate(data);// 获取选择的值
                        // 比较选取的时间与本地时间(选取时间不得大于系统时间)
                        if (DateUtils.compareWithSyatemDate(endTime))
                        {
                            tv_endTime.setText(data);
                        } else
                        {
                            showToast(getString(R.string.re_choose_time_please));
                            tv_endTime.setText("");
                        }
                    }
                });
                break;
            // 搜索
            case R.id.activity_statistics_data_bt_search:
                showTopToast(activity, "功能暂未开发");
//                statisticsDataPersenter.getFlyTime(activity, 1, 1, startDate(), endData(), "token");
                break;
        }
    }

    /**
     * 标题栏动作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                ActivityCollector.removeActivity(activity);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        statisticsDataPersenter = null;
    }

    @Override
    public void showTip(String str)
    {
        showToast(str);
    }

    @Override
    public void showTodayData()
    {

    }

    @Override
    public void showHistoryData()
    {

    }

    @Override
    public void showFlightNum()
    {

    }

    @Override
    public String startDate()
    {
        return tv_startTime.getText().toString().trim();
    }

    @Override
    public String endData()
    {
        return tv_endTime.getText().toString().trim();
    }

    @Override
    public String getFilghtNum()
    {
        return null;
    }

    @Override
    public String getPoile()
    {
        return null;
    }

    @Override
    public void showPro()
    {
        showProgress(activity, "请稍后...");
    }

    @Override
    public void disPro()
    {
        disProgress();
    }
}
