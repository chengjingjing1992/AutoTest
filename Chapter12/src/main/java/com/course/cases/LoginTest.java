package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取HttpClient对象")
    public void beforeTest(){
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);


    }

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void loginTrue() throws IOException {
        System.out.println("登录成功loginTrue()......");

        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",1);//取数据库中id为1 的数据
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //第一步是发送请求
        String result=getResult( loginCase);

        System.out.println("loginTrue()方法中的result="+result);
        System.out.println("loginCase.getExpected()="+loginCase.getExpected());

        //燃后是验证结果
        Assert.assertEquals(loginCase.getExpected(),result



















































        );

    }
    private String getResult(LoginCase loginCase) throws IOException {

        //下边的代码为写完接口的测试代码
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        System.out.println("loginCase.getUserName()="+loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        System.out.println("loginCase.getPassword()="+loginCase.getPassword());
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法                                            //在useManager 方法里返回的是Boolean 类型 到result就是String类型
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }





    @Test(groups = "loginFalse",description = "用户登陆失败接口：用户名不存在")
    public void loginFalse() throws IOException {
        System.out.println("用户登录失败接口loginFalse()......");
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",2);//取数据库 中id为2 的数据
        System.out.println("用户名不存在的情况登录失败 :"+loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //第一步是发送请求
        String result=getResult( loginCase);
        System.out.println("loginFalse()方法中的"+result);
        //燃后是验证结果
        System.out.println("loginCase.getExpected()="+loginCase.getExpected());
        System.out.println("result="+result);
        Assert.assertEquals(loginCase.getExpected(),result);

    }
    @Test(groups = "loginFalse",description = "用户登陆失败接口：用户名正确密码错误")
    public void loginFalsePwdError() throws IOException {
        System.out.println("用户登录失败接口loginFalsePwdError()......");
        SqlSession session =DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",3);//取数据库 中id为3 的数据 即用户名在user 表中存在但是密码错误
        System.out.println("用户名存在但密码错误的情况登录失败 :"+loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //第一步是发送请求
        String result=getResult( loginCase);
        //燃后是验证结果
        System.out.println("loginCase.getExpected()="+loginCase.getExpected());
        Assert.assertEquals(loginCase.getExpected(),result);


    }





}
