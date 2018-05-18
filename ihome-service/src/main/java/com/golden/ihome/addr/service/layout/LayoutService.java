package com.golden.ihome.addr.service.layout;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.layout.LayoutDao;
import com.golden.ihome.addr.model.LayoutModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/**
 * @author chenqian
 * 类名称：户型信息Service
 * 类描述：户型的新增 、修改、分页列表显示
 * 时间：2016-10-17
 */
@Service("layout/layoutService")
public class LayoutService implements IBaseHandler{
	@Autowired
	private LayoutDao layoutDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return null;
	}
	/**
	 * 获取全楼盘户型列表分页
	 * @param param {premisesId:楼盘id 及分页参数}
	 * @return PagerResult<LayoutModel>
	 */
	public PagerResult<LayoutModel> getPremisesLayoutQCPage(Map<String, Object> map) {
		return layoutDao.getPremisesLayoutForPage(map);
	}
	
	/**
	 * 查询楼盘名称List
	 * 参数：map {premisesId:楼盘ID}
	 * @return List<LayoutModel>
	 */
	public List<LayoutModel> getLayoutNameList(Map<String, Object> map){
		return layoutDao.getLayoutNameList(map);
	}
	
	/**
	 * 根据id查询户型
	 * @param param {id}
	 * @return PagerResult<LayoutModel>
	 * @throws Exception 
	 */
	public LayoutModel getLayoutById(Map<String, Object> map) {
		return layoutDao.getLayoutById(map);
	}
	
	/**
	 * 添加户型
	 * @param param {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer addLayout(Map<String, Object> map) throws Exception {
		return layoutDao.addLayout(map);
	}
	/**
	 * 修改户型
	 * @param param {}
	 * @return Integer (非等于0 成功，否则失败)
	 * @throws Exception 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer updateLayout(Map<String, Object> map) throws Exception {	
		return layoutDao.updateLayout(map);
	}
	/**
	 * 删除户型
	 * @param map
	 * @return
	 */
	@TM
	public Integer deleteLayout(Map<String, Object> map){		
		return layoutDao.deleteLayout(map);
	}
	
}

