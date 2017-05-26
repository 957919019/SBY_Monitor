package com.sby.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.Button;

import com.sby.practice.R;


/**
 * 带倒计时的按钮
 * Created by kowal on 2016/10/13.
 */
public class CountDownTimerButton extends Button
{
    private Drawable mNormalBackground;
    private Drawable mDisableBackground;

    // 总倒计时时间
    private static final long MILLIS_IN_FUTURE = 60 * 1000;
    // 每次减去1秒
    private static final long COUNT_DOWN_INTERVAL = 1000;

    public CountDownTimerButton(Context context)
    {
        this(context, null);
    }

    public CountDownTimerButton(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public CountDownTimerButton(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // 初始化
    private void init(Context context, AttributeSet attrs)
    {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CountDownTimerButton);
        mNormalBackground = a.getDrawable(R.styleable.CountDownTimerButton_normalBackground);// 默认背景
        mDisableBackground = a.getDrawable(R.styleable.CountDownTimerButton_disableBackground);// 不可点击时的背景
        setBackgroundDrawable(mNormalBackground);
    }

    // 启动倒计时
    public void startCountDown()
    {
        // 设置按钮为不可点击，并修改显示背景
        setEnabled(false);
        setBackgroundDrawable(mDisableBackground);
        // 开始倒计时
        new CountDownTimer(MILLIS_IN_FUTURE, COUNT_DOWN_INTERVAL)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                // 刷新文字
                setText(getContext().getString(R.string.reget_sms_code_countdown, millisUntilFinished / COUNT_DOWN_INTERVAL));
            }

            @Override
            public void onFinish()
            {
                // 重置文字，并恢复按钮为可点击
                setText(R.string.reget_sms_code);
                setEnabled(true);
                setBackgroundDrawable(mNormalBackground);
            }
        }.start();
    }
}
