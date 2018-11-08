package com.course.testNg.Group;

import org.testng.annotations.Test;

@Test(groups = "student")
public class StudentGroupClass1 {
    public void test1(){
        System.out.println("StudentGroupClass1类的test1()...");
    }
    public void test2(){
        System.out.println("StudentGroupClass1类的test2()...");
    }
}
