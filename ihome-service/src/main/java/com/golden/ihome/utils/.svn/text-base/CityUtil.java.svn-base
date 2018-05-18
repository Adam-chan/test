package com.golden.ihome.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.golden.port.framework.configs.Config;

public class CityUtil {
	public static List<Map<String,String>> getCityCode(String address) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet post = new HttpGet(address);
		CloseableHttpResponse httpResponse;
		String str = null;
		try {
			httpResponse = httpClient.execute(post);
			HttpEntity entity = httpResponse.getEntity();
			str = EntityUtils.toString(entity);

			JSONObject obj = JSON.parseObject(str);
			Map<String,String> map = null ;
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			if(obj.get("status").toString().toLowerCase().equals("0")){
				JSONArray result = (JSONArray)obj.get("result");
				JSONArray jsonArray = null;
				for(Object jsonObj : result){
					jsonArray = (JSONArray)jsonObj;
					JSONObject jsonObject = null;
					for(Object jo :jsonArray){
						map = new HashMap<String,String>();
						jsonObject = (JSONObject)jo;
						map.put("areaCode", jsonObject.get("id").toString());
						map.put("areaName", jsonObject.get("fullname").toString().trim());
						list.add(map);
					}
				}
			}
	        httpClient.close();
	        return list;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 配置文件中配置 
	 */
	public static String getDefaultUrl(){
		//return "http://apis.map.qq.com/ws/district/v1/getchildren?key=7SZBZ-DUH6X-WEY45-Z55QH-BYPTE-GABUS";
		return Config.getProperties("CITY_CODE");
	}
	
	public static void main(String[] args) throws ClientProtocolException {
		List<Map<String, String>> cityCode = getCityCode(getDefaultUrl());
		for(Map<String, String> map : cityCode){
			System.out.println(map);
		}
	}
}
