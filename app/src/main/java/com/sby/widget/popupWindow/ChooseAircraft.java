package com.sby.widget.popupWindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Spinner;

import com.sby.practice.R;
import com.sby.practice.adapter.ChooseFlightAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择飞机
 * Created by kowal on 2016/10/31.
 */

public class ChooseAircraft implements View.OnTouchListener, View.OnClickListener
{
    private Context mContext;
    private PopupWindow mPopupWindow;

    // 通航公司  起降机场  飞机型号  飞机编号  飞行员  作业类型
    private Spinner  sp_airport, sp_model, sp_number, sp_pilot, sp_type;
    private CardView cv_ok; // 确认
    private Callback mCallback;

    // 航空公司  机场  飞机型号  飞机编号  飞行员  作业类型
    private List<String>  aList , mList , nList , pList , tList ;
    private ChooseFlightAdapter aAdapter, mAdapter, nAdapter, pAdapter, tAdapter;


    /**
     * 显示Pop
     */
    public ChooseAircraft showPop(View v)
    {
        if (null != mPopupWindow)
        {
            mPopupWindow.dismiss();
        } else
        {
            initWidget(v);
            getData();
            setData();
        }
        return this;
    }

    /**
     * 初始化控件
     */
    private void initWidget(View v)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.popup_window_choose_flight, null);
        sp_airport = (Spinner) view.findViewById(R.id.pop_window_choose_flight_sp_airport);
        sp_model = (Spinner) view.findViewById(R.id.pop_window_choose_flight_sp_model);
        sp_number = (Spinner) view.findViewById(R.id.pop_window_choose_flight_sp_number);
        sp_pilot = (Spinner) view.findViewById(R.id.pop_window_choose_flight_sp_pilot);
        sp_type = (Spinner) view.findViewById(R.id.pop_window_choose_flight_sp_type);
        cv_ok = (CardView) view.findViewById(R.id.pop_window_choose_flight_cv_ok); // 确认
        cv_ok.setOnClickListener(this);

        mPopupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        // 设置背景主要作用就是能够在返回键和点击其他区域时候能够隐藏PopupWindow
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置可点击
        mPopupWindow.setTouchable(true);
        // 设置点击空白区域取消PopupWindow，还要必须设置透明的背景才会生效
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        // 设置popWindow的显示和消失动画
        mPopupWindow.setAnimationStyle(R.style.pop_calendar_anim_style);
        mPopupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);//在底部显示popupwindow.
    }

    /**
     * 触摸关闭
     */
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (null != mPopupWindow && mPopupWindow.isShowing())
        {
            mPopupWindow.dismiss();
            mPopupWindow = null;
        }
        return false;
    }

    /**
     * 关闭Pop
     */
    public boolean disMissPop()
    {
        boolean isshowing = false;
        if (null != mPopupWindow)
        {
            isshowing = mPopupWindow.isShowing();
            mPopupWindow.dismiss();
        }
        return isshowing;
    }

    public interface Callback
    {
        void click(View v, List<String> list);
    }

    public ChooseAircraft(Context context, Callback callback)
    {
        this.mContext = context;
        this.mCallback = callback;
    }

    /**
     * 初始化数据
     */
    private void getData()
    {
        aList = new ArrayList<>();// 起降机场
        aList.add("首都机场");
        aList.add("浦东国际机场");
        aList.add("虹桥国际机场");
        mList = new ArrayList<>();// 飞机型号
        mList.add("战斗机");
        mList.add("BB机");
        nList = new ArrayList<>();// 飞机编号
        nList.add("89757");
        nList.add("89758");
        nList.add("89759");
        pList = new ArrayList<>();// 飞行员
        pList.add("杨利伟");
        pList.add("阿姆斯特朗");
        tList = new ArrayList<>();// 作业类型
        tList.add("家庭作业");
        tList.add("户外作业");
        tList.add("寒假作业");
        tList.add("暑假作业");
    }

    /**
     * 初始化适配器
     */
    public void setData()
    {
        // 起降机场
        aAdapter = new ChooseFlightAdapter(mContext, aList);
        sp_airport.setAdapter(aAdapter);
        // 飞机型号
        mAdapter = new ChooseFlightAdapter(mContext, mList);
        sp_model.setAdapter(mAdapter);
        // 飞机编号
        nAdapter = new ChooseFlightAdapter(mContext, nList);
        sp_number.setAdapter(nAdapter);
        // 飞行员
        pAdapter = new ChooseFlightAdapter(mContext, pList);
        sp_pilot.setAdapter(pAdapter);
        // 作业类型
        tAdapter = new ChooseFlightAdapter(mContext, tList);
        sp_type.setAdapter(tAdapter);

    }

    public List<String> getList()
    {
        List<String> valueList = new ArrayList<>();
        valueList.add(sp_airport.getSelectedItem().toString());
        valueList.add(sp_model.getSelectedItem().toString());
        valueList.add(sp_number.getSelectedItem().toString());
        valueList.add(sp_pilot.getSelectedItem().toString());
        valueList.add(sp_type.getSelectedItem().toString());
        return valueList;
    }

    @Override
    public void onClick(View v)
    {
        mCallback.click(v, getList());
    }

}
