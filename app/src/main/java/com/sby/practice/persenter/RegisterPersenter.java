package com.sby.practice.persenter;

import android.content.Context;

/**
 * 注册persenter接口
 * Created by kowal on 2016/11/22.
 */

public interface RegisterPersenter
{
//    /**
//     * 发送验证码
//     * @param context
//     * @param phone
//     */
//    void sendCode(Context context, String phone) ;

    /**
     * 注册
     * @param context
     * @param coName
     * @param phone
     * @param pwd
     */
    void onRegister(Context context, String coName, String phone, String pwd
//            , String code
    );
}
