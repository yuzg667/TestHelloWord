package com.yiibai8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterXML {

    Connection con;

    @Test
    @Parameters({ "dbconfig", "poolsize" })
    public void createConnection(String dbconfig, int poolsize) {

        System.out.println("dbconfig : " + dbconfig);
        System.out.println("poolsize : " + poolsize);

        Properties prop = new Properties();
        InputStream input = null;

        try {
            // get properties file from project classpath
            String path = System.getProperty("user.dir")+"\\"+dbconfig;
//            String path = "/Users/yuzg/eclipse-workspace/TestHelloWorld/src/test/java/com/yiibai8/db.properties";

            System.out.println("path => "+path);
            //input = getClass().getClassLoader().getResourceAsStream(path);

            //prop.load(input);
            prop.load(new FileInputStream(dbconfig));  

            String drivers = prop.getProperty("jdbc.driver");
            String connectionURL = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");

            System.out.println("drivers : " + drivers);
            System.out.println("connectionURL : " + connectionURL);
            System.out.println("username : " + username);
            System.out.println("password : " + password);

            Class.forName(drivers);
            con = DriverManager.getConnection(connectionURL, username, password);

        } catch (Exception e) {
        	System.out.println("异常连接1: " + e);
            //e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                    System.out.println("关闭连接" );
                } catch (IOException e) {
                    //e.printStackTrace();
                	System.out.println("异常连接2: " + e);
                }
            }
        }

    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/testng/parameterized-test.html#article-start

