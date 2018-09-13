package com.tony.weather.util;


import net.sf.json.JSONObject;

import java.math.BigDecimal;


public class TokenUtilTest extends TokenUtil {

    public static void main(String[] args) {
        TokenUtil tokenUtil = new TokenUtil();

        /** 设置链接参数*/
        String userName = "tcszhb";
        String passWord = "aLN@9cPTEJWs";
        String url = "https://metapi.goldwind.com.cn:443/api/token";
        String url08 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2008/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url09 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2009/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url10 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2010/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url11 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2011/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url12 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2012/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url13 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2013/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url14 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2014/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url15 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2015/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url16 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2016/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";
        String url17 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2017/?lon=120&lat=30&vars=ghi_sfc,rain_sfc,t2m_sfc";

        try {
            /** 加参去获取token的JSON串儿*/
            JSONObject doGetToken = JSONObject.fromObject((tokenUtil.doGet(userName, passWord, url)));
            //System.out.println(doGetToken);

            /** 摘出token串儿中的token*/
            Object accessToken = doGetToken.get("token");

            /** 将摘出的token赋值给变量*/
            String token = (String) accessToken;
            //System.out.println(token);
            String freeMeso08 = tokenUtil.doGet(userName, token, url08);
            String freeMeso09 = tokenUtil.doGet(userName, token, url09);
            String freeMeso10 = tokenUtil.doGet(userName, token, url10);
            String freeMeso11 = tokenUtil.doGet(userName, token, url11);
            String freeMeso12 = tokenUtil.doGet(userName, token, url12);
            String freeMeso13 = tokenUtil.doGet(userName, token, url13);
            String freeMeso14 = tokenUtil.doGet(userName, token, url14);
            String freeMeso15 = tokenUtil.doGet(userName, token, url15);
            String freeMeso16 = tokenUtil.doGet(userName, token, url16);
            String freeMeso17 = tokenUtil.doGet(userName, token, url17);
            System.out.println("----------------------------------------------------------------");
            System.out.println(freeMeso08);
            System.out.println(freeMeso09);
            System.out.println(freeMeso10);
            System.out.println(freeMeso11);
            System.out.println(freeMeso12);
            System.out.println(freeMeso13);
            System.out.println(freeMeso14);
            System.out.println(freeMeso15);
            System.out.println(freeMeso16);
            System.out.println(freeMeso17);

////////////////////////////////////////////////////////////////////////////////////////////////////////////

            /** 去的气象资源返回的JSON串，解析info部分*/
            JSONObject json08 = JSONObject.fromObject(freeMeso08);
            String info08 = json08.optString("info");

            JSONObject json09 = JSONObject.fromObject(freeMeso09);
            String info09 = json09.optString("info");

            /** 摘出info部分--->年份*/
            String stat08 = json08.optString("stat");
            String stat09 = json09.optString("stat");
            json08 = JSONObject.fromObject(info08);
            json09 = JSONObject.fromObject(info09);
            Integer year08 = Integer.valueOf(json08.optString("year"));
            Integer year09 = Integer.valueOf(json09.optString("year"));

            /** stat部分*/
            json08 = JSONObject.fromObject(stat08);
            json09 = JSONObject.fromObject(stat09);
            Double ghi_sfc08 = Double.valueOf(json08.optString("ghi_sfc"));
            Double rain_sfc08 = Double.valueOf(json08.optString("rain_sfc"));
            Double t2m_sfc08 = Double.valueOf(json08.optString("t2m_sfc"));
            Double ghi_sfc09 = Double.valueOf(json09.optString("ghi_sfc"));
            Double rain_sfc09 = Double.valueOf(json09.optString("rain_sfc"));
            Double t2m_sfc09 = Double.valueOf(json09.optString("t2m_sfc"));

            /** 将温度的数值四舍五入*/
            BigDecimal bigDecimal08 = new BigDecimal(t2m_sfc08);
            BigDecimal bigDecimal09 = new BigDecimal(t2m_sfc09);
            BigDecimal temp08 = bigDecimal08.setScale(1, BigDecimal.ROUND_HALF_UP);
            BigDecimal temp09 = bigDecimal09.setScale(1, BigDecimal.ROUND_HALF_UP);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


            System.out.println("----------------------------------------------------------------");

            System.out.println("年份：" + year08);
            System.out.println("ghi_sfc（地面短波总辐照度）:" + ghi_sfc08 + "瓦/平方米");
            System.out.println("rain_sfc（降雨量）:" + rain_sfc08 + "毫米");
            System.out.println("t2m_sfc（2米温度）:" + temp08 + "温度");

            System.out.println("----------------------------------------------------------------");

            System.out.println("年份：" + year09);
            System.out.println("ghi_sfc（地面短波总辐照度）:" + ghi_sfc09 + "瓦/平方米");
            System.out.println("rain_sfc（降雨量）:" + rain_sfc09 + "毫米");
            System.out.println("t2m_sfc（2米温度）:" + temp09 + "温度");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}