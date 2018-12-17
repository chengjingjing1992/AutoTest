package com.course.httpclient.ksax;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.DependencyMap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ksaxTest {

    private ResourceBundle bundle;
    private CookieStore store;
    private String ksaxBaseUrl;
    private HttpPost post;
    private HttpResponse response;

    @BeforeTest
    public void before(){
        //这个对应的application文件一定是.properties文件
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        ksaxBaseUrl=bundle.getString("ksaxBaseUrl");

    }

    @Test//从首页登录 并得到Cookie
    public void testLogin() throws IOException {
        String loginUrl=bundle.getString("ksax.login");
        post =new HttpPost(ksaxBaseUrl+loginUrl);
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");


        //添加参数
        JSONObject param =new JSONObject();
        param.put("telphone","13585658502");
        param.put("password","012345");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

       HttpClient client=new DefaultHttpClient();
        ((DefaultHttpClient) client).setCookieStore(this.store);
        response=client.execute(post);

        int status=response.getStatusLine().getStatusCode();
        System.out.println("status="+status);
        if(status==200){
            String result=EntityUtils.toString(response.getEntity());
            System.out.println(result);


            store= ((DefaultHttpClient) client).getCookieStore();
            System.out.println("store"+store.toString());
            List<Cookie> cookieList =store.getCookies();
            for (Cookie c : cookieList){
                System.out.println("cookie=="+c.toString());
            }

        }
    }
    @Test(dependsOnMethods = {"testLogin"})//
    public void testLuruOrder() throws IOException {
        System.out.println("testLuruOrder()......");
        post=new HttpPost(ksaxBaseUrl+bundle.getString("ksax.RepairOrderMng"));

        HttpClient client=new DefaultHttpClient();
//        ((DefaultHttpClient) client).setCookieStore(this.store);
        response=client.execute(post);
        if(response.getStatusLine().getStatusCode()==200){
            String result= EntityUtils.toString(response.getEntity());
            result.replaceFirst("\"","");
            result=result.substring(1);
            result=result.substring(0,result.length()-1);
            result=result.replaceAll("\\\\","");//把\ 替换成 ""
            System.out.println("result="+result);
            //将返回的响应结果字符串转化成为json对象
            JSONObject resultJson = new JSONObject(result);
            System.out.println(""+resultJson.toString());
        }
    }
    @Test(dependsOnMethods = {"testLogin"})//
    public void getOrderList() throws IOException {
        System.out.println("getOrderList()...");
        post =new HttpPost("http://serve.kuaishouax.com/TB_RepairOrderMng/ServiceRepairOrderList");

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        JSONObject param=new JSONObject();
        param.put("serviceproID","2486");
        param.put("pagesize","20");
        param.put("pageindex","1");

        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);



        HttpClient client=new DefaultHttpClient();
        ((DefaultHttpClient) client).setCookieStore(this.store);
        HttpResponse response=client.execute(post);
        String result=EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

}
