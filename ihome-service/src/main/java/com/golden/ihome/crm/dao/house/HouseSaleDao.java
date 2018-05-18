package com.golden.ihome.crm.dao.house;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.addr.model.CarPortModel;
import com.golden.ihome.addr.model.EduFacilityModel;
import com.golden.ihome.crm.model.AddrDetailModel;
import com.golden.ihome.crm.model.CommentModel;
import com.golden.ihome.crm.model.HouseLinkManModel;
import com.golden.ihome.crm.model.HouseSaleModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author sy
 * 类名称：买卖房源管理dao
 * 时间：2016-11-2
 */
@Repository(value="houseSaleDao")
public class HouseSaleDao extends IBaseDao{
	
	/**
	 * 新增地址信息
	 * @param map
	 * @return
	 */
	public List<AddrDetailModel> getAddrDetail(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.getAddrDetail", map);
	}
	
	/**
	 * 模糊查询详细地址B(用于：房源-车位) sy
	 * @param map
	 * @return
	 */
	public List<AddrDetailModel> getAddrDetailB(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.getAddrDetailB", map);
	}
	/**
	 * 房间信息
	 * @param map
	 * @return
	 */
	public Integer insertHourseInfo(Map<String, Object> map) {
		return this.excutor.insert("houseSale.insertHourseInfo", map);
	}
	
	/**
	 * 新增买卖房源-住宅
	 * @param map
	 * @return
	 */
	public Integer insertResidenceSale(Map<String, Object> map) {
		return this.excutor.insert("houseSale.insertResidenceSale", map);
	}
	
	/**
	 * 新增买卖房源-商铺
	 * @param map
	 * @return
	 */
	public Integer insertShopsSale(Map<String, Object> map) {
		return this.excutor.insert("houseSale.insertShopsSale", map);
	}
	
	/**
	 * 新增买卖房源-写字楼
	 * @param map
	 * @return
	 */
	public Integer insertOfficeSale(Map<String, Object> map) {
		return this.excutor.insert("houseSale.insertOfficeSale", map);
	}
	
	/**
	 * 新增买卖房源-车位
	 * @param map
	 * @return
	 */
	public Integer insertCarPortSale(Map<String, Object> map) {
		return this.excutor.insert("houseSale.insertCarPortSale", map);
	}
	
	/**
	 * 添加证载地址的同时更新房间表的证载地址
	 * @param map
	 * @return
	 */
	public Integer updateHouseZzdz(Map<String, Object> map){
		return this.excutor.update("houseSale.updateHouseZzdz", map);
	}
	/**
	 * 判断车位是否关联房源
	 * @param map
	 * @return
	 */
	public List<HouseSaleModel> isContactHouseSale(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.isContactHouseSale", map);
	}
	/**
	 * 分页查询租赁房源(住宅  商铺  写字楼) 
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSaleModel> getHouseSaleListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseSale.getHouseSaleListForPage", map);
	}
	
	/**
	 * 分页查询租赁房源(车位) sy
	 * @param map
	 * @return
	 */
	public PagerResult<HouseSaleModel> getCarPortSaleListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("houseSale.getCarPortSaleListForPage", map);
	}
	
	/**
	 * 根据houseInfoId查询房源(住宅、商铺、写字楼) sy
	 * @param map
	 * @return
	 */
	public HouseSaleModel getHouseSaleById(Map<String, Object> map) {
		return this.excutor.queryForObject("houseSale.getHouseSaleById",map);
	}
	
	/**
	 * 根据houseInfoId查询房源(车位) sy
	 * @param map 
	 * @return
	 */
	public HouseSaleModel getHouseCarPortById(Map<String, Object> map) {
		return this.excutor.queryForObject("houseSale.getHouseCarPortById", map);
	}
	
	/**
	 * 根据houseInfoId查询房源联系人 sy
	 * @param map
	 * @return
	 */
	public List<HouseLinkManModel> getHouseLinkManList(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.getHouseLinkManList", map);
	}
	
	/**
	 * 修改房源主表信息 sy
	 * @param map
	 * @return
	 */
	public Integer updateHouseInfoById(Map<String, Object> map) {
		return this.excutor.update("houseSale.updateHouseInfoById", map);
	}
	
	/**
	 * 修改房源信息 sy
	 * @param map
	 * @return
	 */
	public Integer updateHouseSaleById(Map<String, Object> map) {
		return this.excutor.update("houseSale.updateHouseSaleById", map);
	}
	
	/**
	 * 生成房源价格变动记录 sy
	 * @param map
	 */
	public Integer insertHousePriceChange(Map<String, Object> map){
		return this.excutor.insert("houseSale.insertHousePriceChange", map);
	}
	
	/**
	 * 房源价格变动-生成跟进记录 sy
	 * @param map
	 */
	public Integer insertHouseFollow(Map<String, Object> map) {
		return this.excutor.insert("houseSale.insertHouseFollow", map);
	}
	
	/**
	 * 删除联系人 sy
	 * @param str
	 * @return
	 */
	public Integer deleteHouseLinkMans(String str) {
		return this.excutor.delete("houseSale.deleteHouseLinkMans", str);
	}
	
	/**
	 * 查询大商圈 sy
	 * @param map
	 * @return
	 */
	public List<BusiAreaModel> getBa1List() {
		return this.excutor.queryForList("houseSale.getBa1List");
	}
	
	/**
	 * 根据大商圈查询小商圈 sy
	 * @param map
	 * @return
	 */
	public List<BusiAreaModel> getBa2List(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.getBa2List", map);
	}
	
	/**
	 * 模糊搜索教育设施 sy
	 * @param map
	 * @return
	 */
	public List<EduFacilityModel> getEdusByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.getEdusByMatch", map);
	}
	
	/**
	 * 校验房源是否已存在 sy
	 * @param map 
	 * @return
	 */
	public Integer isExistWithHouseSale(Map<String, Object> map) {
		return this.excutor.queryForObject("houseSale.isExistWithHouseSale", map);
	}
	/**
	 * 发表评论-新增
	 * @param map
	 * @return
	 */
	public Integer saveComment(Map<String, Object> map) {
		return this.excutor.insert("houseSale.saveComment", map);
	}

	/**
	 * 发表评论
	 * @param map
	 * @return
	 */
	public List<CommentModel> getCommemnt(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.getCommemnt", map);
	}
	
	/**
	 * 更新出售房源 地址库信息
	 * 参数：map {所属ID}
	 */
	public Integer updateHouseSale(Map<String, Object> map) {
		return this.excutor.update("houseSale.updateHouseSale", map);
	}
	/**
	 * 买卖房源详情
	 * 参数：map {所属ID}
	 */
	public HouseSaleModel getDetail(Map<String, Object> map){
		return this.excutor.queryForObject("houseSale.getHouseSaleDetail",map);
	}
	/**
	 * 联系人List
	 * @param map
	 * @return
	 */
	public List<HouseSaleModel> getLinkManList(Map<String, Object> map) {
		return this.excutor.queryForList("houseSale.getHouseSaleLinkManList", map);
	}
	/**
	根据房间Id获取车位List
	 */
	public List<CarPortModel> getCarPortList(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getCarPortList", map);
	}
	/**
	 * 获取限时速递所需参数
	 * 参数：map {所属ID}
	 */
	public HouseSaleModel getManageTimeLimitExpress(Map<String, Object> map){
		return this.excutor.queryForObject("houseSale.getManageTimeLimitExpress",map);
	}
}
