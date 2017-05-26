package com.sby.practice.ui.core;

import android.app.Activity;

import com.sby.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制Activity生命周期
 * Created by kowal on 2016/10/25.
 */

public class ActivityCollector
{
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity)
    {
        activities.add(activity);
        Logger.w( activity.getLocalClassName(), "has been Added!!!!!!!!!!!!!!!!!!" );
    }

    public static void removeActivity(Activity activity)
    {
        activities.remove(activity);
        Logger.w( activity.getLocalClassName(), "has been finished!!!!!!!!!!!!!!!!!!" );
        activity.finish();
    }

    public static void finishAll()
    {
        for (Activity activity : activities)
        {
            if (!activity.isFinishing())
            {
                Logger.w( activity.getLocalClassName(), "has been Killed!!!!!!!!!!!!!!!!!!" );
                activity.finish();
            }
        }
    }
}