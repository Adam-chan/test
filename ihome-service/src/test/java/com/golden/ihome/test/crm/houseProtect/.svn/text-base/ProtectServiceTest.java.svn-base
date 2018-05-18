package com.golden.ihome.test.crm.houseProtect;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class ProtectServiceTest  extends BaseTest{
	/**
	 * 房源保护列表查询
	 */
	@Test
	public void excuteTest(){
		this.param.put("currentPage", "1");
		this.param.put("rowCount", "10");
		ResultValue result = process("houseManage/protectService", this.param);
		System.out.println(result.getData());
	}
}
