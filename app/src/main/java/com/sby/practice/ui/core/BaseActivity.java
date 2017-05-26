package com.sby.practice.ui.core;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyDialogListener;
import com.sby.utils.Logger;
import com.sby.utils.ToastUtil;


/**
 * 应用程序Activity的基类
 *
 * @author Created by kowal on 2016/10/25.
 */
public abstract class BaseActivity extends AppCompatActivity
{
    private BaseActivity mContext;
    private boolean isNetAca;
    private StyledDialog dialog;
    private ProgressDialog progressDialog = null;

    private String ClassName = getClass().getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().setStatusBarColor(getResources().getColor(android.R.color.holo_blue_light));
//            getWindow().setNavigationBarColor(getResources().getColor(android.R.color.holo_blue_light));
//        }
        Logger.w("当前----------------" + ClassName + "----------------正执行", "onCreate");
        super.onCreate(savedInstanceState);
        // 设置contentFeature,可使用切换动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Transition explode = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);
        getWindow().setEnterTransition(explode);

        ActivityCollector.addActivity(this);
        mContext = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 设置App只能竖屏显示
    }


    /**
     * 自定义吐司
     *
     * @param content
     */
    public void showToast(String content)
    {
        ToastUtil.toast(content);
    }


    public void showTopToast(Activity act, String string)
    {
        ToastUtil.topToast(act, string);
    }

    public void showToast(String content, int duration)
    {
        ToastUtil.toast(content, duration);
    }

    /**
     * 显示对话框
     */
    public void showDialog(String title, String msg, MyDialogListener listener)
    {
        dialog.buildIosAlert(this, title, msg, listener).show();
    }

    public void dismiasDialog()
    {
        if (dialog != null)
        {
            dialog.dismiss();
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Logger.w("当前----------------" + ClassName + "----------------正执行", "onStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Logger.w("当前----------------" + ClassName + "----------------正执行", "onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Logger.w("当前----------------" + ClassName + "----------------正执行", "onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Logger.w("当前----------------" + ClassName + "----------------正执行", "onStop");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Logger.w("当前----------------" + ClassName + "----------------正执行", "onRestart");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Logger.w("当前----------------" + ClassName + "----------------正执行", "onDestroy");
        ActivityCollector.removeActivity(this);
    }

    protected void showProgress(Context context,String title)
    {
        if (progressDialog == null)
        {
        progressDialog = ProgressDialog.show(context, "", title, false, true);
        }
    }
    protected void disProgress()
    {
        if (progressDialog != null)
        {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}


