package com.sby.bean.area;

/**
 * 多边形
 * Created by kowal on 2016/12/21.
 */

public class Polygon
{
    private String longTitude;
    private String laTitude;

    public String getLongTitude()
    {
        return longTitude;
    }

    public void setLongTitude(String longTitude)
    {
        this.longTitude = longTitude;
    }

    public String getLaTitude()
    {
        return laTitude;
    }

    public void setLaTitude(String laTitude)
    {
        this.laTitude = laTitude;
    }

    @Override
    public String toString()
    {
        return "Polygon{" +
                "longTitude='" + longTitude + '\'' +
                ", laTitude='" + laTitude + '\'' +
                '}';
    }
}
