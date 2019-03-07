package com.course.cases;

import com.course.model.User;
import org.json.JSONObject;
import org.testng.Assert;

public class Only {
    public static void main(String[] args) {
        User user=new User();
        user.setId(1);
        user.setAge("22");
        user.setSex("man");
        user.setIsDelete("0");
        user.setPassword("123456");
        user.setPermission("0");
        user.setUserName("张");

        JSONObject jsonObject=new JSONObject(user);
        String a="111";
        String b="113";
        Assert.assertEquals(a,b);



    }
}
