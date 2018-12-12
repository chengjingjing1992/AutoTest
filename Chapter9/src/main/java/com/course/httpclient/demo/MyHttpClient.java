package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        String result;
        HttpGet httpGet=new HttpGet("https://www.baidu.com/");
        HttpClient httpClient=new DefaultHttpClient();
        HttpResponse response=httpClient.execute(httpGet);

        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
