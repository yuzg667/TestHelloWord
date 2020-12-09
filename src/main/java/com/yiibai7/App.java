package com.yiibai7;

import org.testng.annotations.Test;

public class App {

    @Test
    public void method1() {
        System.out.println("This is method 1");
//        throw new RuntimeException();//一行报错。若method1报错，则跳过method2

    }

    @Test(dependsOnMethods = { "method1" })
    public void method2() {
        System.out.println("This is method 2");
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/dependency_test.html#article-start

