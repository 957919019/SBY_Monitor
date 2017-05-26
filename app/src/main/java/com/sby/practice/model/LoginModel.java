package com.sby.practice.model;

import android.content.Context;

import com.sby.http.HttpRequestCallback;


/**
 * 登录model接口
 * Created by kowal on 2016/11/21.
 */

public interface LoginModel
{
    void onLogin(Context context, String coName, String pwd, HttpRequestCallback callBack);

}
