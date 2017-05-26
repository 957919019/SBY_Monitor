package com.sby.bean.other;

import java.io.Serializable;

/**
 * Created by kowal on 2016/12/4.
 */

public class FlightBean implements Serializable
{
    private int flightId; // 飞机ID
    private int flightPic; // 图片
    private int flightNum; // 飞机编号
    private String fltModel; // 型号

    public String getFltModel()
    {
        return fltModel;
    }

    public void setFltModel(String fltModel)
    {
        this.fltModel = fltModel;
    }

    public int getFlightId()
    {
        return flightId;
    }

    public void setFlightId(int flightId)
    {
        this.flightId = flightId;
    }

    public int getFlightPic()
    {
        return flightPic;
    }

    public void setFlightPic(int flightPic)
    {
        this.flightPic = flightPic;
    }

    public int getFlightNum()
    {
        return flightNum;
    }

    public void setFlightNum(int flightNum)
    {
        this.flightNum = flightNum;
    }

    @Override
    public String toString()
    {
        return "FlightBean{" +
                "flightId=" + flightId +
                ", flightPic=" + flightPic +
                ", flightNum=" + flightNum +
                ", fltModel='" + fltModel + '\'' +
                '}';
    }
}
