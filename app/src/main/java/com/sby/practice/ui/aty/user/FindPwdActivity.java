package com.sby.practice.ui.aty.user;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.sby.practice.R;
import com.sby.practice.persenter.FindPwdPersenter;
import com.sby.practice.persenter.persenterImpl.FindPwdPersenterImpl;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.practice.ui.view.FindPwdView;
import com.sby.utils.PhoneUtils;
import com.sby.widget.popupWindow.ConnectToService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 忘记密码
 */
public class FindPwdActivity extends BaseActivity implements FindPwdView
{

    @BindView(R.id.tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_phone)
    EditText et_phone;
    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.et_repwd)
    EditText et_repwd;
    @BindView(R.id.et_code)
    EditText et_code;
    @BindView(R.id.bt_getcode)
    Button bt_getcode;
    @BindView(R.id.bt_find)
    Button bt_find;
    @BindView(R.id.ll_service)
    LinearLayout ll_service;

    private Activity activity = FindPwdActivity.this;
    private FindPwdPersenter findPwdPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
        initWidget();
    }

    /**
     * 初始化控件
     */
    private void initWidget()
    {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findPwdPersenter = new FindPwdPersenterImpl(this);
    }

    /**
     * 点击事件
     *
     * @param
     */
    @OnClick({R.id.bt_getcode,
            R.id.bt_find,
            R.id.ll_service})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_getcode:
                findPwdPersenter.getVCode(activity, getPhone());
                break;
            case R.id.bt_find:
                findPwdPersenter.onFindPwd(activity, getPhone(), getVCode(), getPwd());
                break;
            case R.id.ll_service:
                final ConnectToService ctDialog = new ConnectToService(activity);
                ctDialog.showPopup(ll_service);
                ctDialog.setOnClickFlagDialogListener(new ConnectToService.OnClickFlagDialogListener()
                {
                    @Override
                    public void getFlag(int flag)
                    {
                        if (flag == 0)
                        {
                            ctDialog.dismiss();
                            if (PhoneUtils.isTablet(activity) != true) // 如果不是平板
                            {
                                Acp.getInstance(activity).request(new AcpOptions.Builder().setPermissions(Manifest.permission.CALL_PHONE).build(),
                                        new AcpListener()
                                        {
                                            @Override
                                            public void onGranted()
                                            {
                                                Intent intent = new Intent();
                                                intent.setAction(Intent.ACTION_CALL);
                                                intent.setData(Uri.parse("tel:" + getResources().getString(R.string.customer_service_telephone_numbers)));
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onDenied(List<String> permissions)
                                            {
                                                showTopToast(activity, permissions.toString() + "权限被拒绝,请在设备权限管理开启相关权限！");
                                            }
                                        });
                            } else
                            {
                                showTopToast(activity, "此功能仅限手机使用");
                            }
                        }
                        if (flag == 1)
                        {
                            ctDialog.dismiss();
                        }
                    }
                });
                break;
        }
    }


    /**
     * 标题栏动作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                ActivityCollector.removeActivity(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        bt_getcode = null;
        findPwdPersenter = null;
    }

    @Override
    public String getPhone()
    {
        return et_phone.getText().toString().trim();
    }

    @Override
    public String getVCode()
    {
        return et_code.getText().toString().trim();
    }

    @Override
    public String getPwd()
    {
        return et_repwd.getText().toString().trim();
    }

    @Override
    public void findSucc()
    {
        showTopToast(activity, "请牢记您的密码");
        ActivityCollector.removeActivity(activity);
        finish();
    }

    @Override
    public void sendSucc()
    {
//        bt_getcode.startCountDown();
    }

    @Override
    public void showTip(String str)
    {
        showTopToast(activity, str);
    }

    @Override
    public void showPro()
    {
        showProgress(activity, "请稍后...");
    }

    @Override
    public void disPro()
    {
        disProgress();
    }

}
