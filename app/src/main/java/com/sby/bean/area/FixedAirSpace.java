package com.sby.bean.area;

/**
 * 固定空域
 * Created by kowal on 2016/12/20.
 */
public class FixedAirSpace
{
    private String id;
    private String name;
    private String airType;
    private String code;
    private String address;
    private String borderPoints;
    private String status;
    private String companyAddress;
    private String companyPhone;
    private String heightScale;
    private String pointCollection; // 坐标
    private String remark;
    private String version;
    private String createBy;
    private String dateCreated;
    private String lastUpdateBy;
    private String lastUpdated;
    private String ncId;
    private String airfieldDistinguish;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAirType()
    {
        return airType;
    }

    public void setAirType(String airType)
    {
        this.airType = airType;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getBorderPoints()
    {
        return borderPoints;
    }

    public void setBorderPoints(String borderPoints)
    {
        this.borderPoints = borderPoints;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCompanyAddress()
    {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress)
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone()
    {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone)
    {
        this.companyPhone = companyPhone;
    }

    public String getHeightScale()
    {
        return heightScale;
    }

    public void setHeightScale(String heightScale)
    {
        this.heightScale = heightScale;
    }

    public String getPointCollection()
    {
        return pointCollection;
    }

    public void setPointCollection(String pointCollection)
    {
        this.pointCollection = pointCollection;
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

    public String getAirfieldDistinguish()
    {
        return airfieldDistinguish;
    }

    public void setAirfieldDistinguish(String airfieldDistinguish)
    {
        this.airfieldDistinguish = airfieldDistinguish;
    }

    @Override
    public String toString()
    {
        return "FixedAirSpace{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", airType='" + airType + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", borderPoints='" + borderPoints + '\'' +
                ", status='" + status + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", heightScale='" + heightScale + '\'' +
                ", pointCollection='" + pointCollection + '\'' +
                ", remark='" + remark + '\'' +
                ", version='" + version + '\'' +
                ", createBy='" + createBy + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", ncId='" + ncId + '\'' +
                ", airfieldDistinguish='" + airfieldDistinguish + '\'' +
                '}';
    }
}
