package com.sby.practice.ui.aty.me;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.sby.practice.R;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.widget.CircleImageView;
import com.sby.widget.DialogQuit;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的
 */
public class MeActivity extends BaseActivity implements View.OnClickListener
{

    @BindView(R.id.activity_me_tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_pz_view)
    PullToZoomScrollViewEx pz_view;
    @BindView(R.id.activity_me_bt_logout)
    Button bt_logout;

    private Activity activity = MeActivity.this;
    private CircleImageView civ_head; // 修改头像
    private TextView tv_account, tv_companyName, tv_airportNum, tv_areaNum, tv_airNum; // 账户名称，公司名称，机场数量，作业区域数，运行飞机数
    private TextView tv_model;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ButterKnife.bind(this);
        initWeiget();
    }

    /**
     * 初始化控件
     */
    private void initWeiget()
    {
        //toolbar的控件
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pz_view = (PullToZoomScrollViewEx) findViewById(R.id.activity_pz_view);
        View headView = LayoutInflater.from(this).inflate(R.layout.activity_me_header_view, null, false);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.activity_me_header_image, null, false);
        View contentView = LayoutInflater.from(this).inflate(R.layout.activity_me_content_view, null, false);
        pz_view.setHeaderViewSize(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.MATCH_PARENT / 10);
        pz_view.setHeaderView(headView);
        pz_view.setZoomView(zoomView);
        pz_view.setScrollContentView(contentView);

        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        pz_view.setHeaderLayoutParams(localObject);

        civ_head = (CircleImageView) pz_view.getPullRootView().findViewById(R.id.activity_main_civ_head);
        civ_head.setOnClickListener(this);

        tv_account = (TextView) pz_view.getPullRootView().findViewById(R.id.activity_main_tv_account);
        tv_companyName = (TextView) pz_view.getPullRootView().findViewById(R.id.activity_me_tv_companyName);
        tv_airportNum = (TextView) pz_view.getPullRootView().findViewById(R.id.activity_me_tv_airportNum);
        tv_areaNum = (TextView) pz_view.getPullRootView().findViewById(R.id.activity_me_tv_areaNum);
        tv_airNum = (TextView) pz_view.getPullRootView().findViewById(R.id.activity_me_tv_airNum);
        tv_model = (TextView) pz_view.getPullRootView().findViewById(R.id.activity_me_tv_model);
        tv_model.setOnClickListener(this);
        bt_logout.setOnClickListener(this);
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.activity_main_civ_head: //修改头像
                showTopToast(activity, "头像功能暂未开放！");
                break;
            case R.id.activity_me_tv_model: // 飞机型号
                startActivity(new Intent(activity, FlightModelActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
            case R.id.activity_me_bt_logout: // 退出
                final DialogQuit selfDialog = new DialogQuit(activity);
                selfDialog.setYesOnclickListener("退出", new DialogQuit.onYesOnclickListener()
                {
                    @Override
                    public void onYesClick()
                    {
                        selfDialog.dismiss();
                        ActivityCollector.removeActivity(activity);
                        ActivityCollector.finishAll();
                    }
                });
                selfDialog.setNoOnclickListener("取消", new DialogQuit.onNoOnclickListener()
                {
                    @Override
                    public void onNoClick()
                    {
                        selfDialog.dismiss();
                    }
                });
                selfDialog.show();

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
