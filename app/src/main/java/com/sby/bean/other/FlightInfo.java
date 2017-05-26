package com.sby.bean.other;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kowal on 2016/11/10.
 */

public class FlightInfo implements Serializable
{

    // 图片ID
    private int imgId;
    // 飞机名称
    private String fName;
    // 飞机编号
    private String num;
    // 飞机型号
    private String model;
    // 出发地
    private String startPlace;
    // 抵达地
    private String endPlace;
    // 出发时间
    private String startTime;
    // 抵达时间
    private String endTime;
    // 作业区域
    private String homeArea;
    // 精度
    private double latitude;
    // 纬度
    private double longitude;
    // 高度
    private double hight;
    // 速度
    private double speed;
    // 飞行员
    private String driver;
    // 所属公司
    private String company;

    public static List<FlightInfo> flightInfos= new ArrayList<>(); // 飞机信息列表

    public FlightInfo() {}

    public FlightInfo(String fName, String num, String model, String startPlace, String endPlace,
                      String startTime, String endTime, String homeArea, double latitude, double longitude,
                      double hight, double speed, String driver, String company)
    {
        super();
        this.fName = fName;
        this.num = num;
        this.model = model;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.startTime = startTime;
        this.endTime = endTime;
        this.homeArea = homeArea;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hight = hight;
        this.speed = speed;
        this.driver = driver;
        this.company = company;
    }

    static
    {
        flightInfos.add(new FlightInfo( "小飞机", "bh101", "model1", "北京", "天津", "10:00", "11:00","天津",
                39.963175, 116.400244,  100, 900, "小杨利伟" , "北大荒公司"));
        flightInfos.add(new FlightInfo( "中飞机", "bh100", "model2", "天津", "北京", "10:00", "11:00","天津",
                39.942821, 116.369199, 100, 900, "中杨利伟", "通航公司" ));
        flightInfos.add(new FlightInfo( "大飞机", "bh103", "model5", "河北", "黑龙江", "10:00", "11:00","天津",
                39.922821, 116.369199, 100, 900, "大杨利伟", "民航公司" ));
    }

    public static List<FlightInfo> getFlightInfos()
    {
        return flightInfos;
    }

    public static void setFlightInfos(List<FlightInfo> flightInfos)
    {
        FlightInfo.flightInfos = flightInfos;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public int getImgId()
    {
        return imgId;
    }

    public void setImgId(int imgId)
    {
        this.imgId = imgId;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getNum()
    {
        return num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getStartPlace()
    {
        return startPlace;
    }

    public void setStartPlace(String startPlace)
    {
        this.startPlace = startPlace;
    }

    public String getEndPlace()
    {
        return endPlace;
    }

    public void setEndPlace(String endPlace)
    {
        this.endPlace = endPlace;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getHomeArea()
    {
        return homeArea;
    }

    public void setHomeArea(String homeArea)
    {
        this.homeArea = homeArea;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public double getHight()
    {
        return hight;
    }

    public void setHight(double hight)
    {
        this.hight = hight;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public String getDriver()
    {
        return driver;
    }

    public void setDriver(String driver)
    {
        this.driver = driver;
    }
}
