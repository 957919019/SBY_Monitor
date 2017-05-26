package com.sby.utils;


import android.util.Xml;

import com.sby.bean.flt.MovingFlt;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kowal on 2017/5/20.
 */

public class XMLUtil
{
    /**
     * 根据pull解析XML文档
     *
     * @param inputStream 需要解析的输入流
     * @return 返回解析后的集合，可能为空
     */
    public static String parseXmlByPull(InputStream inputStream)
    {
        XmlPullParser pullParser = Xml.newPullParser();
        List<MovingFlt> movingFltList = null;
        try
        {
            pullParser.setInput(inputStream, "UTF-8");
            //START_TAG, END_TAG, TEXT等等的节点
            int eventType = pullParser.getEventType();
            MovingFlt movingFlt = null;
            //当还没有解析到结束文档的节点，一直循环
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                switch (eventType)
                {
                    case XmlPullParser.START_DOCUMENT: //开始解析文档，最外层的节点<users>
                        movingFltList = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG: //开始解析到节点，需要对每一个定义的节点进行处理
                        if ("QueryJzxxResult".equals(pullParser.getName()))
                        {
                            return pullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG: //结束节点，将解析的userbean加入到集合中
                        if ("QueryJzxxResult".equals(pullParser.getName()))
                        {
                            movingFltList.add(movingFlt);
                            movingFlt = null;
                        }
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                }
                //获取到下一个节点，在触发解析动作
                eventType = pullParser.next();
            }
        } catch (XmlPullParserException | IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
