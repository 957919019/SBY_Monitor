package com.sby.widget;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/**
 * 传感器相关
 * Created by kowal on 2016/9/22.
 */
public class OrientationSensor implements SensorEventListener {

    private static final String TAG = "BaiduMap";
    private Context mContext;
    private SensorManager mSensorManager;
    private Sensor defaultSensor;
    private float lastX;
    private OrientationSensorListener mOrientationSensorListener;

    public OrientationSensor(Context context) {
        this.mContext = context;
    }

    public void start() {
        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        defaultSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mSensorManager.registerListener(this, defaultSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stop() {
        mSensorManager.unregisterListener(this, defaultSensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.i(TAG,event.values[0]+"  "+event.values[1]+"  "+event.values[2]);
        if (mOrientationSensorListener != null && (Math.abs(event.values[0] - lastX)) > 1){
            mOrientationSensorListener.getOrientation(event.values[0]);
            lastX = event.values[0];
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public interface OrientationSensorListener{
        void getOrientation(float x);
    }

    public void setOrientationListener(OrientationSensorListener orientationSensorListener){
        this.mOrientationSensorListener = orientationSensorListener;
    }
}
