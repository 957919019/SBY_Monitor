package com.sby.utils;

import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具
 * Created by kowal on 2016/11/1.
 */
public class StringUtil
{

    /**
     * 空判断
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str)
    {
        if (str == null || str.length() == 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * 判断空
     * @param str
     * @return
     */
    public static String nullIfEmpty(@Nullable String str) {
        return isEmpty(str) ? null : str;
    }

    /**
     * 校验电话
     *
     * @param phone
     * @return
     */
    public static boolean isPhoneNumber(String phone)
    {
        if (isEmpty(phone) || phone == null)
        {
            return false;
        }
        String regExp = "^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.find();
    }

    /**
     * 比较两字符串是否相同
     * @param a
     * @param b
     * @return
     */
    public static boolean isSame(String a, String b)
    {
        if (a != null || !"".equals(a) || b != null || !"".equals(b))
        {
            if (a.equals(b))
            {
                return true;
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }

    /**
     * 密码验证,符合true
     * @param pwd
     * @return
     */
    public static boolean isPwd(String pwd)
    {
        if (!isEmpty(pwd))
        {
            return true;
        }
        return false;
    }
    /**
     * 校验身份证
     * @param idCard
     * @return
     */
    public static boolean isIdCard(String idCard)
    {
        if (isEmpty(idCard))
        {
            return false;
        }
        String regExp = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[x|X|\\d]$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(idCard);
        return m.find();
    }




    public static String inputStream2String(InputStream is)
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try
        {
            while ((line = in.readLine()) != null)
            {
                buffer.append(line);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return buffer.toString();
    }


    public static String idCardDeal(String idCard)
    {
        StringBuffer sb = new StringBuffer(idCard);
        sb.replace(6, 16, "**********");
        return sb.toString();
    }
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static SimpleDateFormat sdf0 = new SimpleDateFormat("yyMMdd");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
    private static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Date date;
    private static String a;


    /**
     * 根据long类型的时间戳，转换为一个String类型的描述性时间
     * 通话记录如果发生在今天：“15:30”
     * 发生在昨天：“昨天”
     * 发生在前天：“前天”
     * 更早：           “2016/04/15”
     *
     * @param timeStample
     * @return
     */
    public static String getTime(long timeStample) {

        //调用getTime方法的时间点
        long now = System.currentTimeMillis();
        //当前时间点与参数时间点的差值
        //从毫秒差值转为天：0 当天 1昨天 2前天 其它更久以前
        int day = (int) (now / 1000 / 60 / 60 / 24 - timeStample / 1000 / 60 / 60 / 24);
        switch (day) {
            case 0:

                return sdf3.format(timeStample);
            case 1:

                return "昨天 " + sdf2.format(timeStample);
            case 2:
                return "前天 " + sdf2.format(timeStample);
            default:

                return sdf3.format(timeStample);
        }


    }

    /**
     * 返回当前的日期
     *
     * @return
     */
    public static String getDateRiQi() {
        date = new Date(System.currentTimeMillis());
        return sdf0.format(date);
    }
    public static String getDateShiJian() {
        date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }
    public static String getDateDate(long lo) {
        return sdf3.format(lo);
    }

}
