package com.course.testNg.Depend;

import org.testng.annotations.Test;

/**
 * test2() 依赖 test1()。 test1()运行失败 test2()则忽略运行
 */

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1()..run");
        throw new RuntimeException();//故意抛出一个异常 让test1 运行失败
    }
    @Test(dependsOnMethods = {"test1"})  //  注意这里怎么写：dependsOnMethods = {"test1方法名"}
    public void test2(){
        System.out.println("test2()..run");
    }
}
//    test1()..run
//
//        java.lang.RuntimeException
//        at com.course.testNg.Depend.DependTest.test1(DependTest.java:13)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.lang.reflect.Method.invoke(Method.java:498)
//        at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:131)
//        at org.testng.internal.Invoker.invokeMethod(Invoker.java:658)
//        at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:792)
//        at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1103)
//        at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:140)
//        at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:122)
//        at org.testng.TestRunner.privateRun(TestRunner.java:739)
//        at org.testng.TestRunner.run(TestRunner.java:589)
//        at org.testng.SuiteRunner.runTest(SuiteRunner.java:398)
//        at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:392)
//        at org.testng.SuiteRunner.privateRun(SuiteRunner.java:354)
//        at org.testng.SuiteRunner.run(SuiteRunner.java:302)
//        at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)
//        at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)
//        at org.testng.TestNG.runSuitesSequentially(TestNG.java:1145)
//        at org.testng.TestNG.runSuitesLocally(TestNG.java:1067)
//        at org.testng.TestNG.runSuites(TestNG.java:997)
//        at org.testng.TestNG.run(TestNG.java:965)
//        at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
//        at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)
//
//
//        Test ignored.
//
//        ===============================================
//        Default Suite
//        Total tests run: 2, Passes: 0, Failures: 1, Skips: 1                                             失败1个  忽略一个

