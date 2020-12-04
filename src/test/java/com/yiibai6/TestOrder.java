package com.yiibai6;

import org.testng.annotations.Test;

public class TestOrder {

    @Test(groups={"orderBo", "save"})
    public void testMakeOrder() {
      System.out.println("testMakeOrder");
    }

    @Test(groups={"orderBo", "save"})
    public void testMakeEmptyOrder() {
      System.out.println("testMakeEmptyOrder");
    }

    @Test(groups="orderBo")
    public void testUpdateOrder() {
        System.out.println("testUpdateOrder");
    }

    @Test(groups="orderBo")
    public void testFindOrder() {
        System.out.println("testFindOrder");
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/suite-test.html#article-start

