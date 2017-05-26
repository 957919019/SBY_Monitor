package com.sby.widget.popupWindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.sby.practice.R;

import java.util.Calendar;

import cn.carbs.android.gregorianlunarcalendar.library.view.GregorianLunarCalendarView;

/**
 * 日历控件的popupWindow
 * Created by kowal on 2016/10/18.
 */
public class CalendarSelector implements View.OnTouchListener
{
    private Context mContext;
    private OnMediaClick mOnMediaClick;
    private PopupWindow mPopupWindow;
    private GregorianLunarCalendarView mGLCView;
    private Button bt_getDate;

    public CalendarSelector(Context context)
    {
        this.mContext = context;
    }

    /**
     * 显示Pop
     */
    public CalendarSelector showPop(View v)
    {
        if (null != mPopupWindow)
        {
            mPopupWindow.dismiss();
        } else
        {
            initWidget(v);
        }
        return this;
    }

    /**
     * 初始化控件 , 实现控件点击事件
     */
    private void initWidget(View v)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.popup_window_calendar_selector, null);
        mGLCView = (GregorianLunarCalendarView) view.findViewById(R.id.pop_window_calendar_view);
        bt_getDate = (Button) view.findViewById(R.id.pop_window_bt_getDate);
        // 初始化控件
        mGLCView.init();
        // 添加事件监听
        mGLCView.setOnDateChangedListener(new GregorianLunarCalendarView.OnDateChangedListener()
        {
            @Override
            public void onDateChanged(GregorianLunarCalendarView.CalendarData calendarData)
            {
                Calendar calendar = calendarData.getCalendar();
                // 公历
                String data = calendar.get(Calendar.YEAR) + "-"
                        + (calendar.get(Calendar.MONTH) + 1) + "-"
                        + calendar.get(Calendar.DAY_OF_MONTH);
                // 农历
//                        + "\n"
//                        + "Lunar     : " + calendar.get(ChineseCalendar.CHINESE_YEAR) + "-"
//                        + (calendar.get(ChineseCalendar.CHINESE_MONTH)) + "-"
//                        + calendar.get(ChineseCalendar.CHINESE_DATE);
            }
        });

        mPopupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        view.setOnTouchListener(this);//触摸事件 , 在其他区域触摸屏幕 , 取消popupwindow.
//        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());//保证popupwindow响应返回按钮事件.
        // 设置背景主要作用就是能够在返回键和点击其他区域时候能够隐藏PopupWindow
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置可点击
        mPopupWindow.setTouchable(true);
        // 设置点击空白区域取消PopupWindow，还要必须设置透明的背景才会生效
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        // 设置popWindow的显示和消失动画
        mPopupWindow.setAnimationStyle(R.style.pop_calendar_anim_style);
        mPopupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);//在底部显示popupwindow.
        // 完成按钮的动作监听
        bt_getDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mPopupWindow.dismiss();
                if (mOnMediaClick == null)
                {
                    return;
                }
                GregorianLunarCalendarView.CalendarData calendarData = mGLCView.getCalendarData();
                Calendar calendar = calendarData.getCalendar();
                String data = calendar.get(Calendar.YEAR) + "-"
                        + (calendar.get(Calendar.MONTH) + 1) + "-"
                        + calendar.get(Calendar.DAY_OF_MONTH);
                mOnMediaClick.onFinish(data);
            }
        });
    }

    public interface OnMediaClick
    {
        void onFinish(String data);
    }

    public void setOnMediaClick(OnMediaClick onMediaClick)
    {

        this.mOnMediaClick = onMediaClick;
    }

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
}