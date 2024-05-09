package com.ripper.budding.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Test {
	
	  public static void main(String[] args) throws IOException {   
	        testPost();   
	}
	
	public static void testPost() throws IOException {   
	        /**  
	         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using  
	         *  java.net.URL and //java.net.URLConnection  
	         *  
	         *  使用页面发送请求的正常流程：在页面http://www.faircanton.com/message/loginlytebox.asp中输入用户名和密码，然后按登录，
	         *  跳转到页面http://www.faircanton.com/message/check.asp进行验证
	         *  验证的的结果返回到另一个页面
	         *  
	         *  使用java程序发送请求的流程：使用URLConnection向http://www.faircanton.com/message/check.asp发送请求
	         *  并传递两个参数：用户名和密码
	         *  然后用程序获取验证结果
	         */  
	        URL url = new URL("http://www.faircanton.com/message/check.asp");   
	        URLConnection connection = url.openConnection();   
	        /**  
	         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。  
	         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：  
	         */  
	        connection.setDoOutput(true);   
	        /**  
	         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...  
	         */  
	        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");   
	        out.write("username=kevin&password=*********"); //向页面传递数据。post的关键所在！   
	        // remember to clean up   
	        out.flush();   
	        out.close();   
	        /**  
	         * 这样就可以发送一个看起来象这样的POST：   
	         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:  
	         * text/plain Content-type: application/x-www-form-urlencoded  
	         * Content-length: 99 username=bob password=someword  
	         */  
	        // 一旦发送成功，用以下方法就可以得到服务器的回应：   
	        String sCurrentLine;   
	        String sTotalString;   
	        sCurrentLine = "";   
	        sTotalString = "";   
	        InputStream l_urlStream;   
	        l_urlStream = connection.getInputStream();   
	        // 传说中的三层包装阿！   
	        BufferedReader l_reader = new BufferedReader(new InputStreamReader(   
	                l_urlStream));   
	        while ((sCurrentLine = l_reader.readLine()) != null) {   
	            sTotalString += sCurrentLine + "/r/n";   
	  
	        }   
	        System.out.println(sTotalString);   
	    }

}
