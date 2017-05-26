package com.sby.application;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.sby.bean.user.User;
import com.sby.practice.R;
import com.sby.widget.OrientationSensor;

/**
 * 自定义Applicaion
 * Created by kowal on 2016/9/12.
 */
public class MyMapApplication extends Application
{
    public static OrientationSensor mOrientationSensor; // 方向感应器相关
    private static Context context;
    public static User user;

    @Override
    public void onCreate()
    {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(getApplicationContext());
        ToastMgr.builder.init(getApplicationContext()); // 单例Toast
        context = getApplicationContext();
    }

    /**
     * 单例Toast
     */
    public enum ToastMgr
    {
        builder;
        private View view;
        private TextView tv;
        private Toast toast;
        private ImageView iv;

        /**
         * 初始化Toast
         *
         * @param context
         */
        public void init(Context context)
        {
            view = LayoutInflater.from(context).inflate(R.layout.custom_toast_view, null);
            tv = (TextView) view.findViewById(R.id.custom_toast_view_text);
            iv = (ImageView) view.findViewById(R.id.custom_toast_view_img);
            toast = new Toast(context);
            toast.setGravity(Gravity.NO_GRAVITY, 100, 100);
            toast.setView(view);
        }

        /**
         * 显示Toast
         *
         * @param content
         * @param duration Toast持续时间
         */
        public void display(CharSequence content, int duration)
        {
            if (content.length() != 0)
            {
                tv.setText(content);
                tv.setTextColor(Color.WHITE);
                tv.setBackgroundResource(R.drawable.custom_toast_sharp);
                iv.setImageResource(android.R.color.black);
                toast.setDuration(duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }
    }

    /**
     * 全局Context
     *
     * @return
     */
    public static Context getContext()
    {
        return context;
    }
}
