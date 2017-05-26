package com.sby.bean.flt;

public class POINTS
    {
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

        public void setCREATE_BY(String CREATE_BY)
        {
            this.CREATE_BY = CREATE_BY;
        }

        public String getCREATE_BY()
        {
            return this.CREATE_BY;
        }

        public void setCREATED_TIME(String CREATED_TIME)
        {
            this.CREATED_TIME = CREATED_TIME;
        }

        public String getCREATED_TIME()
        {
            return this.CREATED_TIME;
        }

        public void setDATE_CREATED(String DATE_CREATED)
        {
            this.DATE_CREATED = DATE_CREATED;
        }

        public String getDATE_CREATED()
        {
            return this.DATE_CREATED;
        }

        public void setDIRECTION(int DIRECTION)
        {
            this.DIRECTION = DIRECTION;
        }

        public int getDIRECTION()
        {
            return this.DIRECTION;
        }

        public void setHIGHT(int HIGHT)
        {
            this.HIGHT = HIGHT;
        }

        public int getHIGHT()
        {
            return this.HIGHT;
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

        public void setLATITUDE(String LATITUDE)
        {
            this.LATITUDE = LATITUDE;
        }

        public String getLATITUDE()
        {
            return this.LATITUDE;
        }

        public void setLONGITUDE(String LONGITUDE)
        {
            this.LONGITUDE = LONGITUDE;
        }

        public String getLONGITUDE()
        {
            return this.LONGITUDE;
        }

        public void setMONITOR_ID(int MONITOR_ID)
        {
            this.MONITOR_ID = MONITOR_ID;
        }

        public int getMONITOR_ID()
        {
            return this.MONITOR_ID;
        }

        public void setSPEED(int SPEED)
        {
            this.SPEED = SPEED;
        }

        public int getSPEED()
        {
            return this.SPEED;
        }

        public void setLOCATION_MODE(String LOCATION_MODE)
        {
            this.LOCATION_MODE = LOCATION_MODE;
        }

        public String getLOCATION_MODE()
        {
            return this.LOCATION_MODE;
        }

        public void setORG_LATITUDE(String ORG_LATITUDE)
        {
            this.ORG_LATITUDE = ORG_LATITUDE;
        }

        public String getORG_LATITUDE()
        {
            return this.ORG_LATITUDE;
        }

        public void setORG_LONGITUDE(String ORG_LONGITUDE)
        {
            this.ORG_LONGITUDE = ORG_LONGITUDE;
        }

        public String getORG_LONGITUDE()
        {
            return this.ORG_LONGITUDE;
        }

        @Override
        public String toString()
        {
            return "POINTS{" +
                    "ID=" + ID +
                    ", VERSION=" + VERSION +
                    ", CREATE_BY='" + CREATE_BY + '\'' +
                    ", CREATED_TIME='" + CREATED_TIME + '\'' +
                    ", DATE_CREATED='" + DATE_CREATED + '\'' +
                    ", DIRECTION=" + DIRECTION +
                    ", HIGHT=" + HIGHT +
                    ", LAST_UPDATE_BY='" + LAST_UPDATE_BY + '\'' +
                    ", LAST_UPDATED='" + LAST_UPDATED + '\'' +
                    ", LATITUDE='" + LATITUDE + '\'' +
                    ", LONGITUDE='" + LONGITUDE + '\'' +
                    ", MONITOR_ID=" + MONITOR_ID +
                    ", SPEED=" + SPEED +
                    ", LOCATION_MODE='" + LOCATION_MODE + '\'' +
                    ", ORG_LATITUDE='" + ORG_LATITUDE + '\'' +
                    ", ORG_LONGITUDE='" + ORG_LONGITUDE + '\'' +
                    '}';
        }
    }