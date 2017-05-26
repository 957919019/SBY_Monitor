package com.sby.practice.persenter.persenterImpl;

import android.content.Context;

import com.sby.bean.core.ResultBean;
import com.sby.bean.user.User;
import com.sby.http.HttpException;
import com.sby.http.HttpRequestCallback;
import com.sby.practice.model.LoginModel;
import com.sby.practice.model.modelImol.LoginModelImpl;
import com.sby.practice.persenter.LoginPersenter;
import com.sby.practice.ui.view.LoginView;
import com.sby.utils.StringUtil;

import okhttp3.Call;

/**
 * 登录Persenter实现
 * Created by kowal on 2016/11/21.
 */

public class LoginPersenterImpl implements LoginPersenter
{

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPersenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
    }

    /**
     * 登录
     *
     * @param context
     * @param coName  公司名
     * @param pwd     密码
     */
    @Override
    public void signIn(Context context, String coName, String pwd)
    {
        if (StringUtil.isEmpty(coName))
        {
            loginView.showTip("非法的用户名");
        } else if (StringUtil.isEmpty(pwd)  )
        {
            loginView.showTip("非法的密码长度");
        } else
        {
            loginModel.onLogin(context, loginView.getCoName(), loginView.getPwd(), new HttpRequestCallback<ResultBean<User>>()
            {
                @Override
                public void onStart()
                {
                    loginView.showPro();
                }

                @Override
                public void onFinish()
                {
                    loginView.disPro();
                }

                @Override
                public void onResponse(ResultBean<User> userResultBean)
                {
                    // TODO 判断后台返回数据是否登录成功
                    loginView.loginSucc(userResultBean.getData());
                    loginView.showTip("登录成功");
                    loginView.disPro();
                }

                @Override
                public void onFailure(Call call, HttpException e)
                {
                    loginView.disPro();
                    loginView.showTip(e.getMessage().toString());
                }
            });
        }
    }

}
