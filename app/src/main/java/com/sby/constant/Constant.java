package com.sby.constant;

import com.baidu.mapapi.model.LatLng;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 常量
 * Created by kowal on 2016/9/12.
 */
public class Constant implements Serializable
{
    //  郭雷uri
//    public static String uri = "http://192.168.1.124:8080/appService/";
    public static String uri = "http://43.240.244.162:8085/appService/";

    // 保哥uri
//    public static String uri = "http://192.168.1.127:8080/appService/";
    /**
     * 网络连接变化
     */
    public static final String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    /**
     * 定义双击退出的时间
     */
    public static long exitTime = 0;
    /**
     * 北京坐标
     */
    public static final LatLng GEO_BEIJING = new LatLng(39.945, 116.404);
    public static final String BEIJINGSHI = "北京市";
    /**
     * 默认地图级别
     */
    public static final float ZOOM_LEVEL = 6.0f;
    /**
     * 传感器方向
     */
    public static float DRIECTION = 0;

    public static int REGESTER_TO_CHOOSECOMPANY = 1;

    // 电话权限
    public static final int REQUEST_PHONE_PERMISSION = 0x01;

    /************************************** 地点收藏 **************************************/
    /**
     * 保留历史记录的条数
     */
    public static int  HISTORY_MAX = 20;
    public static int  MSG_SEARCH = 1;
    /**
     * 城市名称
     */
    public static final String CITY_NAME = "city_name";


    /************************************** 设置里的常量 **************************************/
    /**
     * 3、4G模式切换
     */
    public static final String MOBILE_ON = "mobileOn";
    /**
     * 标签开关
     */
    public static final String LABEL_ON = "Label_on";
    /**
     * 速度
     */
    public static final String SPEED = "Speed";
    public static final String KNOT = "1";
    public static final String KM = "2";
    public static final String MPH = "3";
    /**
     * 海拔
     */
    public static final String ALTITUDE = "Altitude";
    public static final String FEET = "Feet"; // 英尺
    public static final String MI = "Mi"; // 米
    /**
     * 距离
     */
    public static final String DISTANCE = "Distance";
    public static final String KILOMETER = "Kilometer"; // 千米
    public static final String METRES  = "Metres "; // 米
    public static final String MILE = "Mile"; // 海里

    /**
     * 保存截图的路径
     */
    public static String PATH =  "/mnt/sdcard/" + "DCIM/Screenshots/";
    public static String PICNAME = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())); // 文件名，根据系统时间生成

    /**
     * 地图当前的显示模式
     */
    public static boolean MAP_TYPE_NORMAL = true;
    public static boolean MAP_TYPE_SATELLITE = false;

    /**
     * 通过设置间隔时间和距离可以控制速度和图标移动的距离
     */
    public static int TIME_INTERVAL = 80;
    public static double RANGE = 0.0008;
    /**
     * 网络请求成功
     */
    public static final int RESULT_OK = 200;
    /**
     * 模拟数据
     */
    public static final LatLng[] latlngs = new LatLng[]
            {
                    new LatLng(39.95853, 116.103013),
                    new LatLng(39.938506, 116.139808),
                    new LatLng(39.931425, 116.167978),
                    new LatLng(39.930097, 116.217996),
                    new LatLng(39.931425, 116.234094),
                    new LatLng(39.923457, 116.32493),
                    new LatLng(39.914603, 116.362875),
                    new LatLng(39.91416, 116.36345),
            };
}
