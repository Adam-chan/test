package com.golden.ihome.test.crm.paper;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;
/**
 * 房源纸测试类 
 */
public class PaperServiceTest extends BaseTest{
	
	/**
	 * 查询模板列表 
	 */
	@Test
	public void excuteTest(){
		param.put("currentPage", 1);
		param.put("rowCount", 10);
		ResultValue result = process("paper/paperService", param);
		System.out.println(result.getData());
	}
	
	/**
	 * 保存
	 * 
	 * */
	@Test
	public void save(){
		param.put("tempName", "测试模板3");
		param.put("content", "<div>{楼盘名称}</div>[更多房源]<div>{楼盘名称}</div>[更多房源]<div>{楼盘名称}</div>");
		param.put("sort", "1");
		param.put("type", "1");
		ResultValue result = process("paper/paperService.save", param);
		System.out.println(result.getData());
	}
	/**
	 * 更新
	 * 
	 * */
	@Test
	public void updatePaperTempTest(){
		param.put("paperId", "10");
		param.put("tempName", "测试模板3");
		param.put("content", "<div>{楼盘名称}</div>[更多房源]<div>{楼盘名称}</div>[更多房源]<div>{楼盘名称}</div>");
		param.put("sort", "1");
		param.put("type", "1");
		ResultValue result = process("paper/paperService.updatePaperTemp", param);
		System.out.println(result.getData());
	}
	/**
	 * 删除开启
	 * 
	 * */
	@Test
	public void updatePaperStatusTest(){
		param.put("paperId", "10");
		//1启用，2删除
		param.put("status", "1");
		ResultValue result = process("paper/paperService.updatePaperStatus", param);
		System.out.println(result.getData());
	}
}
