package com.yiibai4;

import org.testng.annotations.Test;

public class TestTimeout {
	/*
    下程序设置程序执行时间为4秒；程序中sleep执行只需4秒。因此正常运行，不会抛出异常。
    */
    @Test(timeOut = 5000) // time in mulliseconds
    public void testThisShouldPass() throws InterruptedException {
        Thread.sleep(4000);//等待4秒
        System.out.println("这一条应该是通过的️");
    }

    /*
     下程序设置程序执行时间为1秒；while是个死循环，每0.5秒打印一次。因此会抛出异常。
     */
    @Test(timeOut = 1000)
    public void testThisShouldFail() throws InterruptedException {
        while (true){
            // do nothing
        	Thread.sleep(500);
        	System.out.println("这一条是不不不通过的️");
        }

    }

}