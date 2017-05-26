package com.sby.http;

import net.sf.json.JSONObject;

import java.util.Iterator;

/**
 * Created by kowal on 2017/5/19.
 */

public class XmlUtils
{

    public static String getSoapRequestData(String methodName, JSONObject params) {
        StringBuffer sb = new StringBuffer(
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.datasource.gosun.com/\">");
        sb.append("<soapenv:Header/><soapenv:Body>");
        sb.append("<web:" + methodName + ">");
        Iterator it = params.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            String value = params.getString(key);
            sb.append("<" + key + ">" + value + "</" + key + ">");
        }
        sb.append("</web:" + methodName + ">");
        sb.append("</soapenv:Body></soapenv:Envelope>");
        return sb.toString();
    }

}
