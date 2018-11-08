package com.course.testNg.Group;

import org.testng.annotations.Test;

@Test(groups = "student")
public class StudentGroupClass2 {
    public void test1(){
        System.out.println("StudentGroupClass2类的test1()...");
    }
    public void test2(){
        System.out.println("StudentGroupClass2类的test2()...");
    }
}
