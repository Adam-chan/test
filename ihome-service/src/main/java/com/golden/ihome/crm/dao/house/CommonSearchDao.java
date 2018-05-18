package com.golden.ihome.crm.dao.house;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.ihome.crm.model.HouseAffiliationLogModel;
import com.golden.ihome.crm.model.HouseDeedModel;
import com.golden.ihome.crm.model.HousePorxyModel;
import com.golden.ihome.crm.model.ManageProspectImageModel;
import com.golden.ihome.crm.model.ManageProspectInfoModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value = "commonSearchDao")
public class CommonSearchDao extends IBaseDao {

	/**
	 * 查询收藏数据
	 */
	public Integer queryCollect(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.queryCollect", map);
	}

	/**
	 * 收藏
	 */
	public Integer addCollect(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.addCollect", map);
	}

	/**
	 * 取消收藏
	 */
	public Integer deleteCollect(Map<String, Object> map) {
		return this.excutor.delete("commonSearch.deleteCollect", map);
	}
	
	/**
	 * 查询实勘By房源Id
	 */
	public ManageProspectInfoModel getManageProspectInfo(Map<String,Object> map){
		return this.excutor.queryForObject("manageProspectInfo.getManageProspectInfoByHouseInfoId", map);
	}
	
	/**
	 * 查询实勘图片List
	 */
	public PagerResult<ManageProspectImageModel> getManageProspectImagePage(Map<String,Object> map){
		return this.excutor.queryListPage("manageProspectImage.getManageProspectImagePage", map);
	}
	
	/**
	 * 保存实勘信息 
	 */
	public Integer saveProspectInfo(Map<String, Object> param) {
		return this.excutor.insert("manageProspectInfo.saveProspectInfo", param);
	}
	/**
	 * 删除实勘图片
	 * 参数：map
	 */
	public int deleteManageProspectImage(Map<String, Object> param) {
		return this.excutor.insert("manageProspectImage.delete", param);
	}
	
	/**
	 * 查询插入的实勘ID
	 */
	public Integer getLastInsertProspectId(Map<String, Object> map) {
		Integer result = this.excutor.queryForObject("manageProspectInfo.getLastInsertProspectId",map);
		return result;
	}
	
	/**
	 * 保存上传的实勘图片 
	 */
	public Integer saveProspectPicture(Map<String, Object> param) {
		Integer result = this.excutor.insert("manageProspectImage.saveProspectPicture", param);
		return result;
	}
	
	/**
	 * 删除图片
	 */
	public Integer deletePicture(Map<String, Object> param) {
		return this.excutor.delete("manageProspectImage.deletePicture", param);
	}
	
	/**
	 * 提交审核
	 */
	public Integer submitProspect(Map<String, Object> param) {
		return this.excutor.update("manageProspectInfo.submitProspect", param);
	}
	
	/**
	 * 添加跟进
	 */
	public Integer addFollow(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.addFollow", map);
	}

	/**
	 * 查询空看数据
	 */
	public Integer querySpaceSee(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.querySpaceSee", map);
	}

	/**
	 * 添加空看
	 */
	public Integer addSpaceSee(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.addSpaceSee", map);
	}

	/**
	 * 配客列表
	 */
	public PagerResult<CustomerSourceModel> getMatchCustomerListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("commonSearch.getMatchCustomerListForPage", map);
	}

	/**
	 * 查询钥匙数据
	 */
	public Integer queryReceiveKey(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.queryReceiveKey", map);
	}

	/**
	 * 添加钥匙
	 */
	public Integer addKey(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.addKey", map);
	}

	/**
	 * 更改钥匙归属人
	 */
	public Integer updateKeyInfo(Map<String, Object> map) {
		return this.excutor.update("commonSearch.updateKeyInfo", map);
	}
	/**
	 * 查询委托书数据
	 */
	public Map<String, Object> queryProxyInput(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.queryProxyInput", map);
	}
	/**
	 * 查询委托书数据LB
	 */
	public HousePorxyModel queryProxyInfo(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.queryProxyInfo", map);
	}
	/**
	 * 添加委托书
	 */
	public Integer addProxyInput(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.addProxyInput", map);
	}
	/**
	 * 更新委托书
	 */
	public Integer updateProxyInfo(Map<String, Object> map) {
		return this.excutor.update("commonSearch.updateProxyInfo", map);
	}
	/**
	 * 撤销委托书
	 */
	public Integer deleteProxyInput(Map<String, Object> map) {
		return this.excutor.delete("commonSearch.deleteProxyInput", map);
	}

	/**
	 * 查询保护数据
	 */
	public Integer queryProtect(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.queryProtect", map);
	}

	/**
	 * 查询保护数据
	 */
	public Integer queryProtectCount(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.queryProtectCount", map);
	}

	/**
	 * 保护列表
	 */
	public PagerResult<Map<String, Object>> getProtectListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("commonSearch.getProtectListForPage", map);
	}
	/**
	 * 添加保护
	 */
	public Integer addProtect(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.addProtect", map);
	}
	/**
	 * 查询房源归属记录
	 */
	public List<HouseAffiliationLogModel> queryHouseGsLogList(Map<String, Object> map) {
		return this.excutor.queryForList("commonSearch.queryHouseGsLogList", map);
	}
	/**
	 * 添加房源归属记录
	 */
	public Integer insertHouseGsLog(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.insertHouseGsLog", map);
	}
	/**
	 * 更新实勘归属人
	 */
	public Integer updateProspectInfo(Map<String, Object> map) {
		return this.excutor.update("manageProspectInfo.updateProspectInfo", map);
	}
	/**
	 * 查询房产证数据LB
	 */
	public HouseDeedModel queryDeedInfo(Map<String, Object> map) {
		return this.excutor.queryForObject("commonSearch.queryDeedInfo", map);
	}
	/**
	 * 添加房产证
	 */
	public Integer insertDeedInput(Map<String, Object> map) {
		return this.excutor.insert("commonSearch.insertDeedInput", map);
	}
	/**
	 * 撤销房产证
	 */
	public Integer deleteDeedInput(Map<String, Object> map) {
		return this.excutor.delete("commonSearch.deleteDeedInput", map);
	}
}
