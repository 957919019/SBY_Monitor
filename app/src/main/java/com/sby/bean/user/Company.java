package com.sby.bean.user;

/**
 * 公司
 */
public class Company
{

    private int id; //公司ID
    private String companyName; //公司名
    private String companyCode; // 公司代码
    private String remark; // 备注
    private int version; // 版本
    private String createBy; //
    private long dateCreated; //
    private String lastUpdateBy; //
    private long lastUpdated; //
    private String linkMan; //
    private String shortName; //
    private String tel; // 电话
    private int ncId; //
    private String logo; //Logo

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public Object getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(String companyCode)
    {
        this.companyCode = companyCode;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
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

    public long getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated)
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

    public long getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getLinkMan()
    {
        return linkMan;
    }

    public void setLinkMan(String linkMan)
    {
        this.linkMan = linkMan;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public int getNcId()
    {
        return ncId;
    }

    public void setNcId(int ncId)
    {
        this.ncId = ncId;
    }

    public Object getLogo()
    {
        return logo;
    }

    public void setLogo(String logo)
    {
        this.logo = logo;
    }
}