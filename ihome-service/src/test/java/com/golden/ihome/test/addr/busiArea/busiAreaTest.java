package com.golden.ihome.test.addr.busiArea;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class busiAreaTest  extends BaseTest{
	
	@Test
	public void executeTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", "1");
		map.put("rowCount", "100");
		map.put("areaLevel", "1");
		map.put("busiZoningID", "1");
		ResultValue process = process("busiArea/BusiAreaService.getBusiAreaQCPage", map);
		System.out.println(process.getData());
	}
	
	@Test
	public void  getBusiAreaList() {
		Map<String, Object> map = new HashMap<String, Object>();
		ResultValue process = process("busiArea/BusiAreaService.getBusiAreaList", map);
		System.out.println(process.getData());
	}
}
