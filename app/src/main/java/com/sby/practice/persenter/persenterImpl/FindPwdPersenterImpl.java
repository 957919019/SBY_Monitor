package com.sby.practice.persenter.persenterImpl;

import android.content.Context;
import android.text.TextUtils;

import com.sby.practice.model.FindPwdModel;
import com.sby.practice.model.modelImol.FindPwdModelImpl;
import com.sby.practice.persenter.FindPwdPersenter;
import com.sby.practice.ui.view.FindPwdView;
import com.sby.utils.StringUtil;

/**
 * 找回密码Persenter实现类
 * Created by kowal on 2016/12/4.
 */

public class FindPwdPersenterImpl implements FindPwdPersenter
{
    private FindPwdView findPwdView;
    private FindPwdModel findPwdModel;

    public FindPwdPersenterImpl(FindPwdView findPwdView)
    {
        this.findPwdView = findPwdView;
        findPwdModel = new FindPwdModelImpl();
    }

    /**
     * 获取验证码
     * @param context
     * @param phone 手机号
     */
    @Override
    public void getVCode(Context context, String phone)
    {
        if (!StringUtil.isPhoneNumber(phone))
        {
            findPwdView.showTip("非法的手机号码");
        } else
        {
//            findPwdModel.ongetVCode(context, phone, new HttpRequestCallback<List<CompanyBean>>()
//            {
//                @Override
//                public void onStart()
//                {
//                    findPwdView.showPro();
//                }
//
//                @Override
//                public void onFinish()
//                {
//                    findPwdView.disPro();
//                    findPwdView.showTip("无可用网络！");
//                }
//
//                @Override
//                public void onResponse(Result<User> userResult)
//                {
//                    findPwdView.disPro();
//                    findPwdView.showTip("验证码已下发，请注意查收");
//                    findPwdView.sendSucc();
//                }
//
//
//                @Override
//                public void onFailure(Call call, HttpException e)
//                {
//                    findPwdView.disPro();
//                    findPwdView.showTip(e.getMessage());
//                }
//            });
        }
    }

    /**
     * 找回密码
     * @param context
     * @param phone 手机号
     * @param code 验证码
     * @param pwd 密码
     */
    @Override
    public void onFindPwd(Context context, String phone, String code, String pwd)
    {
        if ( !StringUtil.isPhoneNumber(phone))
        {
            findPwdView.showTip("非法的手机号码");
        }else if (TextUtils.isEmpty(code))
        {
            findPwdView.showTip("非法的验证码");
        } else if (  !StringUtil.isPwd(pwd) )
        {
            findPwdView.showTip("非法的密码长度");
        } else
        {
//            findPwdModel.onFindPwd(context, phone, code, pwd, new HttpRequestCallback<Result<User>>()
//            {
//                @Override
//                public void onStart()
//                {
//                    findPwdView.showPro();
//                }
//
//                @Override
//                public void onFinish()
//                {
//                    findPwdView.disPro();
//                    findPwdView.showTip("无可用网络！");
//                }
//
//                @Override
//                public void onResponse(Result<User> userResult)
//                {
//                    findPwdView.disPro();
//                    findPwdView.showTip("请牢记您的密码");
//                    findPwdView.findSucc();
//                }
//
//                @Override
//                public void onFailure(Call call, HttpException e)
//                {
//                    findPwdView.disPro();
//                    findPwdView.showTip(e.getMessage().toString());
//                }
//            });
        }
    }
}
