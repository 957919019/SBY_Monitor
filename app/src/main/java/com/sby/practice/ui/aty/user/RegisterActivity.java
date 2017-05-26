package com.sby.practice.ui.aty.user;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.sby.constant.Constant;
import com.sby.practice.R;
import com.sby.practice.persenter.RegisterPersenter;
import com.sby.practice.persenter.persenterImpl.RegisterPersenterImpl;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.practice.ui.view.RegisterView;
import com.sby.utils.PhoneUtils;
import com.sby.utils.StringUtil;
import com.sby.widget.popupWindow.ConnectToService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册界面
 */
public class RegisterActivity extends BaseActivity implements RegisterView
{

    @BindView(R.id.tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_account)
    TextView tv_account;
    @BindView(R.id.et_phone)
    EditText et_phone;
    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.et_code)
    EditText et_code;
    @BindView(R.id.bt_getcode)
    Button bt_getcode;
    @BindView(R.id.bt_register)
    Button bt_register;
    @BindView(R.id.ll_service)
    LinearLayout ll_service;
    @BindView(R.id.rl_all)
    RelativeLayout rl_all;

    RelativeLayout activityRegester;
    private Activity activity = RegisterActivity.this;
    private RegisterPersenter registerPersenter;

    private boolean phoneIsEnable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);
        ButterKnife.bind(this);
        initWidget();
        setAction();
    }

    /**
     * 初始化控件
     */
    private void initWidget()
    {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        registerPersenter = new RegisterPersenterImpl(this);
    }

    @OnClick({R.id.tv_account,
            R.id.bt_getcode,
            R.id.bt_register,
            R.id.ll_service})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.tv_account: // 选取公司名称
                startActivityForResult(new Intent(this, ChooseCompany.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP), Constant.REGESTER_TO_CHOOSECOMPANY);
                break;
            case R.id.bt_getcode: // 获取验证码
                if (phoneIsEnable) // 如果手机号码未注册，才可以获取验证码
                {
//                    registerPersenter.sendCode(activity, getPhone());
                } else
                {
                    showTopToast(activity, "电话号码格式不正确，请检查");
                }
                break;
            case R.id.bt_register: // 注册
                registerPersenter.onRegister(activity, getCoName(), getPhone(), getPwd()
//                        getCodeText()
                );
                break;
            case R.id.ll_service: // 联系客服
                final ConnectToService ctDialog = new ConnectToService(activity);
                ctDialog.showPopup(rl_all);
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

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    /**
     * 设置动作监听
     */
    public void setAction()
    {
        et_phone.addTextChangedListener(new TextWatcher() // 验证手机号
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if (StringUtil.isPhoneNumber(s.toString().trim()))
                {
                    phoneIsEnable = true;
                } else
                {
                    phoneIsEnable = false;
                }
            }
        });
    }

    /**
     * 选择公司后回调事件
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REGESTER_TO_CHOOSECOMPANY)
        {
            if (resultCode == RESULT_OK)
            {
                tv_account.setText(data.getStringExtra("resultName"));
            }
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
//        bt_getcode = null;
        registerPersenter = null;
    }

    @Override
    public String getCoName()
    {
        return tv_account.getText().toString().trim();
    }

    @Override
    public String getPhone()
    {
        return et_phone.getText().toString().trim();
    }

    @Override
    public String getPwd()
    {
        return et_pwd.getText().toString().trim();
    }

//    @Override
//    public String getCodeText()
//    {
//        return et_code.getText().toString().trim();
//    }


    @Override
    public void showTip(String str)
    {
        showTopToast(activity, str);
    }

//    @Override
//    public void startCount()
//    {
//        bt_getcode.startCountDown();
//    }

    @Override
    public void succ()
    {
        ActivityCollector.removeActivity(activity);
        finish();
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



//    /**
//     * 点击空白内容键盘消失
//     * @param ev
//     * @return
//     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev)
//    {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN)
//        {
//            InputMethodManager imm = (InputMethodManager) MyMapApplication.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//            if (imm != null)
//            {
//                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
//            }
//        }
//        return super.dispatchTouchEvent(ev);
//    }
}
