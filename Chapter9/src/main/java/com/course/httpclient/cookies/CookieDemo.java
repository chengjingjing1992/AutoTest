package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class CookieDemo {

    private String baseUrl;
    private ResourceBundle resourceBundle;

    @BeforeTest
    public void before(){
                                                    //这个对应的application文件一定是.properties文件
        resourceBundle=ResourceBundle.getBundle("application", Locale.CHINA);
        baseUrl=resourceBundle.getString("baseurl");
    }



    @Test  //获取cookie  的测试方法
    public void testGetCookie() throws IOException {
        HttpGet get=new HttpGet(this.baseUrl+resourceBundle.getString("getCookieUrl"));
        HttpClient httpClient=new DefaultHttpClient();
        HttpResponse response=httpClient.execute(get);
        String entity= EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        CookieStore store=((DefaultHttpClient) httpClient).getCookieStore();
        List<Cookie> cookies=store.getCookies();
        for(Cookie cookie:cookies){
            System.out.println(cookie.toString());
        }

    }
}
