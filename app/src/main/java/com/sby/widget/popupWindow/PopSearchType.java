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

public class PopSearchType implements View.OnClickListener
{
    private Context context;
    private PopupWindow mPopupWindow;
    private TextView tv_all, tv_num, tv_name, tv_type;
    private OnClickFlagListener listener;

    public PopSearchType(Context context)
    {
        this.context = context;
            mPopupWindow = new PopupWindow(context);
            mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mPopupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setTouchable(true);
            mPopupWindow.setFocusable(true);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setContentView(initWidget());

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
        View view = LayoutInflater.from(context).inflate(R.layout.pop_search_type, null);
        tv_all = (TextView) view.findViewById(R.id.tv_all);
        tv_all.setOnClickListener(this);
        tv_num = (TextView) view.findViewById(R.id.tv_num);
        tv_num.setOnClickListener(this);
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        tv_name.setOnClickListener(this);
        tv_type = (TextView) view.findViewById(R.id.tv_type);
        tv_type.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_all:
                listener.getFlag(0);
                break;
            case R.id.tv_num:
                listener.getFlag(1);
                break;
            case R.id.tv_name:
                listener.getFlag(2);
                break;
            case R.id.tv_type:
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
        mPopupWindow.showAsDropDown(rootView, Gravity.NO_GRAVITY, 40,0);
    }
}
