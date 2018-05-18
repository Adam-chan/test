package com.golden.ihome.addr.dao.premisesManage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="basePremisesDao")
public class BasePremisesDao extends IBaseDao{

	/**
	 * 楼盘列表分页
	 */
	public PagerResult<BasePremisesModel> getPremisesPage(Map<String, Object> map) {
		return this.excutor.queryListPage("basePremises.getPremisesPage", map);
	}

	/**
	 * 隐藏/显示
	 */
	public Integer updateHidden(Map<String, Object> map) {
		return this.excutor.update("basePremises.updateHidden", map);
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

	public Integer getHousingResources(Map<String, Object> map) {
		return this.excutor.queryForObject("basePremises.getHousingResources", map);
	}

	/**
	 * 删除楼盘
	 */
	public Integer deletePremises(Map<String, Object> map) {
		return this.excutor.update("basePremises.deletePremises", map);
	}

	/**
	 * 模糊匹配详细地址
	 */
	public List<Map<String, Object>> getAddrDetail(Map<String, Object> map){
		return this.excutor.queryForList("basePremises.getAddrDetail", map);
	}

	/**
	 * 模糊匹配站点线路
	 */
	public List<Map<String, Object>> getSiteLineListByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("basePremises.getSiteLineListByMatch", map);
	}

	/**
	 * 模糊匹配教育设施
	 */
	public List<Map<String, Object>> getEduListByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("basePremises.getEduListByMatch", map);
	}

	/**
	 * 提交审核
	 */
	public Integer auditingPremises(Map<String, Object> map) {
		return this.excutor.update("basePremises.auditingPremises", map);
	}

	public List<BasePremisesModel> getPemisesInfoById(Map<String, Object> map) {
		return this.excutor.queryForList("getPemisesInfoById", map);
	}
	/**
	 * 模糊匹配楼盘名称
	 */
	public List<BasePremisesModel> getPemisesInfoList(Map<String, Object> map) {
		return this.excutor.queryForList("basePremises.getPemisesInfoList", map);
	}
	/**
	 * 查询楼盘图片 dl
	 * @param map
	 * @return
	 */
	public List<String> getPemisesImages(Map<String, Object> map) {
		return this.excutor.queryForList("basePremises.getPemisesImages", map);
	}
	/**
	 * 查询已撒道路号是否已存在楼盘
	 * @param map
	 * @return
	 */
	public Integer getPemisesCount(Map<String, Object> map) {
		return this.excutor.queryForObject("basePremises.getPemisesCount", map);
	}
	/**
	 * 查询已撒道路号是否已存在楼盘S
	 * @param map
	 * @return
	 */
	public Integer getPemisesCounts(Map<String, Object> map) {
		return this.excutor.queryForObject("basePremises.getPemisesCounts", map);
	}
	/**
	 * 查看基本楼盘
	 */
	public BasePremisesModel queryPremisesForUpdate(Map<String, Object> map) {
		return this.excutor.queryForObject("basePremises.queryPremisesForUpdate", map);
	}
	/**
	 * 查询楼盘下社区和街道数量
	 * @param map
	 * @return
	 */
	public Integer getDeteleVerify(Map<String, Object> map) {
		return this.excutor.queryForObject("basePremises.getDeteleVerify", map);
	}
}
 