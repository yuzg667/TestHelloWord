package com.yiibai7;

import org.testng.annotations.Test;

//all methods of this class are belong to "deploy" group.
@Test(groups = "deploy")
public class TestServer {

  @Test
  public void deployServer() {
      System.out.println("Deploying Server...");
  }

  // Run this if deployServer() is passed.
  @Test(dependsOnMethods = "deployServer")
  public void deployBackUpServer() {
      System.out.println("Deploying Backup Server...");
  }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/dependency_test.html

