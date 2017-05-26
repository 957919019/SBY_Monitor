package com.sby.practice.model.modelImol;

import android.content.Context;

import com.sby.constant.API;
import com.sby.http.HttpRequestCallback;
import com.sby.http.OkHttpUtils;
import com.sby.http.RequestParams;
import com.sby.practice.model.LoginModel;
import com.sby.utils.ACache;


/**
 * 登录Model实现类
 * Created by kowal on 2016/11/21.
 */

public class LoginModelImpl implements LoginModel
{
    ACache mCache;

    @Override
    public void onLogin(Context context, String coName, String pwd, HttpRequestCallback callback)
    {
        RequestParams params = new RequestParams();
        params.put("account", coName);
        params.put("pwd", pwd);

        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.post(context, API.LOGIN, params, callback);
    }

}
