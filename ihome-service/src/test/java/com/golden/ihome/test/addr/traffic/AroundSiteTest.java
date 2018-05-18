package com.golden.ihome.test.addr.traffic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class AroundSiteTest extends BaseTest{

	/**
	 * 新增站点信息
	 * @param map,map中参数 1、key:"siteName",value:string 2、key:"trafficType",value:Integer
	 * @return
	 */
	@Test
	public void insertSiteTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<AroundSiteModel> siteList = new ArrayList<AroundSiteModel>();
		AroundSiteModel site = new AroundSiteModel();
		site.setSiteName("wwww");
		site.setTrafficType(1);
		site.setAssistSign("oooo");
		site.setCloseSite("");
		siteList.add(site);
		siteList.add(site);
		map.put("siteList", siteList);
		ResultValue process = process("traffic/aroundSiteService.insertSiteList", map);
		System.out.println(process.getData());
	}
//	/**
//	 * 查询站点名称是否存在
//	 * @param map
//	 * @return
//	 */
//	@Test
//	public void getSiteByNameIs(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("siteName", "万达广场45645");
//		map.put("trafficType", 0);
//		ResultValue process = process("traffic/aroundSiteService.getSiteByNameIs", map);
//		System.out.println(process.getData());
//	}
//	/**
//	 * 分页查询站点
//	 * @param params
//	 * @return
//	 */
//	@Test
//	public void getSiteListForPage(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("currentPage", 1);
//		map.put("rowCount", 6);
//		map.put("trafficType", 0);
//		ResultValue process = process("traffic/aroundSiteService.getSiteListForPage", map);
//		System.out.println(process.getData());
//	}
//	/**
//	 * 修改站点信息
//	 * @param map
//	 * @return
//	 */
//	@Test
//	public void updateSite(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "2");
//		map.put("siteName", "肥嘟嘟");
//		ResultValue process = process("traffic/aroundSiteService.updateSite", map);
//		System.out.println(process.getData());
//	}
//	@Test
//	public void getSiteById(){
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("id", 2);
//		ResultValue process = process("traffic/aroundSiteService.getSiteById", map);
//		System.out.println(process.getData());
//	}
//	/**
//	 * 查询所有站点
//	 * @param params
//	 * @return
//	 */
//	@Test
//	public void getSiteList(){
//		ResultValue process = process("traffic/aroundSiteService.getSiteList",null);
//		System.out.println(process.getData());
//	}
}
