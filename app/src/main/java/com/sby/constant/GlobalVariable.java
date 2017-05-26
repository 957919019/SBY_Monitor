package com.sby.constant;

/**
 * 全局变量
 * Created by kowal on 2016/12/5.
 */

public class GlobalVariable
{

    private static String LOCATION; // 当前城市名称

    public static String getLOCATION()
    {
        return LOCATION;
    }

    public static void setLOCATION(String LOCATION)
    {
        GlobalVariable.LOCATION = LOCATION;
    }
    private static String SHARE_PICNAME; // 分享图片的名称

    public static String getSharePicname()
    {
        return SHARE_PICNAME;
    }

    public static void setSharePicname(String sharePicname)
    {
        SHARE_PICNAME = sharePicname;
    }

    public static boolean MAP_MODE; // 当前地图的模式（普通视图true，卫星视图false）

    public static boolean isMapMode()
    {
        return MAP_MODE;
    }

    public static void setMapMode(boolean mapMode)
    {
        MAP_MODE = mapMode;
    }
}
