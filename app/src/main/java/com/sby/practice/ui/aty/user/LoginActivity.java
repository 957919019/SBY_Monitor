package com.sby.practice.ui.aty.user;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.sby.application.MyMapApplication;
import com.sby.bean.user.User;
import com.sby.practice.R;
import com.sby.practice.persenter.LoginPersenter;
import com.sby.practice.persenter.persenterImpl.LoginPersenterImpl;
import com.sby.practice.ui.aty.MainActivity;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.practice.ui.view.LoginView;
import com.sby.utils.ACache;
import com.sby.utils.PhoneUtils;
import com.sby.utils.RegularExpressionUtiils;
import com.sby.widget.popupWindow.ConnectToService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity implements LoginView
{
    @BindView(R.id.activity_login_et_account)
    EditText et_account; // 输入的账户
    @BindView(R.id.activity_login_et_pwd)
    EditText et_pwd; // 输入的密码
    @BindView(R.id.activity_login_tv_forgetPwd)
    TextView tv_forgetPwd; // 忘记密码
    @BindView(R.id.activity_login_bt_login)
    Button bt_login; // 登录
    @BindView(R.id.activity_login_tv_regAccount)
    Button tv_regAccount;  // 注册账户
    @BindView(R.id.rl_service)
    LinearLayout rl_service; // 联系客服
    @BindView(R.id.activity_login_ll_all)
    LinearLayout ll_all;

    private Activity activity = LoginActivity.this;
    ACache mAcache;
    private LoginPersenter loginPersenter;
    private boolean isPhone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BlueTheme);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPersenter = new LoginPersenterImpl(this);
//        setAction();
    }

    private void setAction()
    {
        et_account.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    String account = et_account.getText().toString().trim();
                    if (account.length() == 11)
                    {
                        isPhone = RegularExpressionUtiils.isChinaPhoneLegal(account);
                        if (!isPhone)
                        {
                            showTopToast(activity, "当前电话号码不可用");
                        }
                    } else
                    {
                        isPhone = false;
                        showTopToast(activity, "当前电话号码不可用");
                    }
                }
            }
        });
    }

    /**
     * 点击事件
     *
     * @param
     */
    @OnClick({R.id.activity_login_tv_forgetPwd,
            R.id.activity_login_bt_login,
            R.id.activity_login_tv_regAccount,
            R.id.rl_service})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.activity_login_tv_forgetPwd: // 忘记密码
                startActivity(new Intent(activity, FindPwdActivity.class));
                break;
            case R.id.activity_login_tv_regAccount: // 注册
                startActivity(new Intent(activity, RegisterActivity.class)
//                                .setFlags(FLAG_ACTIVITY_CLEAR_TASK), ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
                );
                break;
            case R.id.activity_login_bt_login: // 登录
//                startActivity(new Intent(activity, MainActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TASK));
//                finish();
                loginPersenter.signIn(activity, getCoName(), getPwd());
                break;
            case R.id.rl_service:
                final ConnectToService ctDialog = new ConnectToService(activity);
                ctDialog.showPopup(bt_login);
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
//                                                showToast( permissions.toString() + "权限被拒绝,请在设备权限管理开启相关权限！");
                                            }
                                        });
                            } else
                            {
                                showToast("此功能仅限手机使用");
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
     * 点击空白内容键盘消失
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
        {
            InputMethodManager imm = (InputMethodManager) MyMapApplication.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
            {
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public String getCoName()
    {
        return et_account.getText().toString().trim();
    }

    @Override
    public String getPwd()
    {
        return et_pwd.getText().toString().trim();
    }

    @Override
    public void loginSucc(User user)
    {
        mAcache = ACache.get(activity);
        mAcache.put("user", user);

        MyMapApplication.user = user;
        startActivity(new Intent(activity, MainActivity.class).addFlags(FLAG_ACTIVITY_CLEAR_TASK));
        finish();
    }

    @Override
    public void showTip(String str)
    {
        showToast(str);
    }

    @Override
    protected void onDestroy()
    {
        loginPersenter = null;
        super.onDestroy();
    }

    @Override
    public void showPro()
    {
        showProgress(activity, "正在请求，请稍后...");
    }

    @Override
    public void disPro()
    {
        disProgress();
    }
}