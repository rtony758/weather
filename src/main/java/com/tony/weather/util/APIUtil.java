package com.tony.weather.util;


import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIUtil {
    public String doGet(String userName, String passWord, String url) throws Exception {
        BufferedReader in = null;
        StringBuffer result = null;
        try {

            /**  获取接口地址*/
            String authStr = userName + ":" + passWord;
            String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("UTF-8"));
            URL realUrl = new URL(url);

            /**  打开和URL之间的连接*/
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();

            /**  设置通用的请求属性*/
            connection.setRequestProperty("accept", "/");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");
            connection.setRequestProperty("Authorization", "Basic" + encoding);

            /**  建立实际的连接*/
            connection.connect();

            /**  连接超时时间为3分钟*/
            connection.setConnectTimeout(180000);

            /** 读取页面信息时间为3分钟*/
            connection.setReadTimeout(180000);

            int statusCode = connection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                result = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            }

            return null;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("doGet 方法执行失败"+e.getMessage());
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
