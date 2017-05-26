package com.sby.bean.monitor;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable
{
    private String DATE_CREATED;

    private String LANDING_AIRPORT;

    private String LAST_UPDATED;

    private String MAX_CREATED_TIME;

    private String USER_ID;

    private String TERMINAL_ID;

    private String LAST_UPDATE_BY;

    private int NC_ID;

    private String AIR_FIELD_ID;

    private int LINE_ID;

    private String AIRCRAFT_CODE;

    private String LINE_COLOR;

    private String LANDING_TIME;

    private String CREATE_TIME;

    private int ID;

    private String TAKEOFF_TIME;

    private int VOYAGE;

    private List<POINTS> POINTS;

    private String TAKEOFF_AIRPORT;

    private String PLAN_ID;

    private int AIRCRAFT_ID;

    private String AIRCRAFT_TYPE;

    private String COMPANY;

    private String LINE_TABLE;

    private String CREATE_BY;

    private int VERSION;

    public String getDATE_CREATED()
    {
        return DATE_CREATED;
    }

    public void setDATE_CREATED(String DATE_CREATED)
    {
        this.DATE_CREATED = DATE_CREATED;
    }

    public String getLANDING_AIRPORT()
    {
        return LANDING_AIRPORT;
    }

    public void setLANDING_AIRPORT(String LANDING_AIRPORT)
    {
        this.LANDING_AIRPORT = LANDING_AIRPORT;
    }

    public String getLAST_UPDATED()
    {
        return LAST_UPDATED;
    }

    public void setLAST_UPDATED(String LAST_UPDATED)
    {
        this.LAST_UPDATED = LAST_UPDATED;
    }

    public String getMAX_CREATED_TIME()
    {
        return MAX_CREATED_TIME;
    }

    public void setMAX_CREATED_TIME(String MAX_CREATED_TIME)
    {
        this.MAX_CREATED_TIME = MAX_CREATED_TIME;
    }

    public String getUSER_ID()
    {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID)
    {
        this.USER_ID = USER_ID;
    }

    public String getTERMINAL_ID()
    {
        return TERMINAL_ID;
    }

    public void setTERMINAL_ID(String TERMINAL_ID)
    {
        this.TERMINAL_ID = TERMINAL_ID;
    }

    public String getLAST_UPDATE_BY()
    {
        return LAST_UPDATE_BY;
    }

    public void setLAST_UPDATE_BY(String LAST_UPDATE_BY)
    {
        this.LAST_UPDATE_BY = LAST_UPDATE_BY;
    }

    public int getNC_ID()
    {
        return NC_ID;
    }

    public void setNC_ID(int NC_ID)
    {
        this.NC_ID = NC_ID;
    }

    public String getAIR_FIELD_ID()
    {
        return AIR_FIELD_ID;
    }

    public void setAIR_FIELD_ID(String AIR_FIELD_ID)
    {
        this.AIR_FIELD_ID = AIR_FIELD_ID;
    }

    public int getLINE_ID()
    {
        return LINE_ID;
    }

    public void setLINE_ID(int LINE_ID)
    {
        this.LINE_ID = LINE_ID;
    }

    public String getAIRCRAFT_CODE()
    {
        return AIRCRAFT_CODE;
    }

    public void setAIRCRAFT_CODE(String AIRCRAFT_CODE)
    {
        this.AIRCRAFT_CODE = AIRCRAFT_CODE;
    }

    public String getLINE_COLOR()
    {
        return LINE_COLOR;
    }

    public void setLINE_COLOR(String LINE_COLOR)
    {
        this.LINE_COLOR = LINE_COLOR;
    }

    public String getLANDING_TIME()
    {
        return LANDING_TIME;
    }

    public void setLANDING_TIME(String LANDING_TIME)
    {
        this.LANDING_TIME = LANDING_TIME;
    }

    public String getCREATE_TIME()
    {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME)
    {
        this.CREATE_TIME = CREATE_TIME;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getTAKEOFF_TIME()
    {
        return TAKEOFF_TIME;
    }

    public void setTAKEOFF_TIME(String TAKEOFF_TIME)
    {
        this.TAKEOFF_TIME = TAKEOFF_TIME;
    }

    public int getVOYAGE()
    {
        return VOYAGE;
    }

    public void setVOYAGE(int VOYAGE)
    {
        this.VOYAGE = VOYAGE;
    }

    public List<com.sby.bean.monitor.POINTS> getPOINTS()
    {
        return POINTS;
    }

    public void setPOINTS(List<com.sby.bean.monitor.POINTS> POINTS)
    {
        this.POINTS = POINTS;
    }

    public String getTAKEOFF_AIRPORT()
    {
        return TAKEOFF_AIRPORT;
    }

    public void setTAKEOFF_AIRPORT(String TAKEOFF_AIRPORT)
    {
        this.TAKEOFF_AIRPORT = TAKEOFF_AIRPORT;
    }

    public String getPLAN_ID()
    {
        return PLAN_ID;
    }

    public void setPLAN_ID(String PLAN_ID)
    {
        this.PLAN_ID = PLAN_ID;
    }

    public int getAIRCRAFT_ID()
    {
        return AIRCRAFT_ID;
    }

    public void setAIRCRAFT_ID(int AIRCRAFT_ID)
    {
        this.AIRCRAFT_ID = AIRCRAFT_ID;
    }

    public String getAIRCRAFT_TYPE()
    {
        return AIRCRAFT_TYPE;
    }

    public void setAIRCRAFT_TYPE(String AIRCRAFT_TYPE)
    {
        this.AIRCRAFT_TYPE = AIRCRAFT_TYPE;
    }

    public String getCOMPANY()
    {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY)
    {
        this.COMPANY = COMPANY;
    }

    public String getLINE_TABLE()
    {
        return LINE_TABLE;
    }

    public void setLINE_TABLE(String LINE_TABLE)
    {
        this.LINE_TABLE = LINE_TABLE;
    }

    public String getCREATE_BY()
    {
        return CREATE_BY;
    }

    public void setCREATE_BY(String CREATE_BY)
    {
        this.CREATE_BY = CREATE_BY;
    }

    public int getVERSION()
    {
        return VERSION;
    }

    public void setVERSION(int VERSION)
    {
        this.VERSION = VERSION;
    }
}