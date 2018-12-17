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
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void before(){
                                                    //这个对应的application文件一定是.properties文件
        resourceBundle=ResourceBundle.getBundle("application", Locale.CHINA);
        baseUrl=resourceBundle.getString("baseurl");
    }



    @Test  //获取cookie  的测试方法
    public void testGetCookie() throws IOException {
        HttpGet get=new HttpGet(this.baseUrl+this.resourceBundle.getString("getCookieUrl"));
        HttpClient httpClient=new DefaultHttpClient();
        HttpResponse response=httpClient.execute(get);
        String entity= EntityUtils.toString(response.getEntity());
        System.out.println(entity);
         store=((DefaultHttpClient) httpClient).getCookieStore();
        List<Cookie> cookies=store.getCookies();
        for(Cookie cookie:cookies){
            System.out.println(cookie.toString());
        }

    }
    @Test(dependsOnMethods = {"testGetCookie"})
    public void testGetWithCookie() throws IOException {
        System.out.println("testGetWithCookie()---------------------------");
        String testUrl=this.baseUrl+resourceBundle.getString("test.get.with.cookies");
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient httpClient=new DefaultHttpClient();
        //设置cookie信息
        httpClient.setCookieStore(this.store);
        HttpResponse response=httpClient.execute(get);
        //获取响应状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);
        if(statusCode==200){
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }













//        System.out.println(this.store);
//        String uri = resourceBundle.getString("test.get.with.cookies");
//        String testUrl = this.baseUrl+uri;
//        HttpGet get = new HttpGet(testUrl);
//        DefaultHttpClient client = new DefaultHttpClient();
//        //设置cookies信息
//        client.setCookieStore(this.store);
//
//        HttpResponse response = client.execute(get);
//
//        //获取响应的状态码
//        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println("statusCode = " + statusCode);
//
//        if(statusCode == 200){
//            String result = EntityUtils.toString(response.getEntity(),"utf-8");
//            System.out.println(result);
//        }
    }
}
