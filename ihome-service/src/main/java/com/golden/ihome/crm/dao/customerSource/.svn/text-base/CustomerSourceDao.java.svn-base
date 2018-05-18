package com.golden.ihome.crm.dao.customerSource;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.crm.model.CustomerCallBackModel;
import com.golden.ihome.crm.model.CustomerPromiseModel;
import com.golden.ihome.crm.model.CustomerRecommendModel;
import com.golden.ihome.crm.model.CustomerSourceFollowModel;
import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.ihome.crm.model.DispatchLogModel;
import com.golden.ihome.crm.model.HouseFollowModel;
import com.golden.ihome.crm.model.HouseLeaseModel;
import com.golden.ihome.crm.model.HouseSaleModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author weizhichao 类名称：客源管理Dao 类描述：客源管理 时间：2016-11-02
 */
@Repository(value = "customerSourceDao")
public class CustomerSourceDao extends IBaseDao{
	
	/**
	 * 分页查询客源
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceModel> getCustomerSourcePage(Map<String, Object> map) {
		PagerResult<CustomerSourceModel> model = this.excutor.queryListPage("customerSource.getCustomerSourcePage", map);
		return model;
	}
	
	/**
	 * 分页查询客源
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<HouseFollowModel> getFollowRecordsPage(Map<String, Object> map) {
		PagerResult<HouseFollowModel> model = this.excutor.queryListPage("customerSource.getFollowRecordsPage", map);
		return model;
	}

	/**
	 * 新增客源
	 * @param map
	 * @return {}
	 */
	public Integer addCustomerSource(Map<String, Object> map) {
		return this.excutor.insert("customerSource.addCustomerSource", map);
	}

	/**
	 * 根据客源Id查询详细信息
	 * @param map
	 * @return CustomerManageModel
	 */
	public CustomerSourceModel getCustomerSourceById(Map<String, Object> map) {
		CustomerSourceModel model = this.excutor.queryForObject
		("customerSource.getCustomerSourceById", map);
		return model;
	}
	
	/**
	 * 分页查询约租赁房源
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<HouseLeaseModel> getHouseLeasePage(Map<String, Object> map) {
		PagerResult<HouseLeaseModel> model = this.excutor.queryListPage("customerSource.getHouseLeasePage", map);
		return model;
	}
	
	/**
	 * 分页查询约带看买卖房源
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<HouseSaleModel> getHouseSalePage(Map<String, Object> map) {
		PagerResult<HouseSaleModel> model = this.excutor.queryListPage("customerSource.getHouseSalePage", map);
		return model;
	}
	
	/**
	 * 分页查询约带看一手楼盘
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<BasePremisesModel> getPremisesPage(Map<String, Object> map) {
		PagerResult<BasePremisesModel> model = this.excutor.queryListPage("customerSource.getPremisesPage", map);
		return model;
	}
	
	/**
	 * 保存添加房源
	 * @param map
	 * @return {}
	 */
	public Integer saveCustTakeLook(Map<String, Object> map) {
		return this.excutor.insert("customerSource.saveCustTakeLook", map);
	}
	
	/**
	 * 保存添加楼盘
	 * @param map
	 * @return {}
	 */
	public Integer savePremisesTakeLook(Map<String, Object> map) {
		return this.excutor.insert("customerSource.savePremisesTakeLook", map);
	}
	
	/**
	 * 根据约带看id删除一条约带看记录
	 * @param map
	 * @return {}
	 */
	public Integer deleteCustPromisebyId(Map<String, Object> map) {
		return this.excutor.delete("customerSource.deleteCustPromisebyId", map);
	}
	
	
	/**
	 * 模糊查询获取商圈列表
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiNameList(Map<String, Object> map){
		return this.excutor.queryForList("customerSource.getBusiNameList",map);
	}
	
	/**
	 * 模糊匹配楼盘
	 * @param  matchStr : 名称
	 * @return List<BasePremisesModel>
	 */
	public List<BasePremisesModel> getPremisesListByMatch(Map<String, Object> map){
		return this.excutor.queryForList("customerSource.getPremisesByMatch", map);
	}
	
	/**
	 * 保存添加楼盘
	 * @param map
	 * @return {}
	 */
	public Integer toDealCustomerPool(Map<String, Object> map) {
		return this.excutor.update("customerSource.toDealCustomerPool", map);
	}
	
	/**
	 * 获取区划列表
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiZoningAll(Map<String, Object> map){
		return this.excutor.queryForList("busiArea.getbusiZoningAll");
	}
	
	/**
	 * 模糊匹配楼盘
	 * @param map
	 * @return List<BasePremisesModel>
	 */
	public List<BasePremisesModel> getPremisesName(Map<String, Object> map) {
		return this.excutor.queryForList("customerSource.getPremisesName", map);
	}
	
	/**
	 * 分页查询约带看管理
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerPromiseModel> getLookManagePage(Map<String, Object> map) {
		PagerResult<CustomerPromiseModel> model = this.excutor.queryListPage("customerSource.getLookManagePage", map);
		return model;
	}

	/**
	 * 修改客源
	 * @param map
	 * @return {}
	 */
	public Integer updateCustomerSource(Map<String, Object> map) {
		return this.excutor.insert("customerSource.updateCustomerSource", map);
	}
	
	/**
	 * 取消约带看
	 * @param map
	 */
	public Integer cancelLookManage(Map<String, Object> map) {
		return this.excutor.update("customerSource.cancelLookManage", map);
	}
	
	/**
	 * 根据id查询楼盘
	 * @param map
	 */
	public BasePremisesModel getPremisesByid(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getPremisesByid", map);
	}
	
	/**
	 * 根据id查询租赁楼盘
	 * @param map
	 */
	public HouseLeaseModel getHouseLeaseById(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getHouseLeaseById", map);
	}
	
	/**
	 * 根据id查询买卖楼盘
	 * @param map
	 */
	public HouseSaleModel getHouseSaleById(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getHouseSaleById", map);
	}
	

	/**
	 * 设置为保护客源
	 * @param map
	 */
	public Integer setProtectedCust(Map<String, Object> map) {
		return this.excutor.update("customerSource.setProtectedCust", map);
	}
	
	/**
	 * 取消保护该客源
	 * @param map
	 */
	public Integer cancelProtectedCust(Map<String, Object> map) {
		return this.excutor.update("customerSource.cancelProtectedCust", map);
	}
	
	/**
	 * 根据id查询该客源是否有处于新建的约带看
	 * @param map
	 */
	public Map<String, Object> getTakeLookCount(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getTakeLookCount", map);
	}
	
	/**
	 * 根据id查询该客源是否需要回访
	 * @param map
	 */
	public Map<String, Object> getTakeLookDoneCount(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getTakeLookDoneCount", map);
	}
	

	/**
	 * 分页查询租赁推荐房源
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerRecommendModel> getCustomerLeaseRecommendPage(Map<String, Object> map) {
		PagerResult<CustomerRecommendModel> model = this.excutor.queryListPage("customerSource.getCustomerLeaseRecommendPage", map);
		return model;
	}
	
	/**
	 * 根据客源id查询聚合的约带看信息
	 * @param map
	 */
	public CustomerPromiseModel getPromiseModelById(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getPromiseModelById", map);
	}

	/**
	 * 分页查询出售推荐房源
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerRecommendModel> getCustomerSaleRecommendPage(Map<String, Object> map) {
		PagerResult<CustomerRecommendModel> model = this.excutor.queryListPage("customerSource.getCustomerSaleRecommendPage", map);
		return model;
	}
	
	/**
	 * 保存推荐房源
	 * @param map
	 */
	public Integer recommend(Map<String, Object> map) {
		return this.excutor.update("customerSource.recommend", map);
	}
	
	/**
	 * 删除推荐房源
	 * @param map
	 */
	public Integer deleteRecommend(Map<String, Object> map) {
		return this.excutor.update("customerSource.deleteRecommend", map);
	}
	
	/**
	 * 分页查询约带看记录tab
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerPromiseModel> getTakeLookTabPage(Map<String, Object> map) {
		PagerResult<CustomerPromiseModel> model = this.excutor.queryListPage("customerSource.getTakeLookTabPage", map);
		return model;
	}
	
	/**
	 * 保存客源回访信息
	 * @param map
	 */
	public Integer saveCustCallBack(Map<String, Object> map) {
		return this.excutor.insert("customerSource.saveCustCallBack", map);
	}
	
	/**
	 * 回访后修改客源状态
	 * @param map
	 */
	public Integer setCustCallBackStatus(Map<String, Object> map) {
		return this.excutor.update("customerSource.setCustCallBackStatus", map);
	}
	/**
	 * 回访后修改约带看状态
	 * @param map
	 */
	public Integer setPromiseCallBackStatus(Map<String, Object> map) {
		return this.excutor.update("customerSource.setPromiseCallBackStatus", map);
	}
	
	/**
	 * 根据demandId查询promiseId
	 * @param map
	 */
	public List<Integer> getPromiseIdByDemandId(Map<String, Object> map) {
		return this.excutor.queryForList("customerSource.getPromiseIdByDemandId", map);
	}

	/**
	 * 分页查询客源
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerCallBackModel> getCustCallBackPage(Map<String, Object> map) {
		PagerResult<CustomerCallBackModel> model = this.excutor.queryListPage("customerSource.getCustCallBackPage", map);
		return model;
	}
	
	/**
	 * 分页查询客源回访约带看详情
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerCallBackModel> getCallBackPromisePage(Map<String, Object> map) {
		PagerResult<CustomerCallBackModel> model = this.excutor.queryListPage("customerSource.getCallBackPromisePage", map);
		return model;
	}
	
	/**
	 * 判断该客源是否是经纪人的私客
	 * @param map
	 */
	public Integer isPrivateCustomer(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.isPrivateCustomer", map);
	}
	
	/**
	 * 将该客源保存为经纪人的私客
	 * @param map
	 */
	public Integer savePrivateCustomer(Map<String, Object> map) {
		return this.excutor.insert("customerSource.savePrivateCustomer", map);
	}
	
	
	/**
	 * 分页查询跟进记录tab
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceFollowModel> getFollowTabPage(Map<String, Object> map) {
		PagerResult<CustomerSourceFollowModel> model = this.excutor.queryListPage("customerSource.getFollowTabPage", map);
		return model;
	}	
	
	/**
	 * 保存跟进信息
	 * @param map
	 */
	public Integer follow(Map<String, Object> map) {
		return this.excutor.update("customerSource.follow", map);
	}
	
	/**
	 * 分页查询客源分配记录tab
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<DispatchLogModel> getDispatchPage(Map<String, Object> map) {
		PagerResult<DispatchLogModel> model = this.excutor.queryListPage("customerSource.getDispatchTabPage", map);
		return model;
	}	
	
	/**
	 * 将客源转入公客池
	 * @param map
	 */
	public Integer saveCustToPubPool(Map<String, Object> map) {
		return this.excutor.update("customerSource.saveCustToPubPool", map);
	}
	
	/**
	 * 将客源转入公客池
	 * @param map
	 */
	public Integer saveDispatchCustSource(Map<String, Object> map) {
		return this.excutor.update("customerSource.saveDispatchCustSource", map);
	}
	
	/**
	 * 保存转介客源
	 * @param map
	 */
	public Integer transferCustomerToOther(Map<String, Object> map) {
		return this.excutor.insert("customerSource.transferCustomerToOther", map);
	}
	
	/**
	 * 分页查询客源转介
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceModel> getCustTransferPage(Map<String, Object> map) {
		PagerResult<CustomerSourceModel> model = this.excutor.queryListPage("customerSource.getCustTransferPage", map);
		return model;
	}
	
	/**
	 * 确认接收转介客源
	 * @param map
	 */
	public Integer confirmReceiveTransfer(Map<String, Object> map) {
		return this.excutor.update("customerSource.confirmReceiveTransfer", map);
	}
	
	/**
	 * 确认接收转介客源后修改归属部门和归属人
	 * @param map
	 */
	public Integer updateUserAfterTransfer(Map<String, Object> map) {
		return this.excutor.update("customerSource.updateUserAfterTransfer", map);
	}
	
	/**
	 * 拒绝接收转介客源
	 * @param map
	 */
	public Integer refuseReceiveTransfer(Map<String, Object> map) {
		return this.excutor.update("customerSource.refuseReceiveTransfer", map);
	}
	
	/**
	 * 拒绝接收转介客源
	 * @param map
	 */
	public Integer getProtectedByDemandId(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getProtectedByDemandId", map);
	}
	
	/**
	 * 根据客源id查询该客源的cdType状态
	 * @param map
	 */
	public Integer getDealedByDemandId(Map<String, Object> map) {
		return this.excutor.queryForObject("customerSource.getDealedByDemandId", map);
	}
	
}
