package com.sby.bean.area;

/**
 * 报告点
 * Created by kowal on 2016/12/20.
 */

public class AreaReport
{

    private String id;
    private String pointName;
    private String laTitude;
    private String longTitude;
    private String pointType;
    private String remark;
    private String version;
    private String createBy;
    private String dateCreated;
    private String lastUpdateBy;
    private String lastUpdated;
    private String ncId;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPointName()
    {
        return pointName;
    }

    public void setPointName(String pointName)
    {
        this.pointName = pointName;
    }

    public String getLaTitude()
    {
        return laTitude;
    }

    public void setLaTitude(String laTitude)
    {
        this.laTitude = laTitude;
    }

    public String getLongTitude()
    {
        return longTitude;
    }

    public void setLongTitude(String longTitude)
    {
        this.longTitude = longTitude;
    }

    public String getPointType()
    {
        return pointType;
    }

    public void setPointType(String pointType)
    {
        this.pointType = pointType;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public String getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public String getLastUpdateBy()
    {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy)
    {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getNcId()
    {
        return ncId;
    }

    public void setNcId(String ncId)
    {
        this.ncId = ncId;
    }

    @Override
    public String toString()
    {
        return "AreaReport{" +
                "id='" + id + '\'' +
                ", pointName='" + pointName + '\'' +
                ", laTitude='" + laTitude + '\'' +
                ", longTitude='" + longTitude + '\'' +
                ", pointType='" + pointType + '\'' +
                ", remark='" + remark + '\'' +
                ", version='" + version + '\'' +
                ", createBy='" + createBy + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", ncId='" + ncId + '\'' +
                '}';
    }
}
