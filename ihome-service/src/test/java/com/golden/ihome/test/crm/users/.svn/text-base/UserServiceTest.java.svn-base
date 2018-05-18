package com.golden.ihome.test.crm.users;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * 经纪人查看电话 
 * @author zhr
 */
public class UserServiceTest extends BaseTest{
	/**
	 * 查询模板列表 
	 */
	@Test
	public void excuteTest(){
		this.param.put("houseId", "893");
		this.param.put("seeType", "2");
		this.param.put("demandType", "2");
		this.param.put("userPosi", "1");
		this.param.put("userId", "0003fe98-80cd-40a1-a4e4-59c195d9e087");
		this.param.put("userType", "1");
		this.param.put("orgCode", "02.01.01.01.01.");
		ResultValue result = process("users/userService", this.param);
		System.out.println(result.getData());
	}
	@Test
	public void customerTellTest(){
		this.param.put("demandId", "105");
		this.param.put("demandType", "2");
		this.param.put("userPosi", "1");
		this.param.put("userId", "0003fe98-80cd-40a1-a4e4-59c195d9e087");
		this.param.put("userType", "1");
		this.param.put("orgCode", "02.01.01.01.01.");
		ResultValue result = process("users/userService.customerTell", this.param);
		System.out.println(result.getData());
	}
}
