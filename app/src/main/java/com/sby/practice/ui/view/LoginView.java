package com.sby.practice.ui.view;

import com.sby.bean.user.User;

/**
 * 登录View
 * Created by kowal on 2016/11/21.
 */

public interface LoginView
{
    String getCoName(); // 获取公司名称

    String getPwd(); // 获取密码

    void loginSucc(User user); // 成功

    void showTip(String str);

    void showPro();

    void disPro();
}
