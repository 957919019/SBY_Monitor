package com.sby.widget.popupWindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sby.practice.R;

/**
 * Created by kowal on 2017/5/10.
 */

public class PopHomeMune implements View.OnClickListener
{
    private Context context;
    private PopupWindow mPopupWindow;
    private TextView im_plan_apply, im_plan_select, im_weather, im_qingbao;
    private OnClickFlagListener listener;

    public PopHomeMune(Context context)
    {
        this.context = context;
            mPopupWindow = new PopupWindow(context);
            mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mPopupWindow.setWidth(500);
            mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setTouchable(true);
            mPopupWindow.setFocusable(true);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setContentView(initWidget());
        mPopupWindow.setAnimationStyle(R.style.top_to_bottom);

            mPopupWindow.getContentView().setOnTouchListener(new View.OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    mPopupWindow.setFocusable(false);
                    mPopupWindow.dismiss();
                    return true;
                }
            });
    }

    public interface OnClickFlagListener
    {
        void getFlag(int flag);
    }

    public void setOnClickFlagListener(OnClickFlagListener listener)
    {
        this.listener = listener;
    }

    private View initWidget()
    {
        View view = LayoutInflater.from(context).inflate(R.layout.pop_home_mune, null);
        im_plan_apply = (TextView) view.findViewById(R.id.im_plan_apply);
        im_plan_apply.setOnClickListener(this);
        im_plan_select = (TextView) view.findViewById(R.id.im_plan_select);
        im_plan_select.setOnClickListener(this);
        im_weather = (TextView) view.findViewById(R.id.im_weather);
        im_weather.setOnClickListener(this);
        im_qingbao = (TextView) view.findViewById(R.id.im_qingbao);
        im_qingbao.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.im_plan_apply:
                listener.getFlag(0);
                break;
            case R.id.im_plan_select:
                listener.getFlag(1);
                break;
            case R.id.im_weather:
                listener.getFlag(2);
                break;
            case R.id.im_qingbao:
                listener.getFlag(3);
                break;
            default:
                break;
        }
    }

    public void dismiss()
    {
        if (mPopupWindow != null && mPopupWindow.isShowing())
        {
            mPopupWindow.dismiss();
        }
    }

    public void showPopup(View rootView)
    {
        // 第一个参数是要将PopupWindow放到的View，第二个参数是位置，第三第四是偏移值
//        int[] location = new int[2];
//        rootView.getLocationOnScreen(location);
//        mPopupWindow.showAtLocation(rootView, Gravity.NO_GRAVITY, location[0], location[1]-mPopupWindow.getHeight());
        mPopupWindow.showAsDropDown(rootView, Gravity.NO_GRAVITY, 50,0);
    }
}
