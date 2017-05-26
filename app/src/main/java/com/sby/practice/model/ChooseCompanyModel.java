package com.sby.practice.model;

import android.content.Context;

import com.sby.http.HttpRequestCallback;

/**
 * Created by kowal on 2016/12/14.
 */

public interface ChooseCompanyModel
{
    /**
     * 获取公司列表
     */
    void getCompanyList(Context context, HttpRequestCallback callback);

}
