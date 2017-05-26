package com.sby.bean.flt;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kowal on 2017/5/20.
 */

public class MovFlt implements Serializable
{
    private int ID;

    private int VERSION;

    private String AIR_FIELD_ID;

    private String AIRCRAFT_CODE;

    private int AIRCRAFT_ID;

    private String CREATE_BY;

    private String CREATE_TIME;

    private String DATE_CREATED;

    private String LAST_UPDATE_BY;

    private String LAST_UPDATED;

    private String LINE_COLOR;

    private int LINE_ID;

    private String LINE_TABLE;

    private int NC_ID;

    private String TERMINAL_ID;

    private String USER_ID;

    private String PLAN_ID;

    private String COMPANY;

    private String AIRCRAFT_TYPE;

    private String TAKEOFF_AIRPORT;

    private String LANDING_AIRPORT;

    private String TAKEOFF_TIME;

    private String LANDING_TIME;

    private int VOYAGE;

    private String MAX_CREATED_TIME;

    private List<POINTS> POINTS;

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getID()
    {
        return this.ID;
    }

    public void setVERSION(int VERSION)
    {
        this.VERSION = VERSION;
    }

    public int getVERSION()
    {
        return this.VERSION;
    }

    public void setAIR_FIELD_ID(String AIR_FIELD_ID)
    {
        this.AIR_FIELD_ID = AIR_FIELD_ID;
    }

    public String getAIR_FIELD_ID()
    {
        return this.AIR_FIELD_ID;
    }

    public void setAIRCRAFT_CODE(String AIRCRAFT_CODE)
    {
        this.AIRCRAFT_CODE = AIRCRAFT_CODE;
    }

    public String getAIRCRAFT_CODE()
    {
        return this.AIRCRAFT_CODE;
    }

    public void setAIRCRAFT_ID(int AIRCRAFT_ID)
    {
        this.AIRCRAFT_ID = AIRCRAFT_ID;
    }

    public int getAIRCRAFT_ID()
    {
        return this.AIRCRAFT_ID;
    }

    public void setCREATE_BY(String CREATE_BY)
    {
        this.CREATE_BY = CREATE_BY;
    }

    public String getCREATE_BY()
    {
        return this.CREATE_BY;
    }

    public void setCREATE_TIME(String CREATE_TIME)
    {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getCREATE_TIME()
    {
        return this.CREATE_TIME;
    }

    public void setDATE_CREATED(String DATE_CREATED)
    {
        this.DATE_CREATED = DATE_CREATED;
    }

    public String getDATE_CREATED()
    {
        return this.DATE_CREATED;
    }

    public void setLAST_UPDATE_BY(String LAST_UPDATE_BY)
    {
        this.LAST_UPDATE_BY = LAST_UPDATE_BY;
    }

    public String getLAST_UPDATE_BY()
    {
        return this.LAST_UPDATE_BY;
    }

    public void setLAST_UPDATED(String LAST_UPDATED)
    {
        this.LAST_UPDATED = LAST_UPDATED;
    }

    public String getLAST_UPDATED()
    {
        return this.LAST_UPDATED;
    }

    public void setLINE_COLOR(String LINE_COLOR)
    {
        this.LINE_COLOR = LINE_COLOR;
    }

    public String getLINE_COLOR()
    {
        return this.LINE_COLOR;
    }

    public void setLINE_ID(int LINE_ID)
    {
        this.LINE_ID = LINE_ID;
    }

    public int getLINE_ID()
    {
        return this.LINE_ID;
    }

    public void setLINE_TABLE(String LINE_TABLE)
    {
        this.LINE_TABLE = LINE_TABLE;
    }

    public String getLINE_TABLE()
    {
        return this.LINE_TABLE;
    }

    public void setNC_ID(int NC_ID)
    {
        this.NC_ID = NC_ID;
    }

    public int getNC_ID()
    {
        return this.NC_ID;
    }

    public void setTERMINAL_ID(String TERMINAL_ID)
    {
        this.TERMINAL_ID = TERMINAL_ID;
    }

    public String getTERMINAL_ID()
    {
        return this.TERMINAL_ID;
    }

    public void setUSER_ID(String USER_ID)
    {
        this.USER_ID = USER_ID;
    }

    public String getUSER_ID()
    {
        return this.USER_ID;
    }

    public void setPLAN_ID(String PLAN_ID)
    {
        this.PLAN_ID = PLAN_ID;
    }

    public String getPLAN_ID()
    {
        return this.PLAN_ID;
    }

    public void setCOMPANY(String COMPANY)
    {
        this.COMPANY = COMPANY;
    }

    public String getCOMPANY()
    {
        return this.COMPANY;
    }

    public void setAIRCRAFT_TYPE(String AIRCRAFT_TYPE)
    {
        this.AIRCRAFT_TYPE = AIRCRAFT_TYPE;
    }

    public String getAIRCRAFT_TYPE()
    {
        return this.AIRCRAFT_TYPE;
    }

    public void setTAKEOFF_AIRPORT(String TAKEOFF_AIRPORT)
    {
        this.TAKEOFF_AIRPORT = TAKEOFF_AIRPORT;
    }

    public String getTAKEOFF_AIRPORT()
    {
        return this.TAKEOFF_AIRPORT;
    }

    public void setLANDING_AIRPORT(String LANDING_AIRPORT)
    {
        this.LANDING_AIRPORT = LANDING_AIRPORT;
    }

    public String getLANDING_AIRPORT()
    {
        return this.LANDING_AIRPORT;
    }

    public void setTAKEOFF_TIME(String TAKEOFF_TIME)
    {
        this.TAKEOFF_TIME = TAKEOFF_TIME;
    }

    public String getTAKEOFF_TIME()
    {
        return this.TAKEOFF_TIME;
    }

    public void setLANDING_TIME(String LANDING_TIME)
    {
        this.LANDING_TIME = LANDING_TIME;
    }

    public String getLANDING_TIME()
    {
        return this.LANDING_TIME;
    }

    public void setVOYAGE(int VOYAGE)
    {
        this.VOYAGE = VOYAGE;
    }

    public int getVOYAGE()
    {
        return this.VOYAGE;
    }

    public void setMAX_CREATED_TIME(String MAX_CREATED_TIME)
    {
        this.MAX_CREATED_TIME = MAX_CREATED_TIME;
    }

    public String getMAX_CREATED_TIME()
    {
        return this.MAX_CREATED_TIME;
    }

    public void setPOINTS(List<POINTS> POINTS)
    {
        this.POINTS = POINTS;
    }

    public List<POINTS> getPOINTS()
    {
        return this.POINTS;
    }

    @Override
    public String toString()
    {
        return "MovFlt{" +
                "ID=" + ID +
                ", VERSION=" + VERSION +
                ", AIR_FIELD_ID='" + AIR_FIELD_ID + '\'' +
                ", AIRCRAFT_CODE='" + AIRCRAFT_CODE + '\'' +
                ", AIRCRAFT_ID=" + AIRCRAFT_ID +
                ", CREATE_BY='" + CREATE_BY + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", DATE_CREATED='" + DATE_CREATED + '\'' +
                ", LAST_UPDATE_BY='" + LAST_UPDATE_BY + '\'' +
                ", LAST_UPDATED='" + LAST_UPDATED + '\'' +
                ", LINE_COLOR='" + LINE_COLOR + '\'' +
                ", LINE_ID=" + LINE_ID +
                ", LINE_TABLE='" + LINE_TABLE + '\'' +
                ", NC_ID=" + NC_ID +
                ", TERMINAL_ID='" + TERMINAL_ID + '\'' +
                ", USER_ID='" + USER_ID + '\'' +
                ", PLAN_ID='" + PLAN_ID + '\'' +
                ", COMPANY='" + COMPANY + '\'' +
                ", AIRCRAFT_TYPE='" + AIRCRAFT_TYPE + '\'' +
                ", TAKEOFF_AIRPORT='" + TAKEOFF_AIRPORT + '\'' +
                ", LANDING_AIRPORT='" + LANDING_AIRPORT + '\'' +
                ", TAKEOFF_TIME='" + TAKEOFF_TIME + '\'' +
                ", LANDING_TIME='" + LANDING_TIME + '\'' +
                ", VOYAGE=" + VOYAGE +
                ", MAX_CREATED_TIME='" + MAX_CREATED_TIME + '\'' +
                ", POINTS=" + POINTS +
                '}';
    }
}
