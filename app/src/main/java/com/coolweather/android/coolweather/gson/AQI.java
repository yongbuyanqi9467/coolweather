package com.coolweather.android.coolweather.gson;

/**
 * Created by Administrator on 2018/1/11/011.
 */

public class AQI {

    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
