package com.course.testNg.Group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class TeacherGroup {
    public void test1(){
        System.out.println("TeacherGroup类的test1()...");
    }
    public void test2(){
        System.out.println("TeacherGroup类的test2()...");
    }
}
