package com.golden.ihome.crm.dao.fake;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.FakeManageModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="fakeDao")
public class FakeDao  extends IBaseDao{

	/**
	 * 分页查询我的打假
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<FakeManageModel> getFakePage(Map<String, Object> map) {
		return this.excutor.queryListPage("fake.getFakePage", map);
	}
	/**
	 * 获取打假信息
	 */
	public FakeManageModel getFakeInfo(Map<String, Object> map){
		return this.excutor.queryForObject("fake.getFakeInfo",map);
	}
	/**
	 * 添加打假
	 */
	public Integer insertFake(Map<String, Object> map) {
		return this.excutor.insert("fake.insertFake", map);
	}
	/**
	 * 添加房源打假
	 */
	public Integer insertHouseFake(Map<String, Object> map) {
		return this.excutor.insert("fake.insertHouseFake", map);
	}
	/**
	 * 添加钥匙打假
	 */
	public Integer insertKeyFake(Map<String, Object> map) {
		return this.excutor.insert("fake.insertKeyFake", map);
	}
	/**
	 * 添加委托书打假
	 */
	public Integer insertProxyFake(Map<String, Object> map) {
		return this.excutor.insert("fake.insertProxyFake", map);
	}
	/**
	 * 获取打假审核中的数量
	 */
	public Integer getFakeCheck(Map<String, Object> map){
		return this.excutor.queryForObject("fake.getFakeCheck",map);
	}
}
