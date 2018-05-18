package com.golden.ihome.test.addr.premisesManage;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class BasePremisesServiceTest extends BaseTest{

	/**
	 * 根据id查询楼盘信息
	 * @param map
	 * @return
	 */
//	@Test
//	public void getPremisesById(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "1");
//		ResultValue process = process("basePremises/basePremisesService.getPemisesInfoById", map);
//		System.out.println(process.getData());
//	}
	@Test
	public void getPemisesImages(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("premisesId", "1");
		ResultValue process = process("basePremises/basePremisesService.getPemisesImages", map);
		System.out.println(process.getData());
	}

	@Test
	public void addPremisesTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer roadNum = 38;
		Long i = 1L;
		while(i< 2800000L){
			map.put("type", "1");
			map.put("name", "测试楼盘-"+roadNum +"-"+i);
			map.put("alias", "测试-"+roadNum +"-"+i);
			// 地址库
			map.put("roadId", roadNum);
			map.put("roadNum", i);
			map.put("housingPurposes", "1");
			map.put("status", "1");
			process("basePremises/basePremisesService.addPremises", map);
			System.out.println(roadNum);
			i++;
			if(i>500){
				i=1L;
				roadNum++;
			}
		}
	}
}
