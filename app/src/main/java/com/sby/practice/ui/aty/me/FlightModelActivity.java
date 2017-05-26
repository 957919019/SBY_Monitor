package com.sby.practice.ui.aty.me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sby.bean.other.FlightBean;
import com.sby.practice.R;
import com.sby.practice.adapter.FlightModelAdapter;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.widget.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 飞机型号
 */
public class FlightModelActivity extends BaseActivity
{
    @BindView(R.id.activity_flight_model_tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private Activity activity = FlightModelActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_model);
        ButterKnife.bind(this);
        initWeiget();
    }

    private void initWeiget()
    {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(activity));
        rv_list.addItemDecoration(new DividerItemDecoration(
                activity, DividerItemDecoration.HORIZONTAL_LIST));

        List<FlightBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            FlightBean flightBean = new FlightBean();
            flightBean.setFltModel("小鹰-" + i + "");
            Random a = new Random(i);
            flightBean.setFlightNum(a.nextInt());
            list.add(flightBean);
        }

        rv_list.setAdapter(new FlightModelAdapter(activity, list));
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
                activity.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

}
