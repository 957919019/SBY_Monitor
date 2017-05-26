package com.sby.bean.area;

/**
 * 圆形对象
 * Created by kowal on 2016/12/20.
 */

public class Radius
{
    private String longTitude;
    private String laTitude;
    private String height;
    private String radius;

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getRadius()
    {
        return radius;
    }

    public void setRadius(String radius)
    {
        this.radius = radius;
    }

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
        return "Radius{" +
                "longTitude='" + longTitude + '\'' +
                ", laTitude='" + laTitude + '\'' +
                ", height='" + height + '\'' +
                ", radius='" + radius + '\'' +
                '}';
    }
}
