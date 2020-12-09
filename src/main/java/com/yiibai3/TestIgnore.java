package com.yiibai3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIgnore {

    @Test // default enable=true
    public void test1() {
    	System.out.println("默认-未设置忽略");
        Assert.assertEquals(true, true);
    }

    @Test(enabled = true)
    public void test2() {
    	System.out.println("手动-未设置忽略");
        Assert.assertEquals(true, true);
    }

    @Test(enabled = false)
    public void test3() {
    	System.out.println("默认-设置忽略");
        Assert.assertEquals(true, true);
    }

}