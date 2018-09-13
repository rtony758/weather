package com.tony.weather.util;

import com.tony.weather.domain.WeatherInfo;
import net.sf.json.JSONObject;

public class GetWeather {

    public static WeatherInfo GetWeather(String weatherInfobyJson) throws Exception {

        String userName = "tcszhb";
        String passWord = "aLN@9cPTEJWs";
        String url = "https://metapi.goldwind.com.cn:443/api/token";
        String url2 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2010/?lon=120&lat=30";

        JSONObject dataOfJson = JSONObject.fromObject(weatherInfobyJson);
//        if (dataOfJson.getInt("status")!=1000)
//            return null;

        //  创建WeatherInfo对象，提取所需的气象信息
        WeatherInfo weatherInfo = new WeatherInfo();

        //  创建获取Token的类的对象
        TokenUtil tokenUtil = new TokenUtil();

        //  传参去获取Token
        JSONObject doGetToken = JSONObject.fromObject((tokenUtil.doGet(userName, passWord, url)));

        //  将获取到的Token赋值给accessToken
        Object accessToken = doGetToken.get("token");

        //  将Token对象转成字符串
        String token = (String) accessToken;

        //  传参去获取气象数据
        tokenUtil.doGet(userName, token, url2);

        //  从JSON数据中提取信息
        Integer year = dataOfJson.getInt("info");

//        dataOfJson = JSONObject.fromObject(year);

        weatherInfo.setYear(year);
        System.out.println(year);


        return weatherInfo;
    }

    public static void main(String[] args) throws Exception {

        GetWeather getWeather = new GetWeather();
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.toString();
        System.out.println(weatherInfo.getYear());



    }


}
