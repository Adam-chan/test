package com.golden.ihome.crm.dao.paper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.PaperModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * 房源纸
 * */
@Repository(value="paperDao")
public class PaperDao extends IBaseDao{
	/**
	 * 房源纸模板分页查询 
	 */
	public PagerResult<PaperModel> getPaperListPage(Map<String,Object> param){
		return this.excutor.queryListPage("paper.getPaperForPage", param);
	}
	/**
	 * 保存房源纸模板 
	 */
	public Integer insertPaperTemp(Map<String,Object> param){
		return this.excutor.insert("paper.insertPaperTemp", param);
	}
	/**
	 * 查询模板
	 * 根据名称，ID
	 * 
	 */ 
	public PaperModel getPaperTemp(Map<String,String> param){
		return this.excutor.queryForObject("paper.getPaperTemp", param);
	}
	/**
	 * 更新模板 
	 */
	public Integer updatePaperTemp(Map<String,Object> param){
		return this.excutor.update("paper.updatePaperTemp", param);
	}
	/**
	 * 删除模板（逻辑） 
	 * 参数status
	 */
	public Integer updatePaperStatus(Map<String,Object> param){
		return this.excutor.update("paper.updatePaperStatus", param);
	}
	/**
	 * 修改模板时，要判断该ID以外的模板名称是否存在。 
	 */
	public Integer getPaperCountOfName(Map<String,Object> param){
		return this.excutor.queryForObject("paper.getPaperCountOfName", param);
	}
}
