package com.sby.utils;

import android.app.Activity;
import android.view.Gravity;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperToast;
import com.sby.application.MyMapApplication;
import com.sby.practice.R;

/** 自定义吐司
 * Created by kowal on 2016/11/15.
 */

public class ToastUtil
{
    /**
     * 显示toast
     * @param content  内容
     * @param duration  持续时间
     */
    public static void toast(String content , int duration){
        if (content == null) {
            return;
        }else {
            MyMapApplication.ToastMgr.builder.display(content, duration);
        }
    }
    /**
     * 显示默认持续时间为short的Toast
     * @param content  内容
     */
    public static void toast(String content){
        if (content == null) {
            return;
        }else {
            MyMapApplication.ToastMgr.builder.display(content, Toast.LENGTH_SHORT);
        }
    }

    public static void topToast(Activity activity, String str)
    {
        new SuperToast(activity)
                .setText(str)
                .setDuration(Style.DURATION_SHORT)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(activity.getResources().getColor(R.color.deepred))
                .setAnimations(Style.ANIMATIONS_FLY).setGravity(Gravity.TOP)
                .show();
    }
}
