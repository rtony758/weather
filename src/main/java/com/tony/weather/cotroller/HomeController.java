package com.tony.weather.cotroller;

import com.tony.weather.util.TokenUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class HomeController {

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping("/")
    @PostMapping("/")
    public String tokenUtil(String userName,String passWord,String url)throws Exception {

        userName = "tcszhb";
        passWord = "aLN@9cPTEJWs";
        url = "https://metapi.goldwind.com.cn:443/api/token";
        String url2 = "http://54.223.199.3:8082/weather/v1/newres_datasets/gw-c9a3/PY/stat/2010/?lon=120&lat=30";

        try {
            /** 根据userName和passWord来获取token的JSON*/
            JSONObject doGetToken = JSONObject.fromObject((tokenUtil.doGet(userName, passWord, url)));
            System.out.println(doGetToken);

            /** 将token 的JSON中的值取出来赋值给"token"变量*/
            Object accessToken = doGetToken.get("token");
            String token = (String) accessToken;
            System.out.println(token);

            /** 将token放入密码，并填入用户名和地址来获取气象数据*/
            String doGetResult = tokenUtil.doGet(userName, token, url2);
            System.out.println(doGetResult);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
