package com.golden.ihome.crm.dao.house;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.addr.model.EduFacilityModel;
import com.golden.ihome.crm.model.AddrDetailModel;
import com.golden.ihome.crm.model.HouseLeaseModel;
import com.golden.ihome.crm.model.HouseLinkManModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author dl
 * 类名称：租赁房源管理dao
 * 时间：2016-11-1
 */
@Repository(value="houseLeaseDao")
public class HouseLeaseDao extends IBaseDao{

	public List<AddrDetailModel> getAddrDetail(Map<String, Object> map) {
		return this.excutor.queryForList("houseLease.getAddrDetail", map);
	}

	public Integer insertHourseInfo(Map<String, Object> map) {
		return this.excutor.insert("houseLease.insertHourseInfo", map);
	}

	public Integer insertHouseLease(Map<String, Object> map) {
		return this.excutor.insert("houseLease.insertHouseLease", map);
	}

	public Integer insertCarPortLease(Map<String, Object> map) {
		return this.excutor.insert("houseLease.insertCarPortLease", map);
	}
	/**
	 * 分页查询租赁房源(住宅)
	 * @param map
	 * @return
	 */
	public PagerResult<HouseLeaseModel> getResidenceLeaseListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseLease.getResidenceLeaseListForPage", map);
	}
	/**
	 * 分页查询租赁房源(商铺、写字楼)
	 * @param map
	 * @return
	 */
	public PagerResult<HouseLeaseModel> getShopsOfficeLeaseListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseLease.getShopsOfficeLeaseListForPage", map);
	}
	/**
	 * 分页查询租赁房源(车位)
	 * @param map
	 * @return
	 */
	public PagerResult<HouseLeaseModel> getCarPortLeaseListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseLease.getCarPortLeaseListForPage", map);
	}
	/**
	 * 更新租赁房源 地址库信息
	 * 参数：map {所属ID}
	 */
	public Integer updateHouseLease(Map<String, Object> map) {
		return this.excutor.update("houseLease.updateHouseLease", map);
	}
	/**
	 * 模糊查询详细地址B(用于：房源-车位) dl
	 * @param map
	 * @return
	 */
	public List<AddrDetailModel> getAddrDetailB(Map<String, Object> map) {
		return this.excutor.queryForList("houseLease.getAddrDetailB", map);
	}
	/**
	 * 判断车位是否关联房源
	 * @param map
	 * @return
	 */
	public List<HouseLeaseModel> isContactHouseLease(Map<String, Object> map) {
		return this.excutor.queryForList("houseLease.isContactHouseLease", map);
	}
	/**
	 * 模糊搜索楼盘名称 dl
	 * @param map
	 * @return
	 */
	public List<BasePremisesModel> getPremisesByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("houseLease.getPremisesByMatch", map);
	}
	
	public List<BusiAreaModel> getBa1List() {
		return this.excutor.queryForList("houseLease.getBa1List");
	}

	public List<BusiAreaModel> getBa2List(Map<String, Object> map) {
		return this.excutor.queryForList("houseLease.getBa2List", map);
	}

	public List<EduFacilityModel> getEdusByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("houseLease.getEdusByMatch", map);
	}

	public Integer isExistWithHouseLease(Map<String, Object> map) {
		return this.excutor.queryForObject("houseLease.isExistWithHouseLease", map);
	}

	public Integer isExistWithAddrDetail(Map<String, Object> map) {
		return this.excutor.queryForObject("houseLease.isExistWithAddrDetail", map);
	}

	public Integer insertTemprateAddr(Map<String, Object> map) {
		return this.excutor.insert("houseLease.insertTemprateAddr", map);
	}
	/**
	 * 根据houseInfoId查询房源(住宅、商铺、写字楼) dl
	 * @param map
	 * @return
	 */
	public HouseLeaseModel getHouseLeaseById(Map<String, Object> map) {
		return this.excutor.queryForObject("houseLease.getHouseLeaseById",map);
	}
	/**
	 * 根据houseInfoId查询房源(车位) dl
	 * @param map 
	 * @return
	 */
	public HouseLeaseModel getHouseCarPortById(Map<String, Object> map) {
		return this.excutor.queryForObject("houseLease.getHouseCarPortById", map);
	}
	/**
	 * 根据houseInfoId查询房源联系人 dl
	 * @param map
	 * @return
	 */
	public List<HouseLinkManModel> getHouseLinkManList(Map<String, Object> map) {
		return this.excutor.queryForList("houseLease.getHouseLinkManList", map);
	}
	/**
	 * 修改房源主表信息 dl
	 * @param map
	 * @return
	 */
	public Integer updateHouseInfoById(Map<String, Object> map) {
		return this.excutor.update("houseLease.updateHouseInfoById", map);
	}
	/**
	 * 修改房源 dl
	 * @param map
	 * @return
	 */
	public Integer updateHouseLeaseById(Map<String, Object> map) {
		return this.excutor.update("houseLease.updateHouseLeaseById", map);
	}
	/**
	 * 删除联系人 dl
	 * @param str
	 * @return
	 */
	public Integer deleteHouseLinkMans(String str) {
		return this.excutor.delete("houseLease.deleteHouseLinkMans", str);
	}
	/**
	 * 生成房源价格变动记录 dl
	 * @param map
	 */
	public Integer insertHousePriceChange(Map<String, Object> map){
		return this.excutor.insert("houseLease.insertHousePriceChange", map);
	}
	/**
	 * 房源价格变动-生成跟进记录 dl
	 * @param map
	 */
	public Integer insertHouseFollow(Map<String, Object> map) {
		return this.excutor.insert("houseLease.insertHouseFollow", map);
	}
	/**
	 * 租赁房源详情
	 * 参数：map {所属ID}
	 */
	public HouseLeaseModel getDetail(Map<String, Object> map){
		return this.excutor.queryForObject("houseLease.getHouseLeaseDetail",map);
	}

	/**
	 * 获取限时速递所需参数
	 * 参数：map {所属ID}
	 */
	public HouseLeaseModel getManageTimeLimitExpress(Map<String, Object> map){
		return this.excutor.queryForObject("houseLease.getManageTimeLimitExpress",map);
	}
	/**
	 * 租赁房源分页查询
	 * @param map
	 * @return
	 */
	public PagerResult<HouseLeaseModel> getHouseLeaseListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseLease.getHouseLeaseListForPage", map);
	}

}
