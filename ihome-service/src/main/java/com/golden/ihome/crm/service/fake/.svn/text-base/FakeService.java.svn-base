package com.golden.ihome.crm.service.fake;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.fake.FakeDao;
import com.golden.ihome.crm.model.FakeManageModel;
import com.golden.port.framework.handleable.IBaseHandler;

/**
 * @author lb
 * 类名称：打假service
 * 时间：2016-11-23
 */
@Service("fake/fakeService")
public class FakeService implements IBaseHandler{

	@Autowired
	private FakeDao fakeDao;
	/**
	 * 分页查询我的打假
	 * @param map
	 * @return PagerResult
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return fakeDao.getFakePage(param);
	}
	/**
	 * 获取打假信息
	 * @param map 参数:matchStr
	 * @return
	 */
	public FakeManageModel getFakeInfo(Map<String,Object> map){
		return fakeDao.getFakeInfo(map);
	}
}
