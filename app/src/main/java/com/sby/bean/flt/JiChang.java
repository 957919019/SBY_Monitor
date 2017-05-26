package com.sby.bean.flt;

/**
 * Created by kowal on 2017/5/20.
 */

public class JiChang {
    private String id;
    private String jCName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getjCName() {
        return jCName;
    }

    public void setjCName(String jCName) {
        this.jCName = jCName;
    }

    public JiChang(String id, String jCName) {
        this.id = id;
        this.jCName = jCName;
    }

    public JiChang() {
    }
}
