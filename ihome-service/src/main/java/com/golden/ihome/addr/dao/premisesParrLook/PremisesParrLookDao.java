package com.golden.ihome.addr.dao.premisesParrLook;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.ihome.addr.model.PremisesArrangeLookModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="premisesParrLookDao")
public class PremisesParrLookDao extends IBaseDao{

	/**
	 * 楼盘约带看列表分页
	 */
	public PagerResult<PremisesArrangeLookModel> getParrLookPage(Map<String, Object> map) {
		return this.excutor.queryListPage("parrLook.getParrLookPage", map);
	}

	/**
	 * 楼盘约带看 逻辑删除 修改
	 */
	public Integer updateParrLook(Map<String, Object> map) {
		return this.excutor.update("parrLook.updateParrLook", map);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 买卖封盘/买卖解封
	 */
	public Integer updateSaleSeal(Map<String, Object> map) {
		return this.excutor.update("basePremises.updateSaleSeal", map);
	}

	/**
	 * 租赁封盘/租赁解封
	 */
	public Integer updateLeaseSeal(Map<String, Object> map) {
		return this.excutor.update("basePremises.updateLeaseSeal", map);
	}

	/**
	 * 新增楼盘
	 */
	public Integer addPremises(Map<String, Object> map) {
		return this.excutor.insert("basePremises.addPremises", map);
	}

	/**
	 * 查看楼盘
	 */
	public BasePremisesModel queryPremises(Map<String, Object> map) {
		return this.excutor.queryForObject("basePremises.queryPremises", map);
	}

	/**
	 * 修改楼盘
	 */
	public Integer updatePremises(Map<String, Object> map) {
		return this.excutor.update("basePremises.updatePremises", map);
	}

	/**
	 * 删除楼盘
	 */
	public Integer deletePremises(Map<String, Object> map) {
		return this.excutor.delete("basePremises.deletePremises", map);
	}

	/**
	 * 模糊匹配详细地址
	 */
	public List<Map<String, Object>> getAddrDetail(Map<String, Object> map){
		return this.excutor.queryForList("basePremises.getAddrDetail", map);
	}

	public List<BasePremisesModel> getPemisesInfoById(Map<String, Object> map) {
		return this.excutor.queryForList("getPemisesInfoById", map);
	}
}
 