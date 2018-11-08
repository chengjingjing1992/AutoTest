package com.course.testNg;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public  void  testCase1(){
        System.out.println("这是第一个case");
    }
    @Test
    public  void  testCase2(){
        System.out.println("这是第二个case");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("这是方法之前的方法BeforeMethod");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("这是方法之后的方法AfterMethod");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("这类运行之前的方法");
    }
    @AfterClass
    public  void afterClass(){
        System.out.println("这类运行之后的方法");
    }
    @BeforeSuite
    public  void beforeSuite(){
        System.out.println("BeforeSuite 在类之前运行");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite 在类之后运行");
    }

}
