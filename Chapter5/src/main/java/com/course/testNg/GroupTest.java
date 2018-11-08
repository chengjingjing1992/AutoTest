package com.course.testNg;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupTest {
    @Test(groups = "server")
    public void test1(){
        System.out.println("test1..");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("test3..");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("test4..");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("test2..");
    }
    @BeforeGroups("server")
    public void runBeforeGroupsOnServer(){
        System.out.println("sever方法组之前运行");
    }
    @AfterGroups("server")
    public void runAfterGroups(){
        System.out.println("sever方法组之后运行");
    }
    @BeforeGroups("client")
    public void runBeforeGroupsOnclient(){
        System.out.println("client方法组之前运行");
    }
    @AfterGroups("client")
    public void runAfterGroupsclient(){
        System.out.println("client方法组之后运行");
    }
}
