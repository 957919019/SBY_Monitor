package com.sby.utils;

import java.io.File;

/**
 * Created by kowal on 2016/12/5.
 */

public class FileUtils
{
    /**
     * 创建一级目录的形式
     * fe : 只在SD卡上建立一级目录（"/sdcard/audio/")：
     */
    public static boolean isFolderExist(String strFolder)
    {
        File file = new File(strFolder);

        if (!file.exists())
        {
            if (file.mkdir())
            {
                return true;
            }
            else
                return false;
        }
        return true;
    }
    /**
     * 建立多级目录的形式如下
     * 例如：在SD卡上建立多级目录（"/sdcard/meido/audio/")：
     */
    public static boolean  isFolderExists(String strFolder) {
        File file = new File(strFolder);
        if (!file.exists()) {
            if (file.mkdirs()) {
                return true;
            } else {
                return false;

            }
        }
        return true;
    }
}
