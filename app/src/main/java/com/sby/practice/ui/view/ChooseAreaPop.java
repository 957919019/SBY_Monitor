package com.sby.practice.ui.view;

/**
 * Created by kowal on 2017/4/18.
 */


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.sby.practice.R;
import com.sby.practice.adapter.PopupAreaDisplayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域选择
 * Created by kowal on 2016/10/21.
 */
public class ChooseAreaPop implements View.OnTouchListener
{
    private Context mContext;
    private List<Boolean> isSelect;
    private PopupWindow mPopupWindow;
    private RecyclerView rv_list;
    private OnItemClick mOnItemClick;
    private PopupAreaDisplayAdapter mAdapter;
    private List<String> list = new ArrayList<>();

    public ChooseAreaPop(Context context, List<Boolean> mSelect)
    {
        this.mContext = context;
        this.isSelect = mSelect;
    }

    /**
     * 显示Pop
     */
    public ChooseAreaPop showPop(View v)
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.popup_window_area_display_selector, null);
        rv_list = (RecyclerView) view.findViewById(R.id.pop_exp_layout_area_display_content_rv_list);

        list.add(mContext.getString(R.string.report_point));
        list.add(mContext.getString(R.string.fixed_airspace));
        list.add(mContext.getString(R.string.ranger_route));
        list.add(mContext.getString(R.string.airport_conversion));
        list.add(mContext.getString(R.string.ranger_airport));
        list.add(mContext.getString(R.string.civil_aviation_airport));
        list.add(mContext.getString(R.string.no_fly_zone));
        list.add(mContext.getString(R.string.refueling_point));
        list.add(mContext.getString(R.string.civil_aviation_route));



        rv_list.setLayoutManager(new GridLayoutManager(mContext, 3));
        rv_list.setAdapter(mAdapter = new PopupAreaDisplayAdapter(mContext, list, isSelect));

        mPopupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        view.setOnTouchListener(this);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置可点击
        mPopupWindow.setTouchable(true);
        // 设置点击空白区域取消PopupWindow，还要必须设置透明的背景才会生效
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
//        mPopupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        mPopupWindow.showAsDropDown(v, 0, mContext.getResources().getDimensionPixelSize(R.dimen.y2));
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

    public interface OnItemClick
    {
        void onBack(  );
    }

    public void setOnMediaClick(OnItemClick onMediaClick)
    {

        this.mOnItemClick = onMediaClick;
    }

    public PopupAreaDisplayAdapter getmAdapter()
    {
        return mAdapter;
    }
}

