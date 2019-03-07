package com.course.dailyexercise;

import com.mysql.jdbc.StringUtils;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class One {


    @Test
    public void test1(){

        System.out.println("如何把一段逗号分割的字符串转换成一个数组?");
        String a="a,bb,ccc,abc,eeee";
        String [] arr=a.split(",");
        System.out.println(Arrays.toString(arr));
        for(String s :arr){
            System.out.println( s);
        }

    }
    @Test//try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后?
    public void test2(){
        //
        try {
            System.out.println("1111");
            return;
        }finally {
            System.out.println("finally内容");
        }

    }
    @Test
    public void test3(){//冒泡排序
        int [] arr=new int[]{100,7,99,0,55,30};


        for(int j=0;j<arr.length-1;j++){
            for(int i=0;i<arr.length-1;i++){
                int temp;
                if(arr[i]<arr[i+1]){
                    temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;

                }

            }
        }

        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test4(){//Date类型转为String
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate=sdf.format(date);
        System.out.println(strDate);

    }
    @Test
    public void testStringUtils(){
//        System.out.println(StringUtils.);
    }
}
