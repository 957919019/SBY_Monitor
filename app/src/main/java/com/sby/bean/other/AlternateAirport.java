/* 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
package com.sby.bean.other;

import java.util.Date;

public class AlternateAirport {
    /**
     * null
     */
    private Integer id;

    /**
     * null
     */
    private Integer version;

    /**
     * 机场名称
     */
    private String airportName;

    /**
     * 机场ID
     */
    private Integer alternateId;

    /**
     * 数据创建人
     */
    private String createBy;

    /**
     * 数据创建时间
     */
    private Date dateCreated;

    /**
     * 降落时间
     */
    private Date landingTime;

    /**
     * 数据最后修改人
     */
    private String lastUpdateBy;

    /**
     * 数据最后修改时间
     */
    private Date lastUpdated;

    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    private String planCode;

    /**
     * null
     */
    public Integer getId() {
        return id;
    }

    /**
     * null
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * null
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * null
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 机场名称
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * 机场名称
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName == null ? null : airportName.trim();
    }

    /**
     * 机场ID
     */
    public Integer getAlternateId() {
        return alternateId;
    }

    /**
     * 机场ID
     */
    public void setAlternateId(Integer alternateId) {
        this.alternateId = alternateId;
    }

    /**
     * 数据创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 数据创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 数据创建时间
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * 数据创建时间
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * 降落时间
     */
    public Date getLandingTime() {
        return landingTime;
    }

    /**
     * 降落时间
     */
    public void setLandingTime(Date landingTime) {
        this.landingTime = landingTime;
    }

    /**
     * 数据最后修改人
     */
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * 数据最后修改人
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    /**
     * 数据最后修改时间
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 数据最后修改时间
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    public String getPlanCode() {
        return planCode;
    }

    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    public void setPlanCode(String planCode) {
        this.planCode = planCode == null ? null : planCode.trim();
    }
}