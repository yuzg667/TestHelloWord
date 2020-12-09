package com.yiibai7;

import org.testng.annotations.Test;

public class TestDatabase {

    //belong to "db" group,
    //Run if all methods from "deploy" group are passed.
    @Test(groups="db", dependsOnGroups="deploy")
    public void initDB() {
        System.out.println("This is initDB()");
    }

    //belong to "db" group,
    //Run if "initDB" method is passed.
    @Test(dependsOnMethods = { "initDB" }, groups="db")
    public void testConnection() {
        System.out.println("This is testConnection()");
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/dependency_test.html

