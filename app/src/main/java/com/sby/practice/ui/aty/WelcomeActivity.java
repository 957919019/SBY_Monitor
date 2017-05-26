package com.sby.practice.ui.aty;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.Button;

import com.sby.constant.Constant;
import com.sby.practice.R;
import com.sby.practice.ui.aty.user.LoginActivity;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends BaseActivity
{
    @BindView(R.id.bt_start)
    Button bt_start;
    private Activity activity = WelcomeActivity.this;
    private TimeCount timer = new TimeCount(2000, 1000);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BlueTheme);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        timer.start();
    }

    @OnClick(R.id.bt_start)
    public void onViewClicked()
    {
        timer.onFinish();
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        ActivityCollector.removeActivity(activity);
    }

    class TimeCount extends CountDownTimer
    {
        public TimeCount(long millisInFuture, long countDownInterval)
        {
            super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish()
        {
            bt_start.setText("点击跳过(0s)");
            // 计时完毕时触发
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK), ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
            ActivityCollector.removeActivity(activity);
        }

        @Override
        public void onTick(long millisUntilFinished)
        {// 计时过程显示
            bt_start.setText("点击跳过(" + millisUntilFinished / 1000 + "s)");
        }
    }

    /**
     * 返回键的监听事件
     *
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if ((System.currentTimeMillis() - Constant.exitTime) > 2000)
            {
                ToastUtil.topToast(activity, getString(R.string.press_again_to_exit));
                Constant.exitTime = System.currentTimeMillis();
                return false;
            } else
            {
                finish();
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        timer.cancel();
        timer = null;
    }
}
