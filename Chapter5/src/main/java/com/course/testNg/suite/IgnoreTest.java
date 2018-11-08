package com.course.testNg.suite;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test(enabled = false)
    public void test2(){
        System.out.println("test2");
    }
    @Test(enabled = true)
    public void test3(){
        System.out.println("test3");
    }
}
