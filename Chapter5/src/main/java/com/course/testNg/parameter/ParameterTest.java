package com.course.testNg.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters({"name","age"})//注意这里怎么写
    public void parameterTest(String name,int age){
        System.out.println("name="+name +"  ，   age="+age);
    }
}
