package com.sby.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 验证
 * Created by kowal on 2017/4/20.
 */

public class RegularExpressionUtiils
{
    /**
     * 手机号码
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static boolean isChinaPhoneLegal(String str)
    {
        try
        {
            String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(str);
            return m.matches();
        } catch (Exception e)
        {
            Logger.w("出", "错了");
            return false;
        }
    }
}
