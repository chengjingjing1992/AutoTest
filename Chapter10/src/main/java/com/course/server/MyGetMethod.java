package com.course.server;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController //意思是请扫描我
public class MyGetMethod {

    @RequestMapping(value = "/getCookie",method = RequestMethod.GET)
    public String getCookie(HttpServletResponse  response){
        Cookie cookie=new Cookie("login","true777");

        //HttpServletResponse  装响应信息
        response.addCookie(cookie);//装响应信息 比如Cookie
        return "恭喜你获得cookies信息成功";
    }

}
