package com.sby.bean.flt;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kowal on 2017/5/20.
 */

public class MovingFlt implements Serializable
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
    private List<POINTSBean> POINTS;
    private List<MovingFlt> movingFltList;

    public List<MovingFlt> getMovingFltList()
    {
        return movingFltList;
    }

    public void setMovingFltList(List<MovingFlt> movingFltList)
    {
        this.movingFltList = movingFltList;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getVERSION()
    {
        return VERSION;
    }

    public void setVERSION(int VERSION)
    {
        this.VERSION = VERSION;
    }

    public String getAIR_FIELD_ID()
    {
        return AIR_FIELD_ID;
    }

    public void setAIR_FIELD_ID(String AIR_FIELD_ID)
    {
        this.AIR_FIELD_ID = AIR_FIELD_ID;
    }

    public String getAIRCRAFT_CODE()
    {
        return AIRCRAFT_CODE;
    }

    public void setAIRCRAFT_CODE(String AIRCRAFT_CODE)
    {
        this.AIRCRAFT_CODE = AIRCRAFT_CODE;
    }

    public int getAIRCRAFT_ID()
    {
        return AIRCRAFT_ID;
    }

    public void setAIRCRAFT_ID(int AIRCRAFT_ID)
    {
        this.AIRCRAFT_ID = AIRCRAFT_ID;
    }

    public String getCREATE_BY()
    {
        return CREATE_BY;
    }

    public void setCREATE_BY(String CREATE_BY)
    {
        this.CREATE_BY = CREATE_BY;
    }

    public String getCREATE_TIME()
    {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME)
    {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getDATE_CREATED()
    {
        return DATE_CREATED;
    }

    public void setDATE_CREATED(String DATE_CREATED)
    {
        this.DATE_CREATED = DATE_CREATED;
    }

    public String getLAST_UPDATE_BY()
    {
        return LAST_UPDATE_BY;
    }

    public void setLAST_UPDATE_BY(String LAST_UPDATE_BY)
    {
        this.LAST_UPDATE_BY = LAST_UPDATE_BY;
    }

    public String getLAST_UPDATED()
    {
        return LAST_UPDATED;
    }

    public void setLAST_UPDATED(String LAST_UPDATED)
    {
        this.LAST_UPDATED = LAST_UPDATED;
    }

    public String getLINE_COLOR()
    {
        return LINE_COLOR;
    }

    public void setLINE_COLOR(String LINE_COLOR)
    {
        this.LINE_COLOR = LINE_COLOR;
    }

    public int getLINE_ID()
    {
        return LINE_ID;
    }

    public void setLINE_ID(int LINE_ID)
    {
        this.LINE_ID = LINE_ID;
    }

    public String getLINE_TABLE()
    {
        return LINE_TABLE;
    }

    public void setLINE_TABLE(String LINE_TABLE)
    {
        this.LINE_TABLE = LINE_TABLE;
    }

    public int getNC_ID()
    {
        return NC_ID;
    }

    public void setNC_ID(int NC_ID)
    {
        this.NC_ID = NC_ID;
    }

    public String getTERMINAL_ID()
    {
        return TERMINAL_ID;
    }

    public void setTERMINAL_ID(String TERMINAL_ID)
    {
        this.TERMINAL_ID = TERMINAL_ID;
    }

    public String getUSER_ID()
    {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID)
    {
        this.USER_ID = USER_ID;
    }

    public String getPLAN_ID()
    {
        return PLAN_ID;
    }

    public void setPLAN_ID(String PLAN_ID)
    {
        this.PLAN_ID = PLAN_ID;
    }

    public String getCOMPANY()
    {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY)
    {
        this.COMPANY = COMPANY;
    }

    public String getAIRCRAFT_TYPE()
    {
        return AIRCRAFT_TYPE;
    }

    public void setAIRCRAFT_TYPE(String AIRCRAFT_TYPE)
    {
        this.AIRCRAFT_TYPE = AIRCRAFT_TYPE;
    }

    public String getTAKEOFF_AIRPORT()
    {
        return TAKEOFF_AIRPORT;
    }

    public void setTAKEOFF_AIRPORT(String TAKEOFF_AIRPORT)
    {
        this.TAKEOFF_AIRPORT = TAKEOFF_AIRPORT;
    }

    public String getLANDING_AIRPORT()
    {
        return LANDING_AIRPORT;
    }

    public void setLANDING_AIRPORT(String LANDING_AIRPORT)
    {
        this.LANDING_AIRPORT = LANDING_AIRPORT;
    }

    public String getTAKEOFF_TIME()
    {
        return TAKEOFF_TIME;
    }

    public void setTAKEOFF_TIME(String TAKEOFF_TIME)
    {
        this.TAKEOFF_TIME = TAKEOFF_TIME;
    }

    public String getLANDING_TIME()
    {
        return LANDING_TIME;
    }

    public void setLANDING_TIME(String LANDING_TIME)
    {
        this.LANDING_TIME = LANDING_TIME;
    }

    public int getVOYAGE()
    {
        return VOYAGE;
    }

    public void setVOYAGE(int VOYAGE)
    {
        this.VOYAGE = VOYAGE;
    }

    public String getMAX_CREATED_TIME()
    {
        return MAX_CREATED_TIME;
    }

    public void setMAX_CREATED_TIME(String MAX_CREATED_TIME)
    {
        this.MAX_CREATED_TIME = MAX_CREATED_TIME;
    }

    public List<POINTSBean> getPOINTS()
    {
        return POINTS;
    }

    public void setPOINTS(List<POINTSBean> POINTS)
    {
        this.POINTS = POINTS;
    }

    public static class POINTSBean
    {
        /**
         * ID : 475487
         * VERSION : 1
         * CREATE_BY :
         * CREATED_TIME : 2017/5/19 15:40:00
         * DATE_CREATED :
         * DIRECTION : 70
         * HIGHT : 6554
         * LAST_UPDATE_BY :
         * LAST_UPDATED :
         * LATITUDE : 39.99663611
         * LONGITUDE : 116.4136694
         * MONITOR_ID : 21
         * SPEED : 0
         * LOCATION_MODE : GPS与BD2混合定位
         * ORG_LATITUDE : 39°59′47.89″
         * ORG_LONGITUDE : 116°24′49.21″
         */

        private int ID;
        private int VERSION;
        private String CREATE_BY;
        private String CREATED_TIME;
        private String DATE_CREATED;
        private int DIRECTION;
        private int HIGHT;
        private String LAST_UPDATE_BY;
        private String LAST_UPDATED;
        private String LATITUDE;
        private String LONGITUDE;
        private int MONITOR_ID;
        private int SPEED;
        private String LOCATION_MODE;
        private String ORG_LATITUDE;
        private String ORG_LONGITUDE;

        public int getID()
        {
            return ID;
        }

        public void setID(int ID)
        {
            this.ID = ID;
        }

        public int getVERSION()
        {
            return VERSION;
        }

        public void setVERSION(int VERSION)
        {
            this.VERSION = VERSION;
        }

        public String getCREATE_BY()
        {
            return CREATE_BY;
        }

        public void setCREATE_BY(String CREATE_BY)
        {
            this.CREATE_BY = CREATE_BY;
        }

        public String getCREATED_TIME()
        {
            return CREATED_TIME;
        }

        public void setCREATED_TIME(String CREATED_TIME)
        {
            this.CREATED_TIME = CREATED_TIME;
        }

        public String getDATE_CREATED()
        {
            return DATE_CREATED;
        }

        public void setDATE_CREATED(String DATE_CREATED)
        {
            this.DATE_CREATED = DATE_CREATED;
        }

        public int getDIRECTION()
        {
            return DIRECTION;
        }

        public void setDIRECTION(int DIRECTION)
        {
            this.DIRECTION = DIRECTION;
        }

        public int getHIGHT()
        {
            return HIGHT;
        }

        public void setHIGHT(int HIGHT)
        {
            this.HIGHT = HIGHT;
        }

        public String getLAST_UPDATE_BY()
        {
            return LAST_UPDATE_BY;
        }

        public void setLAST_UPDATE_BY(String LAST_UPDATE_BY)
        {
            this.LAST_UPDATE_BY = LAST_UPDATE_BY;
        }

        public String getLAST_UPDATED()
        {
            return LAST_UPDATED;
        }

        public void setLAST_UPDATED(String LAST_UPDATED)
        {
            this.LAST_UPDATED = LAST_UPDATED;
        }

        public String getLATITUDE()
        {
            return LATITUDE;
        }

        public void setLATITUDE(String LATITUDE)
        {
            this.LATITUDE = LATITUDE;
        }

        public String getLONGITUDE()
        {
            return LONGITUDE;
        }

        public void setLONGITUDE(String LONGITUDE)
        {
            this.LONGITUDE = LONGITUDE;
        }

        public int getMONITOR_ID()
        {
            return MONITOR_ID;
        }

        public void setMONITOR_ID(int MONITOR_ID)
        {
            this.MONITOR_ID = MONITOR_ID;
        }

        public int getSPEED()
        {
            return SPEED;
        }

        public void setSPEED(int SPEED)
        {
            this.SPEED = SPEED;
        }

        public String getLOCATION_MODE()
        {
            return LOCATION_MODE;
        }

        public void setLOCATION_MODE(String LOCATION_MODE)
        {
            this.LOCATION_MODE = LOCATION_MODE;
        }

        public String getORG_LATITUDE()
        {
            return ORG_LATITUDE;
        }

        public void setORG_LATITUDE(String ORG_LATITUDE)
        {
            this.ORG_LATITUDE = ORG_LATITUDE;
        }

        public String getORG_LONGITUDE()
        {
            return ORG_LONGITUDE;
        }

        public void setORG_LONGITUDE(String ORG_LONGITUDE)
        {
            this.ORG_LONGITUDE = ORG_LONGITUDE;
        }
    }
}
