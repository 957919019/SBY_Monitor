package com.sby.practice.ui.aty.options;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sby.constant.Constant;
import com.sby.practice.R;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.utils.ACache;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sby.constant.Constant.KNOT;

/**
 * 设置
 */
public class SettingActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener
{
    @BindView(R.id.activity_setting_tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_setting_sc_display) // 飞机标签显示
            SwitchCompat sc_display;
    @BindView(R.id.activity_setting_sc_network) // 网络模式切换
            SwitchCompat sc_network;
    //    @BindView(R.id.activity_setting_sc_hand) // 习惯手
//    SwitchCompat sc_hand;
    @BindView(R.id.activity_setting_rg_speed) // 速度
            RadioGroup rg_speed;
    @BindView(R.id.activity_setting_rb_knots)
    RadioButton rb_knots;
    @BindView(R.id.activity_setting_rb_km)
    RadioButton rb_km;
    @BindView(R.id.activity_setting_rb_mph)
    RadioButton rb_mph;
    @BindView(R.id.activity_setting_rg_altitude) // 海拔
            RadioGroup rg_altitude;
    @BindView(R.id.activity_setting_rb_feet)
    RadioButton rb_feet;
    @BindView(R.id.activity_setting_rb_mi)
    RadioButton rb_mi;
    @BindView(R.id.activity_setting_rg_distancetion) // 距离
            RadioGroup rg_distancetion;
    @BindView(R.id.activity_setting_dis_rb_kilometer)
    RadioButton rb_kilometer;
    @BindView(R.id.activity_setting_dis_rb_metres)
    RadioButton rb_metres;
    @BindView(R.id.activity_setting_dis_rb_mile)
    RadioButton rb_mile;

    private Activity activity = SettingActivity.this;
    private ACache mCache;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);
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

        mCache = ACache.get(activity);
        // 飞机标签显示
        String isLabelOn = mCache.getAsString(Constant.LABEL_ON);
        if (isLabelOn != null)
        {
            sc_display.setChecked(true);
        }
        String isMobile = mCache.getAsString(Constant.MOBILE_ON); // 网络模式

        if (isMobile != null)
        {
            sc_network.setChecked(true);
        }
        // 速度
        String speed = mCache.getAsString(Constant.SPEED);
        if (speed != null)
        {
            switch (speed)
            {
                case Constant.KNOT:
                    rb_knots.setChecked(true);
                    break;
                case Constant.KM:
                    rb_km.setChecked(true);
                    break;
                case Constant.MPH:
                    rb_mph.setChecked(true);
                    break;
            }
        }
        // 海拔
        String altitude = mCache.getAsString(Constant.ALTITUDE);
        if (altitude != null)
        {
            switch (altitude)
            {
                case Constant.FEET:
                    rb_feet.setChecked(true);
                    break;
                case Constant.MI:
                    rb_mi.setChecked(true);
                    break;
            }
        }
        // 距离
        String distance = mCache.getAsString(Constant.DISTANCE);
        if (distance != null)
        {
            switch (distance)
            {
                case Constant.KILOMETER:
                    rb_kilometer.setChecked(true);
                    break;
                case Constant.METRES:
                    rb_metres.setChecked(true);
                    break;
                case Constant.MILE:
                    rb_mile.setChecked(true);
                    break;
            }
        }


        sc_display.setOnCheckedChangeListener(this);
        sc_network.setOnCheckedChangeListener(this);
//        sc_hand.setOnCheckedChangeListener(this);

        rg_speed.setOnCheckedChangeListener(this);
        rg_altitude.setOnCheckedChangeListener(this);
        rg_distancetion.setOnCheckedChangeListener(this);
    }

    /**
     * CompantSwitch监听事件
     *
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        switch (buttonView.getId())
        {
            case R.id.activity_setting_sc_display: // 飞机标签显示
                if (isChecked)
                {
                    showTopToast(activity,getString(R.string.label_on));
                    mCache.put(Constant.LABEL_ON, Constant.LABEL_ON);
                } else
                {
                    showTopToast(activity,getString(R.string.label_off));
                    mCache.remove(Constant.LABEL_ON);
                }
                break;
            case R.id.activity_setting_sc_network:// 3/4G模式切换
                if (isChecked)
                {
                    mCache.put(Constant.MOBILE_ON, Constant.MOBILE_ON);
                    showTopToast(activity,getString(R.string.mobile_on_tip));
                } else
                {
                    mCache.remove(Constant.MOBILE_ON);
                    showTopToast(activity,getString(R.string.mobile_off_tip));
                }
                break;
//            case R.id.activity_setting_sc_hand: // 左右手
//                if (isChecked)
//                {
//                    showToast("开启了左手模式");
//                } else
//                {
//                    showToast("开启了右手模式");
//                }
//                break;
        }
    }

    /**
     * Group监听事件
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch (checkedId)
        {   // 速度
            case R.id.activity_setting_rb_knots: // knots
                mCache.put(Constant.SPEED, KNOT);
                break;
            case R.id.activity_setting_rb_km: // km/h
                mCache.put(Constant.SPEED, Constant.KM);
                break;
            case R.id.activity_setting_rb_mph: // mph
                mCache.put(Constant.SPEED, Constant.MPH);
                break;
            // 海拔
            case R.id.activity_setting_rb_feet: // 英尺
                mCache.put(Constant.ALTITUDE, Constant.FEET);
                break;
            case R.id.activity_setting_rb_mi: // 米
                mCache.put(Constant.ALTITUDE, Constant.MI);
                break;
            // 距离
            case R.id.activity_setting_dis_rb_kilometer: // 千米
                mCache.put(Constant.DISTANCE, Constant.KILOMETER);
                break;
            case R.id.activity_setting_dis_rb_metres: // 米
                mCache.put(Constant.DISTANCE, Constant.METRES);
                break;
            case R.id.activity_setting_dis_rb_mile: // 海里
                mCache.put(Constant.DISTANCE, Constant.MILE);
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
