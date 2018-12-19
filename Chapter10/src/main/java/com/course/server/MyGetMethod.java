package com.course.server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController //意思是请扫描我
@Api(value = "/",description = "这是我全部GET 方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookie",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法获得cookies",httpMethod = "GET")
    public String getCookie(HttpServletResponse  response){
        Cookie cookie=new Cookie("login","true777");

        //HttpServletResponse  装响应信息
        response.addCookie(cookie);//装响应信息 比如Cookie
        return "恭喜你获得cookies信息成功";
    }
    //开发一个要求携带cookies信息访问的get接口
    @RequestMapping(value = "/getWithCookie",method = RequestMethod.GET)
    @ApiOperation(value = "一个要求携带cookies信息访问的get接口",httpMethod = "GET")
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
    /**
     * 第一种  ： 开发一个需要携带参数才能访问的get接口
     * 第一种实现方式 url: key=value&key=value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "第一种  ： 开发一个需要携带参数才能访问的get接口",httpMethod = "GET")
    public Map<String,Integer> gerParam(@RequestParam Integer start,
                                        @RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }
    /**
     * 第二种 写法 开发一个需要携带参数才能访问的get接口
     *  url:ip:port/get/with/param/10/20
     */
    @RequestMapping("/get/with/param/{start}/{end}")
    @ApiOperation(value = "第二种  ： 开发一个需要携带参数才能访问的get接口",httpMethod = "GET")
    public Map<String,Integer> getMapList(@PathVariable Integer start,
                                          @PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋22",400);
        myList.put("干脆22面",1);
        myList.put("衬衫22",300);
        return myList;

    }



}
