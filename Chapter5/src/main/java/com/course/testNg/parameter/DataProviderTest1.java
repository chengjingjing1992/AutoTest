package com.course.testNg.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {

    @Test(dataProvider = "data")
    public void test(String name,int age){
        System.out.println("name"+name+";age"+age);
    }
    @DataProvider(name="data")
    public Object [][] dataProvider(){
        Object [][]  o=new         Object [][]{
                {"wang",55},
                {"li",35},
                {"zhang",25},
                {"tain",15},
        };
        return o;
    }
}
