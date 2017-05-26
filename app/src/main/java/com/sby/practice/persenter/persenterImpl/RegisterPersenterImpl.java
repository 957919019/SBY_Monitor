package com.sby.practice.persenter.persenterImpl;

import android.content.Context;

import com.sby.bean.core.ResultBean;
import com.sby.http.HttpException;
import com.sby.http.HttpRequestCallback;
import com.sby.practice.model.RegisterModel;
import com.sby.practice.model.modelImol.RegisterModelImpl;
import com.sby.practice.persenter.RegisterPersenter;
import com.sby.practice.ui.view.RegisterView;
import com.sby.utils.StringUtil;

import okhttp3.Call;

/**
 * 注册Persenter实现
 * Created by kowal on 2016/11/22.
 */

public class RegisterPersenterImpl implements RegisterPersenter
{
    private RegisterView registerView;
    private RegisterModel registerModel;


    public RegisterPersenterImpl(RegisterView registerView)
    {
        this.registerView = registerView;
        registerModel = new RegisterModelImpl();
    }

//    /**
//     * 请求验证码
//     *
//     * @param context
//     * @param phone
//     */
//    @Override
//    public void sendCode(Context context, String phone)
//    {
//        if (!StringUtil.isPhoneNumber(phone))
//        {
//            registerView.showTip("非法的电话号码");
//        } else
//        {
//            registerModel.getCode(context, phone, new HttpRequestCallback<ResultBean<Company>>()
//            {
//                @Override
//                public void onStart()
//                {
//                    registerView.showPro();
//                }
//
//                @Override
//                public void onFinish()
//                {
//                    registerView.disPro();
//                }
//
//                @Override
//                public void onResponse(Result<User> userResult)
//                {
//                    registerView.disPro();
//                    registerView.showTip(userResult.getReceipt());
//                    registerView.startCount();
//                }
//
//                @Override
//                public void onFailure(Call call, HttpException e)
//                {
//                    registerView.disPro();
//                    registerView.showTip(e.getMessage());
//                }
//            });
//        }
//    }

    /**
     * 注册
     *
     * @param context
     * @param coName
     * @param phone
     * @param pwd
     */
    @Override
    public void onRegister(Context context, String coName, String phone, String pwd )
    {
        if (StringUtil.isEmpty(coName))
        {
            registerView.showTip("公司不可为空");
        } else if (!StringUtil.isPhoneNumber(phone))
        {
            registerView.showTip("非法的电话号码");
        } else if (!StringUtil.isPwd(pwd))
        {
            registerView.showTip("非法的密码长度");
        }
//        else if (StringUtil.isEmpty(code))
//        {
//            registerView.showTip("请输入验证码");
//        }
        else
        {
            registerModel.onRegister(context, coName, phone, pwd,  new HttpRequestCallback<ResultBean>()
            {
                @Override
                public void onStart()
                {
                    registerView.showPro();
                }

                @Override
                public void onFinish()
                {
                    registerView.showPro();
                }

                @Override
                public void onResponse(ResultBean resultBean)
                {
                    registerView.disPro();
                    registerView.succ();
                    registerView.showTip(resultBean.getReceipt() + "注册成功");
                }

                @Override
                public void onFailure(Call call, HttpException e)
                {
                    registerView.disPro();
                    registerView.showTip(e.getMessage());
                }
            });
        }
    }
}
