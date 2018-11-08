package com.course.testNg.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite()运行了。。。");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite()运行了。。");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest()运行了。。");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest()运行了。。");
    }
}
