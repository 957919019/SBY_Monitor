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

public class BasePlan {
    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    private String id;

    /**
     * 计划名称
     */
    private String taskName;

    /**
     * 计划类型
     */
    private Integer flightTypeId;

    /**
     * 飞行单位
     */
    private Integer flightCompanyId;

    /**
     * 起飞机场
     */
    private Integer takeOffAirportId;

    /**
     * 降落机场
     */
    private Integer landingAirportId;

    /**
     * 总架数
     */
    private Integer totalNum;

    /**
     * 飞行日期
     */
    private Date departureDate;

    /**
     * 预计起飞时间
     */
    private Date estimatedTakeOffTime;

    /**
     * 实际起飞时间
     */
    private Date actualTakeOffTime;

    /**
     * 预计降落时间
     */
    private Date estimatedTakeOnTime;

    /**
     * 实际降落时间
     */
    private Date actualTakeOnTime;

    /**
     * 关联表类型
     */
    private String subTableType;

    /**
     * 执行状态
     */
    private String planStatus;

    /**
     * 是否有效
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 备用机场
     */
    private Integer backupAirportId;

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
     * 飞行管制调配信息
     */
    private String flightAllocationInformation;

    /**
     * 飞行期间天气预报
     */
    private String flightWeather;

    /**
     * 通航公司信息表
     */
    private Integer genAirCompanyId;

    /**
     * 气象员
     */
    private String caster;

    /**
     * 管制员
     */
    private String aircraftsController;

    /**
     * 飞行单位（公司）
     */
    private String company;

    /**
     * 通报单位
     */
    private String departments;

    /**
     * 签派员
     */
    private String dispatcher;

    /**
     * 联系人
     */
    private String linkMan;

    /**
     * 空地勤人数
     */
    private Integer persionNum;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 机长（飞行训练）
     */
    private String allPilots;

    /**
     * 飞行管制调配信息
     */
    private String dispatcherInformation;

    /**
     * 地勤人数
     */
    private Integer landPersionNum;

    /**
     * 空勤人数
     */
    private Integer skyPersionNum;

    /**
     * 填报者
     */
    private String timeReporter;

    /**
     * 所属航管中心
     */
    private Long ncId;

    /**
     * 是否通过
     */
    private Integer checkId;

    /**
     * 是否提交
     */
    private Integer isSubmit;

    /**
     * 观察员
     */
    private String observer;

    /**
     * 航护处审批意见
     */
    private String hhcacceptRemark;

    /**
     * 军航空管审批意见
     */
    private String jhkgacceptRemark;

    /**
     * 总调度室审批意见
     */
    private String zddsacceptRemark;

    /**
     * 审批等级0航站已提交审批，1总站审批通过，2民航审批通过，3空军审批通过 
     */
    private Integer acceptLevel;

    /**
     * 航护处审批人所属航管中心
     */
    private Integer acceptNcId;

    /**
     * 航护处审批时间
     */
    private Date createTime;

    /**
     * 航护处是否通过0未审批，1通过，2未通过
     */
    private Integer hhcisAccepted;

    /**
     * 军航空管否通过0未审批，1通过，2未通过
     */
    private Integer jhkgisAccepted;

    /**
     * 航护处审批人
     */
    private String specialist;

    /**
     * 航护处审批人ID
     */
    private Integer userId;

    /**
     * 总调度室是否通过0未审批，1通过，2未通过
     */
    private Integer zddsisAccepted;

    /**
     * 军航空管审批人所属航管中心
     */
    private Integer jhkgAcceptNcId;

    /**
     * 军航空管审批时间
     */
    private Date jhkgCreateTime;

    /**
     * 军航空管审批人
     */
    private String jhkgSpecialist;

    /**
     * 军航空管审批人ID
     */
    private Integer jhkgUserId;

    /**
     * 总调度室审批人所属航管中心
     */
    private Integer zddsAcceptNcId;

    /**
     * 总调度室审批时间
     */
    private Date zddsCreateTime;

    /**
     * 总调度室审批人
     */
    private String zddsSpecialist;

    /**
     * 总调度室审批人ID
     */
    private Integer zddsUserId;

    /**
     * 民航空管审批人所属航管中心
     */
    private Integer mhkgAcceptNcId;

    /**
     * 民航空管审批时间
     */
    private Date mhkgCreateTime;

    /**
     * 民航空管审批人
     */
    private String mhkgSpecialist;

    /**
     * 民航空管审批人ID
     */
    private Integer mhkgUserId;

    /**
     * 民航空管审批意见
     */
    private String mhkgacceptRemark;

    /**
     * 民航空管否通过0未审批，1通过，2未通过
     */
    private Integer mhkgisAccepted;

    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    public String getId() {
        return id;
    }

    /**
     * 计划编码（格式：年月日8位+4位顺序数）2
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 计划名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 计划名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 计划类型
     */
    public Integer getFlightTypeId() {
        return flightTypeId;
    }

    /**
     * 计划类型
     */
    public void setFlightTypeId(Integer flightTypeId) {
        this.flightTypeId = flightTypeId;
    }

    /**
     * 飞行单位
     */
    public Integer getFlightCompanyId() {
        return flightCompanyId;
    }

    /**
     * 飞行单位
     */
    public void setFlightCompanyId(Integer flightCompanyId) {
        this.flightCompanyId = flightCompanyId;
    }

    /**
     * 起飞机场
     */
    public Integer getTakeOffAirportId() {
        return takeOffAirportId;
    }

    /**
     * 起飞机场
     */
    public void setTakeOffAirportId(Integer takeOffAirportId) {
        this.takeOffAirportId = takeOffAirportId;
    }

    /**
     * 降落机场
     */
    public Integer getLandingAirportId() {
        return landingAirportId;
    }

    /**
     * 降落机场
     */
    public void setLandingAirportId(Integer landingAirportId) {
        this.landingAirportId = landingAirportId;
    }

    /**
     * 总架数
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * 总架数
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 飞行日期
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * 飞行日期
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * 预计起飞时间
     */
    public Date getEstimatedTakeOffTime() {
        return estimatedTakeOffTime;
    }

    /**
     * 预计起飞时间
     */
    public void setEstimatedTakeOffTime(Date estimatedTakeOffTime) {
        this.estimatedTakeOffTime = estimatedTakeOffTime;
    }

    /**
     * 实际起飞时间
     */
    public Date getActualTakeOffTime() {
        return actualTakeOffTime;
    }

    /**
     * 实际起飞时间
     */
    public void setActualTakeOffTime(Date actualTakeOffTime) {
        this.actualTakeOffTime = actualTakeOffTime;
    }

    /**
     * 预计降落时间
     */
    public Date getEstimatedTakeOnTime() {
        return estimatedTakeOnTime;
    }

    /**
     * 预计降落时间
     */
    public void setEstimatedTakeOnTime(Date estimatedTakeOnTime) {
        this.estimatedTakeOnTime = estimatedTakeOnTime;
    }

    /**
     * 实际降落时间
     */
    public Date getActualTakeOnTime() {
        return actualTakeOnTime;
    }

    /**
     * 实际降落时间
     */
    public void setActualTakeOnTime(Date actualTakeOnTime) {
        this.actualTakeOnTime = actualTakeOnTime;
    }

    /**
     * 关联表类型
     */
    public String getSubTableType() {
        return subTableType;
    }

    /**
     * 关联表类型
     */
    public void setSubTableType(String subTableType) {
        this.subTableType = subTableType == null ? null : subTableType.trim();
    }

    /**
     * 执行状态
     */
    public String getPlanStatus() {
        return planStatus;
    }

    /**
     * 执行状态
     */
    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus == null ? null : planStatus.trim();
    }

    /**
     * 是否有效
     */
    public String getStatus() {
        return status;
    }

    /**
     * 是否有效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 备用机场
     */
    public Integer getBackupAirportId() {
        return backupAirportId;
    }

    /**
     * 备用机场
     */
    public void setBackupAirportId(Integer backupAirportId) {
        this.backupAirportId = backupAirportId;
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
     * 飞行管制调配信息
     */
    public String getFlightAllocationInformation() {
        return flightAllocationInformation;
    }

    /**
     * 飞行管制调配信息
     */
    public void setFlightAllocationInformation(String flightAllocationInformation) {
        this.flightAllocationInformation = flightAllocationInformation == null ? null : flightAllocationInformation.trim();
    }

    /**
     * 飞行期间天气预报
     */
    public String getFlightWeather() {
        return flightWeather;
    }

    /**
     * 飞行期间天气预报
     */
    public void setFlightWeather(String flightWeather) {
        this.flightWeather = flightWeather == null ? null : flightWeather.trim();
    }

    /**
     * 通航公司信息表
     */
    public Integer getGenAirCompanyId() {
        return genAirCompanyId;
    }

    /**
     * 通航公司信息表
     */
    public void setGenAirCompanyId(Integer genAirCompanyId) {
        this.genAirCompanyId = genAirCompanyId;
    }

    /**
     * 气象员
     */
    public String getCaster() {
        return caster;
    }

    /**
     * 气象员
     */
    public void setCaster(String caster) {
        this.caster = caster == null ? null : caster.trim();
    }

    /**
     * 管制员
     */
    public String getAircraftsController() {
        return aircraftsController;
    }

    /**
     * 管制员
     */
    public void setAircraftsController(String aircraftsController) {
        this.aircraftsController = aircraftsController == null ? null : aircraftsController.trim();
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
     * 签派员
     */
    public String getDispatcher() {
        return dispatcher;
    }

    /**
     * 签派员
     */
    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher == null ? null : dispatcher.trim();
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
     * 机长（飞行训练）
     */
    public String getAllPilots() {
        return allPilots;
    }

    /**
     * 机长（飞行训练）
     */
    public void setAllPilots(String allPilots) {
        this.allPilots = allPilots == null ? null : allPilots.trim();
    }

    /**
     * 飞行管制调配信息
     */
    public String getDispatcherInformation() {
        return dispatcherInformation;
    }

    /**
     * 飞行管制调配信息
     */
    public void setDispatcherInformation(String dispatcherInformation) {
        this.dispatcherInformation = dispatcherInformation == null ? null : dispatcherInformation.trim();
    }

    /**
     * 地勤人数
     */
    public Integer getLandPersionNum() {
        return landPersionNum;
    }

    /**
     * 地勤人数
     */
    public void setLandPersionNum(Integer landPersionNum) {
        this.landPersionNum = landPersionNum;
    }

    /**
     * 空勤人数
     */
    public Integer getSkyPersionNum() {
        return skyPersionNum;
    }

    /**
     * 空勤人数
     */
    public void setSkyPersionNum(Integer skyPersionNum) {
        this.skyPersionNum = skyPersionNum;
    }

    /**
     * 填报者
     */
    public String getTimeReporter() {
        return timeReporter;
    }

    /**
     * 填报者
     */
    public void setTimeReporter(String timeReporter) {
        this.timeReporter = timeReporter == null ? null : timeReporter.trim();
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
     * 是否通过
     */
    public Integer getCheckId() {
        return checkId;
    }

    /**
     * 是否通过
     */
    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    /**
     * 是否提交
     */
    public Integer getIsSubmit() {
        return isSubmit;
    }

    /**
     * 是否提交
     */
    public void setIsSubmit(Integer isSubmit) {
        this.isSubmit = isSubmit;
    }

    /**
     * 观察员
     */
    public String getObserver() {
        return observer;
    }

    /**
     * 观察员
     */
    public void setObserver(String observer) {
        this.observer = observer == null ? null : observer.trim();
    }

    /**
     * 航护处审批意见
     */
    public String getHhcacceptRemark() {
        return hhcacceptRemark;
    }

    /**
     * 航护处审批意见
     */
    public void setHhcacceptRemark(String hhcacceptRemark) {
        this.hhcacceptRemark = hhcacceptRemark == null ? null : hhcacceptRemark.trim();
    }

    /**
     * 军航空管审批意见
     */
    public String getJhkgacceptRemark() {
        return jhkgacceptRemark;
    }

    /**
     * 军航空管审批意见
     */
    public void setJhkgacceptRemark(String jhkgacceptRemark) {
        this.jhkgacceptRemark = jhkgacceptRemark == null ? null : jhkgacceptRemark.trim();
    }

    /**
     * 总调度室审批意见
     */
    public String getZddsacceptRemark() {
        return zddsacceptRemark;
    }

    /**
     * 总调度室审批意见
     */
    public void setZddsacceptRemark(String zddsacceptRemark) {
        this.zddsacceptRemark = zddsacceptRemark == null ? null : zddsacceptRemark.trim();
    }

    /**
     * 审批等级0航站已提交审批，1总站审批通过，2民航审批通过，3空军审批通过 
     */
    public Integer getAcceptLevel() {
        return acceptLevel;
    }

    /**
     * 审批等级0航站已提交审批，1总站审批通过，2民航审批通过，3空军审批通过 
     */
    public void setAcceptLevel(Integer acceptLevel) {
        this.acceptLevel = acceptLevel;
    }

    /**
     * 航护处审批人所属航管中心
     */
    public Integer getAcceptNcId() {
        return acceptNcId;
    }

    /**
     * 航护处审批人所属航管中心
     */
    public void setAcceptNcId(Integer acceptNcId) {
        this.acceptNcId = acceptNcId;
    }

    /**
     * 航护处审批时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 航护处审批时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 航护处是否通过0未审批，1通过，2未通过
     */
    public Integer getHhcisAccepted() {
        return hhcisAccepted;
    }

    /**
     * 航护处是否通过0未审批，1通过，2未通过
     */
    public void setHhcisAccepted(Integer hhcisAccepted) {
        this.hhcisAccepted = hhcisAccepted;
    }

    /**
     * 军航空管否通过0未审批，1通过，2未通过
     */
    public Integer getJhkgisAccepted() {
        return jhkgisAccepted;
    }

    /**
     * 军航空管否通过0未审批，1通过，2未通过
     */
    public void setJhkgisAccepted(Integer jhkgisAccepted) {
        this.jhkgisAccepted = jhkgisAccepted;
    }

    /**
     * 航护处审批人
     */
    public String getSpecialist() {
        return specialist;
    }

    /**
     * 航护处审批人
     */
    public void setSpecialist(String specialist) {
        this.specialist = specialist == null ? null : specialist.trim();
    }

    /**
     * 航护处审批人ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 航护处审批人ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 总调度室是否通过0未审批，1通过，2未通过
     */
    public Integer getZddsisAccepted() {
        return zddsisAccepted;
    }

    /**
     * 总调度室是否通过0未审批，1通过，2未通过
     */
    public void setZddsisAccepted(Integer zddsisAccepted) {
        this.zddsisAccepted = zddsisAccepted;
    }

    /**
     * 军航空管审批人所属航管中心
     */
    public Integer getJhkgAcceptNcId() {
        return jhkgAcceptNcId;
    }

    /**
     * 军航空管审批人所属航管中心
     */
    public void setJhkgAcceptNcId(Integer jhkgAcceptNcId) {
        this.jhkgAcceptNcId = jhkgAcceptNcId;
    }

    /**
     * 军航空管审批时间
     */
    public Date getJhkgCreateTime() {
        return jhkgCreateTime;
    }

    /**
     * 军航空管审批时间
     */
    public void setJhkgCreateTime(Date jhkgCreateTime) {
        this.jhkgCreateTime = jhkgCreateTime;
    }

    /**
     * 军航空管审批人
     */
    public String getJhkgSpecialist() {
        return jhkgSpecialist;
    }

    /**
     * 军航空管审批人
     */
    public void setJhkgSpecialist(String jhkgSpecialist) {
        this.jhkgSpecialist = jhkgSpecialist == null ? null : jhkgSpecialist.trim();
    }

    /**
     * 军航空管审批人ID
     */
    public Integer getJhkgUserId() {
        return jhkgUserId;
    }

    /**
     * 军航空管审批人ID
     */
    public void setJhkgUserId(Integer jhkgUserId) {
        this.jhkgUserId = jhkgUserId;
    }

    /**
     * 总调度室审批人所属航管中心
     */
    public Integer getZddsAcceptNcId() {
        return zddsAcceptNcId;
    }

    /**
     * 总调度室审批人所属航管中心
     */
    public void setZddsAcceptNcId(Integer zddsAcceptNcId) {
        this.zddsAcceptNcId = zddsAcceptNcId;
    }

    /**
     * 总调度室审批时间
     */
    public Date getZddsCreateTime() {
        return zddsCreateTime;
    }

    /**
     * 总调度室审批时间
     */
    public void setZddsCreateTime(Date zddsCreateTime) {
        this.zddsCreateTime = zddsCreateTime;
    }

    /**
     * 总调度室审批人
     */
    public String getZddsSpecialist() {
        return zddsSpecialist;
    }

    /**
     * 总调度室审批人
     */
    public void setZddsSpecialist(String zddsSpecialist) {
        this.zddsSpecialist = zddsSpecialist == null ? null : zddsSpecialist.trim();
    }

    /**
     * 总调度室审批人ID
     */
    public Integer getZddsUserId() {
        return zddsUserId;
    }

    /**
     * 总调度室审批人ID
     */
    public void setZddsUserId(Integer zddsUserId) {
        this.zddsUserId = zddsUserId;
    }

    /**
     * 民航空管审批人所属航管中心
     */
    public Integer getMhkgAcceptNcId() {
        return mhkgAcceptNcId;
    }

    /**
     * 民航空管审批人所属航管中心
     */
    public void setMhkgAcceptNcId(Integer mhkgAcceptNcId) {
        this.mhkgAcceptNcId = mhkgAcceptNcId;
    }

    /**
     * 民航空管审批时间
     */
    public Date getMhkgCreateTime() {
        return mhkgCreateTime;
    }

    /**
     * 民航空管审批时间
     */
    public void setMhkgCreateTime(Date mhkgCreateTime) {
        this.mhkgCreateTime = mhkgCreateTime;
    }

    /**
     * 民航空管审批人
     */
    public String getMhkgSpecialist() {
        return mhkgSpecialist;
    }

    /**
     * 民航空管审批人
     */
    public void setMhkgSpecialist(String mhkgSpecialist) {
        this.mhkgSpecialist = mhkgSpecialist == null ? null : mhkgSpecialist.trim();
    }

    /**
     * 民航空管审批人ID
     */
    public Integer getMhkgUserId() {
        return mhkgUserId;
    }

    /**
     * 民航空管审批人ID
     */
    public void setMhkgUserId(Integer mhkgUserId) {
        this.mhkgUserId = mhkgUserId;
    }

    /**
     * 民航空管审批意见
     */
    public String getMhkgacceptRemark() {
        return mhkgacceptRemark;
    }

    /**
     * 民航空管审批意见
     */
    public void setMhkgacceptRemark(String mhkgacceptRemark) {
        this.mhkgacceptRemark = mhkgacceptRemark == null ? null : mhkgacceptRemark.trim();
    }

    /**
     * 民航空管否通过0未审批，1通过，2未通过
     */
    public Integer getMhkgisAccepted() {
        return mhkgisAccepted;
    }

    /**
     * 民航空管否通过0未审批，1通过，2未通过
     */
    public void setMhkgisAccepted(Integer mhkgisAccepted) {
        this.mhkgisAccepted = mhkgisAccepted;
    }
}