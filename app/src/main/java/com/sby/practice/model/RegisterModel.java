package com.sby.practice.model;

import android.content.Context;

import com.sby.http.HttpRequestCallback;


/**
 * 注册model接口
 * Created by kowal on 2016/11/22.
 */

public interface RegisterModel
{
    void getCode(Context context, String phone, HttpRequestCallback callBack);


    void onRegister(Context context, String coName, String phone, String pwd,  HttpRequestCallback callBack);

}
