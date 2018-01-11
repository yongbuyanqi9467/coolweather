package com.coolweather.android.coolweather.util;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2018/1/11/011.
 */

public class HttpUtil {

    private static final String TAG = "HttpUtil";

    public static void sendOkHttpRequest(String address, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        Log.e(TAG, "sendOkHttpRequest" + address );
        client.newCall(request).enqueue(callback);
    }
}
