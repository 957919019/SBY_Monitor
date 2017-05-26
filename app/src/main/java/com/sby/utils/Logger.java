package com.sby.utils;

import android.util.Log;

/**
 * 自定义log
 * Created by kowal on 2016/10/11.
 */
public class Logger {
	private static boolean isTrue = true;

	public static void i(String tag, String msg) {
		if (isTrue) {
			Log.i(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (isTrue) {
			Log.d(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (isTrue) {
			Log.e(tag, msg);
		}
	}

	public static void v(String tag, String msg) {
		if (isTrue) {
			Log.v(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (isTrue) {
			Log.w(tag, msg);
		}

	}

}
