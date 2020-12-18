package com.yiibai10;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestEmpty2 {

    @Test(dataProvider = "dataProvider", groups = {"groupA"})
    public void test1(int number) {
    	System.out.print("-----");
    }

    

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/parameterized-test.html

