package com.sby.utils;

import android.content.Context;
import android.widget.Button;

import com.sby.practice.R;

/**
 * Created by kowal on 2017/5/19.
 */

public class ButtonStyleUtils
{
    /**
     * 改变按钮样式
     */
    public static void changeButtonStyle(Context context, Button bt_quyu, Button bt_choose, Button bt_my)
    {
        if (null != bt_quyu)
        {
            bt_quyu.setBackgroundResource(R.color.deep_blue);
            bt_quyu.setTextColor(context.getResources().getColor(R.color.white));
            bt_quyu.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.nic_rb_qyxs_press, 0, 0, 0);
        }
        if (null != bt_choose)
        {
            bt_choose.setBackgroundResource(R.color.deep_blue);
            bt_choose.setTextColor(context.getResources().getColor(R.color.white));
            bt_choose.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.nic_rb_choose_press, 0, 0, 0);
        }
        if (null != bt_my)
        {
            bt_my.setBackgroundResource(R.color.deep_blue);
            bt_my.setTextColor(context.getResources().getColor(R.color.white));
            bt_my.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.nic_rb_my_press, 0, 0, 0);
        }

    }

    public static void resetButtonStyle(Context context, Button bt_quyu, Button bt_choose, Button bt_my)
    {
        if (null != bt_quyu)
        {
            bt_quyu.setBackgroundResource(R.color.white);
            bt_quyu.setTextColor(context.getResources().getColor(R.color.black));
            bt_quyu.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.nic_rb_qyxs, 0, 0, 0);
        }
        if (null != bt_choose)
        {
            bt_choose.setBackgroundResource(R.color.white);
            bt_choose.setTextColor(context.getResources().getColor(R.color.black));
            bt_choose.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.nic_rb_choose, 0, 0, 0);
        }
        if (null != bt_my)
        {
            bt_my.setBackgroundResource(R.color.white);
            bt_my.setTextColor(context.getResources().getColor(R.color.black));
            bt_my.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.nic_rb_my, 0, 0, 0);
        }
    }
}
