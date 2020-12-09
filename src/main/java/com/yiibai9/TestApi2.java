package com.yiibai9;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

public class TestApi2 {
	public static String sendPost() throws HttpException, IOException {
		String urlParam = "http://mockdog.hellotom.top/testproject/datalist?ip=120.79.75.96";	
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
      System.out.println("--------------[TestApi2][post]\n"+result);
      return result;
  }

	public static String sendGet() throws HttpException, IOException {
		String urlParam = "http://mockdog.hellotom.top/testproject/datalist?ip=120.79.75.96";	
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
      System.out.println("--------------[TestApi2][get]\n"+result);
      return result;
  }
	@Test()
	public static void main() throws HttpException, IOException {
//	    public void Tttt(String url) throws HttpException, IOException {
      System.out.println(sendPost());
      System.out.println(sendGet());
  }
}
