package com.yiibai9;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestApi {
	public static String sendPost(String urlParam) throws HttpException, IOException {
      // 创建httpClient实例对象
      HttpClient httpClient = new HttpClient();
      // 设置httpClient连接主机服务器超时时间：15000毫秒
      httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
      // 创建post请求方法实例对象
      PostMethod postMethod = new PostMethod(urlParam);
      // 设置post请求超时时间
      postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
      postMethod.addRequestHeader("Content-Type", "application/json");
      postMethod.setRequestBody("{\"instanceId\":\"15878538-6b0c-4af3-8057-9585ee5a7b05\",\"refId\":\"PROD651C1548\",\"refType\":\"perfma_xocean\"}");
      httpClient.executeMethod(postMethod);

      String result = postMethod.getResponseBodyAsString();
      postMethod.releaseConnection();
      System.out.println("--------------[post]--------------\n"+result);
      return result;
  }

	public static String sendGet(String urlParam) throws HttpException, IOException {
      // 创建httpClient实例对象
      HttpClient httpClient = new HttpClient();
      // 设置httpClient连接主机服务器超时时间：15000毫秒
      httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
      // 创建GET请求方法实例对象
      GetMethod getMethod = new GetMethod(urlParam);
      // 设置post请求超时时间
      getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
      getMethod.addRequestHeader("Content-Type", "application/json");

      httpClient.executeMethod(getMethod);

      String result = getMethod.getResponseBodyAsString();
      getMethod.releaseConnection();
      System.out.println("--------------[get]--------------\n"+result);
      return result;
  }
	
//	调用上边的方法进行测试
	@Test(dataProvider = "dataProvider")
	public void test1Post(String url) throws HttpException, IOException {
	  String res = sendPost(url);
	  Assert.assertNotNull(res);
//      System.out.println(res);
  }
	@Test(dataProvider = "dataProvider")
	public void test2Get(String url) throws HttpException, IOException {
	  String res = sendGet(url);
	  Assert.assertNotNull(res);
//      System.out.println(res);
  }	
	@Test(dataProvider = "dataProvider")
	public void test3Fail(String url) throws HttpException, IOException {
	  String res = sendGet(url);
	  Assert.assertNull(res);
//      System.out.println(res);
  }	
//	使用数据调用用例
    @DataProvider(name = "dataProvider")
    public Object[][] provideData(Method method) {

        Object[][] result = null;

        if (method.getName().equals("test1Post")) {
            result = new Object[][] {
            	{ "http://mockdog.hellotom.top/testproject/datalist?testNG=test1Post" }
            };
        } else if (method.getName().equals("test2Get")) {
            result = new Object[][] {
                { "http://mockdog.hellotom.top/testproject/datalist?testNG=test2Get" },
            };
        } else if (method.getName().equals("test3Fail")) {
            result = new Object[][] {
                { "http://mockdog.hellotom.top/testproject/datalist?testNG=test3Fail" },
            };
        }

        return result;

    }
}
