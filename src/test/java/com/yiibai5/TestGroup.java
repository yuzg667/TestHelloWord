package com.yiibai5;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
/*
 下程序中共分了database、selenium-test两个组
 */
public class TestGroup {
/*
 @BeforeGroups: 
 */
    @BeforeGroups("database")  //在有标记[groups = "database"]组的方法前才运行这个，不会单独运行
    public void setupDB() {
        System.out.println("setupDB()");
    }

    @AfterGroups("database") //在有标记[groups = "database"]组的方法后才运行这个，不会单独运行
    public void cleanDB() {
        System.out.println("cleanDB()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium1() {
        System.out.println("runSelenium()1");
    }

    @Test(groups = "database")
    public void testConnectOracle() {
        System.out.println("testConnect--Oracle()");
    }

//    @Test(groups = "database")
//    @Test(groups = {"mysql","database"})  //同时属于多个分组使用形式
    @Test(groups = {"mysql"})  //同时属于多个分组使用形式
    public void testConnectMsSQL() {
        System.out.println("testConnectMsSQL");
    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/testng-groups.html#article-start


//    @Test(dependsOnGroups = { "database", "selenium-test" })
//    @Test(dependsOnGroups = { "database" })
    @Test(dependsOnGroups = { "mysql" })
    public void runFinal() {
        System.out.println("runFinal");
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/testng-groups.html#article-start

