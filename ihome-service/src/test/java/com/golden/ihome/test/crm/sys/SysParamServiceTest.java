package com.golden.ihome.test.crm.sys;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;
/***
 * 系统参数
 * @author zhr
 * 
 */
public class SysParamServiceTest extends BaseTest{
	/**
	 * 查询模板列表 
	 */
	@Test
	public void excuteTest(){
		ResultValue result = process("sysParam/sysParamService", null);
		System.out.println(result.getData());
	}
	
}
