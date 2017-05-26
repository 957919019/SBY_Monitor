package com.sby.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import com.sby.constant.Constant;
import com.sby.constant.GlobalVariable;
import com.sby.practice.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 截图
 * Created by kowal on 2016/12/5.
 */
public class ScreenshotsUtil
{
    /**
     * 百度地图截图
     * @param snapshot
     * @return
     */
    public static Bitmap getScreenshots(Context context, Bitmap snapshot)
    {
        if ( !FileUtils.isFolderExists(Constant.PATH)) {
            return null;
        }
        File file = new File(Constant.PATH + Constant.PICNAME + ".png");
        FileOutputStream out;
        try
        {
            out = new FileOutputStream(file);
            if (snapshot.compress(
                    Bitmap.CompressFormat.PNG, 100, out))
            {
                out.flush();
                out.close();
            }
            GlobalVariable.setSharePicname(Constant.PATH + Constant.PICNAME + ".png"); // 保存上次截图的文件名，便于分享时获取路径
            return snapshot;

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分享图片
     */
    public static boolean share(Context context, String imagePath)
    {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imagePath);
        shareIntent.setType("image/*");
        context.startActivity(Intent.createChooser(shareIntent, context.getString(R.string.share_to)));
        return true;
    }
}
