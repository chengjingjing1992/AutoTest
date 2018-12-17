package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;






public class CookiePostDemo {
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
    @Test //发送post请求 得到cookie
    public void testPostGetCookie() throws IOException {
        String testUrl=baseUrl+resourceBundle.getString("getCookieUrl");
        HttpPost post=new HttpPost(testUrl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        HttpClient client=new DefaultHttpClient();
        HttpResponse  response = client.execute(post);
        String result= EntityUtils.toString(response.getEntity());
        System.out.println("result="+result);
        //cookie不在 response 里 永远在 httpClient 里
        CookieStore store=((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookies=store.getCookies();
        for(Cookie c:cookies){
            System.out.println(c.toString());
        }


    }
}
