package com.sby.practice.ui.view;


import com.sby.bean.user.Company;

import java.util.List;

/**
 * Created by kowal on 2016/12/14.
 */

public interface ChooseCompanyView
{
    void setCompany( List<Company> companyList);

    void showTip(String str);

    void showPro();

    void disPro();
}
