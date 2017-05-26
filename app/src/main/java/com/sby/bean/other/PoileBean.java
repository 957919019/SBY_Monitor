package com.sby.bean.other;

import java.io.Serializable;

/**
 * Created by kowal on 2016/12/4.
 */

public class PoileBean implements Serializable
{
    private int poileId; // 飞行员Id
    private String poileName; // 姓名

    public int getPoileId()
    {
        return poileId;
    }

    public void setPoileId(int poileId)
    {
        this.poileId = poileId;
    }

    public String getPoileName()
    {
        return poileName;
    }

    public void setPoileName(String poileName)
    {
        this.poileName = poileName;
    }

    @Override
    public String toString()
    {
        return "PoileBean{" +
                "poileId=" + poileId +
                ", poileName='" + poileName + '\'' +
                '}';
    }
}
