package com.sby.http;

import okhttp3.FormBody;

/**
 * ------------- Description -------------
 *                 表单对象
 * ---------------------------------------
 */
public class RequestParams
{

    private FormBody.Builder builder;

    public RequestParams()
    {
        builder = new FormBody.Builder();
    }

    public void put(String key, String value)
    {
        builder.add(key, value);
    }

    public FormBody toParams()
    {
        return builder.build();
    }
}
