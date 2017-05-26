package com.sby.practice.ui.view;

/**
 * 找回，密码View
 * Created by kowal on 2016/12/4.
 */

public interface FindPwdView
{
    String getPhone();

    String getVCode();

    String getPwd();

    void findSucc(); // 成功

    void sendSucc(); // 发送成功

    void showTip(String str);

    void showPro();

    void disPro();
}
