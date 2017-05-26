package com.sby.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import static com.sby.constant.Constant.CONNECTIVITY_CHANGE_ACTION;

/**
 * 监听网络状态
 * Created by kowal on 2016/12/5.
 */

public class NetChangeReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(action, CONNECTIVITY_CHANGE_ACTION)) {

            Toast.makeText(context, "网络状态变化", Toast.LENGTH_SHORT).show();
        }
    }
}
