package com.coolweather.android.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.coolweather.android.coolweather.db.City;
import com.coolweather.android.coolweather.db.County;
import com.coolweather.android.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2018/1/11/011.
 */

public class Utility {

    private static final String TAG = "Utility";

    public static boolean handleProvinceResponse(String response) {

        try {
            if(!TextUtils.isEmpty(response)) {
                JSONArray allProvinces = new JSONArray(response);
                Log.e(TAG, allProvinces + "" );
                for (int i = 0; i < allProvinces.length();i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId) {

        try {
            if(!TextUtils.isEmpty(response)) {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length();i++) {
                    JSONObject provinceObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(provinceObject.getString("name"));
                    city.setCityCode(provinceObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCountyResponse(String response,int cityId) {

        try {
            if(!TextUtils.isEmpty(response)) {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length();i++) {
                    JSONObject provinceObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(provinceObject.getString("name"));
                    county.setWeatherId(provinceObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
