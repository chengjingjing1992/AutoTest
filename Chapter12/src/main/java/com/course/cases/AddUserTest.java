package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Scanner;

public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口接口测试")
    public void addUser() throws IOException, InterruptedException {
        System.out.println("addUser()......");
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);

        //发送请求验证请求
        //下边的代码为写完接口的测试代码
        String result = getResult(addUserCase);
        System.out.println("result==="+result.toString());

        /**
         * 可以先讲
         */
        //查询用户看是否添加成功
        Thread.sleep(100000);

        User user = session.selectOne("findAddedUser",addUserCase);
        Thread.sleep(4000);
        System.out.println("addUserCase.toString()==="+addUserCase.toString());
//        System.out.println(user.toString());

        Assert.assertEquals(addUserCase.getExpected(),result);

        //处理结果，就是判断返回结果是否符合预期

    }
    private String getResult(AddUserCase addUserCase) throws IOException {
        //下边的代码为写完接口的测试代码
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("获取响应结果rslult="+result);
        System.out.println("response.getEntity().toString()="+response.getEntity().toString());
        return result;
    }

}
