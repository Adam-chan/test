package com.golden.ihome.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.golden.port.framework.configs.Config;
/**
 * 百度经纬度查询工具 
 * 说明：输入区域名称，返回经纬度
 */
public class SnCalUtil {

	public static Map<String,String> getLngLat(String address) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = getDefaultUrl();
		url = url.replace("myAddress", address);
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse httpResponse = httpClient.execute(post);
		HttpEntity entity = httpResponse.getEntity();
		String str = EntityUtils.toString(entity);
		JSONObject obj = JSON.parseObject(str);
		Map<String,String> map = null ;
		if(obj.get("status").toString().toLowerCase().equals("ok")){
			JSONObject result = (JSONObject)obj.get("result");
			JSONObject json = (JSONObject)result.get("location");
			map = new HashMap<String,String>();
			map.put("lng", json.getString("lng").toString());
			map.put("lat", json.getString("lat").toString());
		}
        httpClient.close();
        return map;
	} 
	/**
	 * 配置文件中配置 
	 */
	public static String getDefaultUrl(){
		//return "http://api.map.baidu.com/geocoder?address=myAddress&output=json&key=DN5VOM4OVZFMVfbIwo28KQA2AI0FS1qS";
		return Config.getProperties("MAP_API_AK");
	}
	public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println(getLngLat("大连市高新区"));
	}
}
