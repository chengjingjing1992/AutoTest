package com.course.server;
import org.omg.CORBA.Object;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController //意思是请扫描我
public class MyGetMethod {

    @RequestMapping(value = "/getCookie",method = RequestMethod.GET)
    public String getCookie(HttpServletResponse  response){
        Cookie cookie=new Cookie("login","true777");

        //HttpServletResponse  装响应信息
        response.addCookie(cookie);//装响应信息 比如Cookie
        return "恭喜你获得cookies信息成功";
    }
    //开发一个要求携带cookies信息访问的get接口
    @RequestMapping(value = "/getWithCookie",method = RequestMethod.GET)
    public String getWithCookie(HttpServletRequest request){

        Cookie []cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            return "请求无携带cookie信息";
        }
        for(Cookie c:cookies){
            if(c.getName().equals("login")&&c.getValue().equals("true")){
                return "请求有携带cookie信息且正确";
            }
        }
     return "请求有携带cookie信息但是不正确";
    }
}
