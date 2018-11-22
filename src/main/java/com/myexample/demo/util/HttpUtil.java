package com.myexample.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {
//	 public static String sendPost(String url, String param) {
//	        PrintWriter out = null;
//	        BufferedReader in = null;
//	        String result = "";
//	        try {
//	            URL realUrl = new URL(url);
//	            // 打开和URL之间的连接
//	            URLConnection conn = realUrl.openConnection();
//	            // 设置通用的请求属性
//	            conn.setRequestProperty("Content-Type", "multipart/form-data");
//	            conn.setRequestProperty("connection", "Keep-Alive");
//	            conn.setRequestProperty("Charset", "UTF-8");
//	            // 发送POST请求必须设置如下两行
//	            conn.setDoOutput(true);
//	            conn.setDoInput(true);
//	            // 获取URLConnection对象对应的输出流
//	            out = new PrintWriter(conn.getOutputStream());
//	            // 发送请求参数
//	            out.print(param);
//	            // flush输出流的缓冲
//	            out.flush();
//	            // 定义BufferedReader输入流来读取URL的响应
//	            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	            String line;
//	            while ((line = in.readLine()) != null) {
//	                result += line;
//	            }
//	        } catch (Exception e) {
//	            System.out.println("发送 POST 请求出现异常！"+e);
//	            e.printStackTrace();
//	        }
//	        //使用finally块来关闭输出流、输入流
//	        finally{
//	            try{
//	                if(out!=null){
//	                    out.close();
//	                }
//	                if(in!=null){
//	                    in.close();
//	                }
//	            }
//	            catch(IOException ex){
//	                ex.printStackTrace();
//	            }
//	        }
//	        return result;
//	    }    
	
	public static String sendPost(String url,  Map<String,Object> params) throws Exception{
		URL realUrl = new URL(url);
		// 开始访问
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");

		HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.setConnectTimeout(10000);//连接超时时间30s
		conn.setReadTimeout(10000);//读取数据超时时间30s
		conn.getOutputStream().write(postDataBytes);

		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		StringBuilder sb = new StringBuilder();
		for (int c; (c = in.read()) >= 0;)
			sb.append((char) c);
		String response = sb.toString();
		return response;     

	}
	
	public static String sendPostByjson(String url, String jsonparams) throws Exception{
		URL realUrl = new URL(url);
		// 开始访问
//		StringBuilder postData = new StringBuilder();
//		for (Map.Entry<String, Object> param : params.entrySet()) {
//			if (postData.length() != 0)
//				postData.append('&');
//			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//			postData.append('=');
//			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//		}
		byte[] postDataBytes = jsonparams.getBytes("UTF-8");

		HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.setConnectTimeout(10000);//连接超时时间30s
		conn.setReadTimeout(10000);//读取数据超时时间30s
		conn.getOutputStream().write(postDataBytes);

		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		StringBuilder sb = new StringBuilder();
		for (int c; (c = in.read()) >= 0;)
			sb.append((char) c);
		String response = sb.toString();
		return response;     

	}
	
}
