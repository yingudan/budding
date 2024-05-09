package com.ripper.budding.wechat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class TheTest {
private DefaultHttpClient httpConn;
	
	public TheTest()
	{
		if (httpConn == null) {
			httpConn = new DefaultHttpClient();
		}
	}
	
	public HttpResponse execute(HttpUriRequest request) throws Exception
	{
		if (httpConn == null) {
			httpConn = new DefaultHttpClient();
		}
		HttpParams params = httpConn.getParams();
		if(params==null){
			params = new BasicHttpParams();
		}
		//连接超时时间
		HttpConnectionParams.setConnectionTimeout(params, 10*1000);
		//sockect连接超时时间40秒
		HttpConnectionParams.setSoTimeout(params, 40*1000);
		httpConn.setParams(params);
		HttpResponse httpResponse = httpConn.execute(request);
		return httpResponse;
	}
	
	public String doGet(String url,Map header) throws Exception {
		HttpGet get = new HttpGet(url);
		if(header!=null){
			Set set = header.keySet();
			  for(Iterator iter = set.iterator(); iter.hasNext();)
			  {
				   String key = (String)iter.next();
				   String value = (String)header.get(key);
				   get.setHeader(key, value);
			  }
		}
		HttpResponse httpResponse = this.execute(get);
		String retSrc = EntityUtils.toString(httpResponse.getEntity(),
				HTTP.UTF_8);
		return retSrc;
	}
	
	public String doPost(String url,Map header, Map param) throws Exception
	{
		//声明一个httppost请求
		HttpPost post = new HttpPost(url);
		//存放请求路径后面的参数对
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		if (param != null) 
		{
			//得到键集合
			Set<String> key = param.keySet();
			//遍历键集合，给name和value赋值，并把键值对赋值给了namevaluepair
			for (Iterator it = key.iterator(); it.hasNext();) {
				String name = (String) it.next();
				String value = param.get(name) == null ? "" : ""
						+ param.get(name);
				nameValuePair.add(new BasicNameValuePair(name, value));
			}
		}
		post.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));
		HttpResponse httpResponse = this.execute(post);
		String retSrc = EntityUtils.toString(httpResponse.getEntity(),HTTP.UTF_8);
		return retSrc;
	}
	
	public static void main(String[] args) throws Exception {
		//https://uim.bangcommunity.com/APPLogin/getOfflineMsg
//		Map p = new HashMap();
//		p.put("access_token", "2FAuqPbWAUIujG7pe36fJtdPcpi_inygcdPmPt5Sc3ODDJsLs8PNEqWCydhJggG8Eq7Phe"
//				+ "j77dQVK6VBOX5adZMJ8pc1hJ-56wSQvrHY58ILl38Tz2tPVJYg5iB5tV2dPCLgAEAHUD");
//		p.put("body", "{ }");
//		
//		
//		String str=new TheTest().doPost("https://api.weixin.qq.com/cgi-bin/qrcode/create", null,p);
//		
//	    System.out.println(str);
	    System.out.println(System.currentTimeMillis());
		//http://newsapi.xujm.com/topic/topicList
//	    Map header=new HashMap();
//	    header.put("userid", "068D83C3ED994131845E0748E85B67B6");
	    //String str2=new testpost().doGet("http://newsapi.xujm.com/topic/topicList",header);
	    //System.out.println(str2);
	}
}
