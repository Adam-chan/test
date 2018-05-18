package com.golden.ihome.addr.dao.layout;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.LayoutModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author chenqian
 * 类名称：户型管理dao
 * 类描述：户型的新增 、修改、分页列表显示
 * 时间：2016-10-17
 */
@Repository(value="layoutDao")
public class LayoutDao extends IBaseDao{
	
	/**
	 * 楼盘/单元 户型分页列表
	 * 参数：map {premisesId:楼盘ID}
	 * @return PagerResult
	 */
	public PagerResult<LayoutModel> getPremisesLayoutForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("layout.getPremisesLayoutForPage", map);
	}	
	
	/**
	 * 查询楼盘名称List
	 * 参数：map {premisesId:楼盘ID}
	 * @return List<LayoutModel>
	 */
	public List<LayoutModel> getLayoutNameList(Map<String,Object> map){
		return this.excutor.queryForList("layout.getLayoutNameList", map);
	}
	
	/**
	 * 根据Id选户型
	 * 参数：map {Id:户型ID}
	 * @return LayoutModel
	 */
	public LayoutModel getLayoutById(Map<String, Object> map) {
		return this.excutor.queryForObject("layout.getLayoutById", map);
	}
	
	/**
	 * 插入户型
	 * @param map {}
	 * @return {}
	 */
	public Integer addLayout(Map<String, Object> map) {
		return this.excutor.insert("layout.insertLayout", map);
	}
	
	/**
	 * 修改户型
	 * @param map {}
	 * @return Integer(type非等于0 成功，否则失败)
	 */
	public Integer updateLayout(Map<String, Object> map) {
		return this.excutor.update("layout.updateLayout", map);
	}
	
	/**
	 * 删除户型
	 * 参数：map {Id:户型ID}
	 * @return
	 */
	public Integer deleteLayout(Map<String, Object> map) {
		return this.excutor.delete("layout.delete", map);
	}
}
