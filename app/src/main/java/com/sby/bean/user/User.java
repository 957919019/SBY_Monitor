package com.sby.bean.user;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable
{
    private String id;
    private String version;
    private String createBy;
    private String currentLoginIp;
    private String dateCreated;
    private String email;
    private String empCode;
    private String encode;
    private String expiredTime;
    private String lastLoginIp;
    private String lastLoginTime;
    private String lastUpdateBy;
    private String lastUpdated;
    private String loginAttemptTimes;
    private String loginFaildTime;
    private String name;
    private String nickName;
    private String password;
    private String passwordExpireTime;
    private String passwordFirstModifiedFlag;
    private String status;
    private String type;
    private String age;
    private String driveLicense;
    private String idCard;
    private String regCompany;
    private String sex;
    private String genAirCompanyId;
    private String farmId;
    private String ncId;
    private String approvalRating;
    private String priority;
    private String forModule;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getCurrentLoginIp()
    {
        return currentLoginIp;
    }

    public void setCurrentLoginIp(String currentLoginIp)
    {
        this.currentLoginIp = currentLoginIp;
    }

    public String getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmpCode()
    {
        return empCode;
    }

    public void setEmpCode(String empCode)
    {
        this.empCode = empCode;
    }

    public String getEncode()
    {
        return encode;
    }

    public void setEncode(String encode)
    {
        this.encode = encode;
    }

    public String getExpiredTime()
    {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime)
    {
        this.expiredTime = expiredTime;
    }

    public String getLastLoginIp()
    {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp)
    {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
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

    public String getLoginAttemptTimes()
    {
        return loginAttemptTimes;
    }

    public void setLoginAttemptTimes(String loginAttemptTimes)
    {
        this.loginAttemptTimes = loginAttemptTimes;
    }

    public String getLoginFaildTime()
    {
        return loginFaildTime;
    }

    public void setLoginFaildTime(String loginFaildTime)
    {
        this.loginFaildTime = loginFaildTime;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPasswordExpireTime()
    {
        return passwordExpireTime;
    }

    public void setPasswordExpireTime(String passwordExpireTime)
    {
        this.passwordExpireTime = passwordExpireTime;
    }

    public String getPasswordFirstModifiedFlag()
    {
        return passwordFirstModifiedFlag;
    }

    public void setPasswordFirstModifiedFlag(String passwordFirstModifiedFlag)
    {
        this.passwordFirstModifiedFlag = passwordFirstModifiedFlag;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getDriveLicense()
    {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense)
    {
        this.driveLicense = driveLicense;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getRegCompany()
    {
        return regCompany;
    }

    public void setRegCompany(String regCompany)
    {
        this.regCompany = regCompany;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getGenAirCompanyId()
    {
        return genAirCompanyId;
    }

    public void setGenAirCompanyId(String genAirCompanyId)
    {
        this.genAirCompanyId = genAirCompanyId;
    }

    public String getFarmId()
    {
        return farmId;
    }

    public void setFarmId(String farmId)
    {
        this.farmId = farmId;
    }

    public String getNcId()
    {
        return ncId;
    }

    public void setNcId(String ncId)
    {
        this.ncId = ncId;
    }

    public String getApprovalRating()
    {
        return approvalRating;
    }

    public void setApprovalRating(String approvalRating)
    {
        this.approvalRating = approvalRating;
    }

    public String getPriority()
    {
        return priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    public String getForModule()
    {
        return forModule;
    }

    public void setForModule(String forModule)
    {
        this.forModule = forModule;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", createBy='" + createBy + '\'' +
                ", currentLoginIp='" + currentLoginIp + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", email='" + email + '\'' +
                ", empCode='" + empCode + '\'' +
                ", encode='" + encode + '\'' +
                ", expiredTime='" + expiredTime + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", loginAttemptTimes='" + loginAttemptTimes + '\'' +
                ", loginFaildTime='" + loginFaildTime + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", passwordExpireTime='" + passwordExpireTime + '\'' +
                ", passwordFirstModifiedFlag='" + passwordFirstModifiedFlag + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", driveLicense='" + driveLicense + '\'' +
                ", idCard='" + idCard + '\'' +
                ", regCompany='" + regCompany + '\'' +
                ", sex='" + sex + '\'' +
                ", genAirCompanyId='" + genAirCompanyId + '\'' +
                ", farmId='" + farmId + '\'' +
                ", ncId='" + ncId + '\'' +
                ", approvalRating='" + approvalRating + '\'' +
                ", priority='" + priority + '\'' +
                ", forModule='" + forModule + '\'' +
                '}';
    }
}