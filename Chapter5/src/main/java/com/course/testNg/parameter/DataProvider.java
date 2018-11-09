package com.course.testNg.parameter;

import org.testng.annotations.Test;

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

}
