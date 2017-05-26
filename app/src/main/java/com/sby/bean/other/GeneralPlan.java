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

public class GeneralPlan {
    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    private String planId;

    /**
     * 航线高度
     */
    private String lineHeight;

    /**
     * 航线
     */
    private String lineRemark;

    /**
     * 空域
     */
    private String airSpace;

    /**
     * 空地勤人数
     */
    private Integer persionNum;

    /**
     * 通报单位
     */
    private String departments;

    /**
     * 飞行单位（公司）
     */
    private String company;

    /**
     * 联系人
     */
    private String linkMan;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * null
     */
    private Integer version;

    /**
     * 数据创建人
     */
    private String createBy;

    /**
     * 数据创建时间
     */
    private Date dateCreated;

    /**
     * 数据最后修改人
     */
    private String lastUpdateBy;

    /**
     * 数据最后修改时间
     */
    private Date lastUpdated;

    /**
     * 转弯点坐标
     */
    private String turnPoints;

    /**
     * 空域角点坐标
     */
    private String airPoints;

    /**
     * 空域高度上限
     */
    private String airHightLimit;

    /**
     * 转弯点机场
     */
    private Integer turningAirport;

    /**
     * 所属航管中心
     */
    private Long ncId;

    /**
     * 任务类型
     */
    private String taskType;

    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    /**
     * 航线高度
     */
    public String getLineHeight() {
        return lineHeight;
    }

    /**
     * 航线高度
     */
    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight == null ? null : lineHeight.trim();
    }

    /**
     * 航线
     */
    public String getLineRemark() {
        return lineRemark;
    }

    /**
     * 航线
     */
    public void setLineRemark(String lineRemark) {
        this.lineRemark = lineRemark == null ? null : lineRemark.trim();
    }

    /**
     * 空域
     */
    public String getAirSpace() {
        return airSpace;
    }

    /**
     * 空域
     */
    public void setAirSpace(String airSpace) {
        this.airSpace = airSpace == null ? null : airSpace.trim();
    }

    /**
     * 空地勤人数
     */
    public Integer getPersionNum() {
        return persionNum;
    }

    /**
     * 空地勤人数
     */
    public void setPersionNum(Integer persionNum) {
        this.persionNum = persionNum;
    }

    /**
     * 通报单位
     */
    public String getDepartments() {
        return departments;
    }

    /**
     * 通报单位
     */
    public void setDepartments(String departments) {
        this.departments = departments == null ? null : departments.trim();
    }

    /**
     * 飞行单位（公司）
     */
    public String getCompany() {
        return company;
    }

    /**
     * 飞行单位（公司）
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 联系人
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * 联系人
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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
     * 转弯点坐标
     */
    public String getTurnPoints() {
        return turnPoints;
    }

    /**
     * 转弯点坐标
     */
    public void setTurnPoints(String turnPoints) {
        this.turnPoints = turnPoints == null ? null : turnPoints.trim();
    }

    /**
     * 空域角点坐标
     */
    public String getAirPoints() {
        return airPoints;
    }

    /**
     * 空域角点坐标
     */
    public void setAirPoints(String airPoints) {
        this.airPoints = airPoints == null ? null : airPoints.trim();
    }

    /**
     * 空域高度上限
     */
    public String getAirHightLimit() {
        return airHightLimit;
    }

    /**
     * 空域高度上限
     */
    public void setAirHightLimit(String airHightLimit) {
        this.airHightLimit = airHightLimit == null ? null : airHightLimit.trim();
    }

    /**
     * 转弯点机场
     */
    public Integer getTurningAirport() {
        return turningAirport;
    }

    /**
     * 转弯点机场
     */
    public void setTurningAirport(Integer turningAirport) {
        this.turningAirport = turningAirport;
    }

    /**
     * 所属航管中心
     */
    public Long getNcId() {
        return ncId;
    }

    /**
     * 所属航管中心
     */
    public void setNcId(Long ncId) {
        this.ncId = ncId;
    }

    /**
     * 任务类型
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 任务类型
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }
}