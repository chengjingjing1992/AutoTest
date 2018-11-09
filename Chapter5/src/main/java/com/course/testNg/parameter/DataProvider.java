package com.course.testNg.parameter;

import org.testng.annotations.Test;

import java.lang.reflect.Method;//！！！注意导入的是reflect 的包

public class DataProvider {
    @Test(dataProvider = "data")
    public void testDataProvider(String name , int age){
//        运行该方法  输出结果:name=zhangSan  ，   age=25
//        name=Lisi  ，   age=35
//        name=wangWu  ，   age=45
        System.out.println("name="+name +"  ，   age="+age);
    }
    @org.testng.annotations.DataProvider(name = "data")  //DataProvider(name = "data")和 line6 的 @Test(dataProvider = "data") data 相对应  会把数据传给上面的方法
    public Object[][] providerData(){
        Object[][] o=new Object[][]{
                {"zhangSan",25},//注意上面的 是 age 是int 类型,那么 这里的25 是不带双引号的
                {"Lisi",35},
                {"wangWu",45}
        };
        return o;
    }


    /**
     * 根据不同的方法  传不同的参数
     * @param name
     * @param age
     */
    @Test(dataProvider = "sss")
    public  void testA(String name , int age){
        System.out.println("testA"+"name="+name +";  age="+age);
    }
    @Test(dataProvider = "sss")
    public  void testB(String name , int age){
        System.out.println("testA"+"name="+name +";  age="+age);
    }
    @org.testng.annotations.DataProvider(name = "sss")
    public Object [][] providerData1(Method method){  //！！！Method method 通过这个获取不同的 方法名
        Object[][] o;
        if (method.getName().equals("testA")){
            o=new Object[][]{
                    {"zhangSan",25},//注意上面的 是 age 是int 类型,那么 这里的25 是不带双引号的
                    {"Lisi",35},
                    {"wangWu",45}
            };
            return o;
        };
        if (method.getName().equals("testB")){
                o=new Object[][]{
                        {"wukong",1000},//注意上面的 是 age 是int 类型,那么 这里的25 是不带双引号的
                        {"nezha",500},
                        {"erlangshne",600}
                };
                return o;

        }
        return null;
    }





}
