package com.sby.practice.ui.view;

/**
 * 注册View
 * Created by kowal on 2016/11/22.
 */

public interface RegisterView
{
    String getCoName(); //获取公司名称

    String getPhone(); // 获取手机号码

    String getPwd(); // 获取密码
//
//    String getCodeText(); // 得到验证码字符

    void showTip(String str); // 提示

//    void startCount(); // 开始倒计时

    void succ();

    void showPro();

    void disPro();
}
