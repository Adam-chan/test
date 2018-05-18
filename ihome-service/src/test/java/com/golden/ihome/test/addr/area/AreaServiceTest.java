package com.golden.ihome.test.addr.area;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class AreaServiceTest extends BaseTest{

	@Test
	public void executeTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", "1");
		map.put("rowCount", "100");
		map.put("areaLevel", "1");
		ResultValue process = process("area/areaService", map);
		System.out.println(process.getData());
	}
}
