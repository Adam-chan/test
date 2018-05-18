package com.golden.ihome.crm.service.customerSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.common.CodeConst;
import com.golden.ihome.common.SysParam;
import com.golden.ihome.common.service.CommonCode;
import com.golden.ihome.crm.dao.customerSource.CustomerSourceDao;
import com.golden.ihome.crm.dao.sysParame.SysParamDao;
import com.golden.ihome.crm.model.CustomerCallBackModel;
import com.golden.ihome.crm.model.CustomerPromiseModel;
import com.golden.ihome.crm.model.CustomerRecommendModel;
import com.golden.ihome.crm.model.CustomerSourceFollowModel;
import com.golden.ihome.crm.model.CustomerSourceModel;
import com.golden.ihome.crm.model.DispatchLogModel;
import com.golden.ihome.crm.model.HouseFollowModel;
import com.golden.ihome.crm.model.HouseLeaseModel;
import com.golden.ihome.crm.model.HouseSaleModel;
import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

/**
 * @author weizhichao 类名称：客源管理Service 类描述：客源管理 时间：2016-11-02
 */
@Service("customerSource/customerSourceService")
public class CustomerSourceService implements IBaseHandler {

	@Autowired
	private CustomerSourceDao customerSourceDao;
	@Autowired
	private SysParamDao sysParamDao;

	@Resource(name = "commonCode")
	private CommonCode commonCode;

	@Override
	public Object execute(Map<String, Object> map) throws Exception {
		if (map == null) {
			map = new HashMap<String, Object>();
		}
		map.put("sysCoustomerType", SysParam.KHPJ);
		List<SysParameterModel> sysHouseKHPJList = sysParamDao
				.getSysCustomerList(map);
		return sysHouseKHPJList;
	}

	/**
	 * 分页查询客源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceModel> getCustomerSourcePage(
			Map<String, Object> map) {
		return customerSourceDao.getCustomerSourcePage(map);
	}

	/**
	 * 添加客源
	 * 
	 * @param param
	 *            {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer addCustomerSource(Map<String, Object> map) throws Exception {

		String demandCode = commonCode.getCode(CodeConst.DEMAND_CODE);
		map.put("demandCode", demandCode);
		return customerSourceDao.addCustomerSource(map);
	}

	/**
	 * 分页查询客源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<HouseFollowModel> getFollowRecordsPage(
			Map<String, Object> map) {
		return customerSourceDao.getFollowRecordsPage(map);
	}

	/**
	 * 根据客源Id查询详细信息
	 * 
	 * @return CustomerManageModel
	 */
	public CustomerSourceModel getCustomerSourceById(Map<String, Object> map) {
		CustomerSourceModel model = customerSourceDao
				.getCustomerSourceById(map);
		return model;
	}

	/**
	 * 分页查询约带看租赁房源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<HouseLeaseModel> getHouseLeasePage(
			Map<String, Object> map) {
		return customerSourceDao.getHouseLeasePage(map);
	}

	/**
	 * 分页查询约带看买卖房源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<HouseSaleModel> getHouseSalePage(Map<String, Object> map) {
		return customerSourceDao.getHouseSalePage(map);
	}

	/**
	 * 分页查询约带看一手楼盘
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<BasePremisesModel> getPremisesPage(
			Map<String, Object> map) {
		return customerSourceDao.getPremisesPage(map);
	}

	/**
	 * 保存添加房源
	 * 
	 * @param param
	 *            {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer saveCustTakeLook(Map<String, Object> map) throws Exception {
		String temps = map.get("houseIds").toString();
		String[] houseIds = temps.split(",");
		for (String houseId : houseIds) {
			if (houseId != null && !"".equals(houseId)) {
				map.put("houseId", houseId);
				customerSourceDao.saveCustTakeLook(map);
			}
		}

		return houseIds.length;
	}

	/**
	 * 保存添加楼盘
	 * 
	 * @param param
	 *            {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer savePremisesTakeLook(Map<String, Object> map)
			throws Exception {
		String temps = map.get("premisesIds").toString();
		String[] premisesIds = temps.split(",");
		for (String premisesId : premisesIds) {
			if (premisesId != null && !"".equals(premisesId)) {
				map.put("premisesId", premisesId);
				customerSourceDao.savePremisesTakeLook(map);
			}
		}

		return premisesIds.length;
	}

	/**
	 * 根据约带看id删除一条约带看记录
	 * 
	 * @param param
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	public Integer deleteCustPromisebyId(Map<String, Object> map)
			throws Exception {

		return customerSourceDao.deleteCustPromisebyId(map);
	}

	/**
	 * 模糊匹配商圈
	 * 
	 * @param map
	 * @return List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiNameList(Map<String, Object> map) {
		return customerSourceDao.getBusiNameList(map);
	}

	/**
	 * 模糊匹配楼盘
	 * 
	 * @param matchStr
	 *            : 名称
	 * @return List<BasePremisesModel>
	 */
	public List<BasePremisesModel> getPremisesListByMatch(
			Map<String, Object> param) {
		return customerSourceDao.getPremisesListByMatch(param);
	}

	/**
	 * 保存添加房源
	 * 
	 * @param param
	 *            {}
	 * @return Integer()
	 * @throws Exception
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer toDealCustomerPool(Map<String, Object> map) throws Exception {
		return customerSourceDao.toDealCustomerPool(map);
	}

	/**
	 * 获取区划列表
	 * 
	 * @return List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiZoningAll(Map<String, Object> map) {
		return customerSourceDao.getBusiZoningAll(map);
	}

	/**
	 * 模糊匹配楼盘
	 * 
	 * @param map
	 * @return
	 */
	public List<BasePremisesModel> getPremisesName(Map<String, Object> param) {
		return customerSourceDao.getPremisesName(param);
	}

	/**
	 * 分页查询约带看管理
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerPromiseModel> getLookManagePage(
			Map<String, Object> map) {
		return customerSourceDao.getLookManagePage(map);
	}

	/**
	 * 修改客源
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer updateCustomerSource(Map<String, Object> map)
			throws Exception {
		return customerSourceDao.updateCustomerSource(map);
	}

	/**
	 * 取消约带看
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer cancelLookManage(Map<String, Object> map) throws Exception {
		return customerSourceDao.cancelLookManage(map);
	}

	/**
	 * 根据id查询楼盘
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public BasePremisesModel getPremisesByid(Map<String, Object> map) {
		return customerSourceDao.getPremisesByid(map);
	}

	/**
	 * 根据id查询租赁房源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public HouseLeaseModel getHouseLeaseById(Map<String, Object> map) {
		return customerSourceDao.getHouseLeaseById(map);
	}

	/**
	 * 根据id查询买卖房源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public HouseSaleModel getHouseSaleById(Map<String, Object> map) {
		return customerSourceDao.getHouseSaleById(map);
	}

	/**
	 * 设置为保护客源
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	@TM
	public Integer setProtectedCust(Map<String, Object> map) throws Exception {
		return customerSourceDao.setProtectedCust(map);
	}

	/**
	 * 取消保护该客源
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	@TM
	public Integer cancelProtectedCust(Map<String, Object> map)
			throws Exception {
		return customerSourceDao.cancelProtectedCust(map);
	}

	/**
	 * 分页查询租赁推荐房源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerRecommendModel> getCustomerLeaseRecommendPage(
			Map<String, Object> map) {
		return customerSourceDao.getCustomerLeaseRecommendPage(map);
	}

	/**
	 * 分页查询出售推荐房源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerRecommendModel> getCustomerSaleRecommendPage(
			Map<String, Object> map) {
		return customerSourceDao.getCustomerSaleRecommendPage(map);
	}

	/**
	 * 客源转介页面初始化
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	public Object transferCustomer(Map<String, Object> param) throws Exception {
		if (param == null) {
			param = new HashMap<String, Object>();
		}
		param.put("sysHouseType", SysParam.LPTPFL);
		List<SysParameterModel> sysHouseLPTPFLList = sysParamDao
				.getSysHouseList(param);
		return sysHouseLPTPFLList;
	}

	/**
	 * 根据id查询该客源是否有处于新建的约带看
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	public Map<String, Object> getTakeLookCount(Map<String, Object> map)
			throws Exception {
		return customerSourceDao.getTakeLookCount(map);
	}

	/**
	 * 根据id查询该客源是否需要回访
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	public Map<String, Object> getTakeLookDoneCount(Map<String, Object> map)
			throws Exception {
		return customerSourceDao.getTakeLookDoneCount(map);
	}

	/**
	 * 根据客源id查询聚合的约带看信息
	 * 
	 * @param map
	 * @return CustomerPromiseModel
	 */
	public CustomerPromiseModel getPromiseModelById(Map<String, Object> map) {
		return customerSourceDao.getPromiseModelById(map);
	}

	/**
	 * 保存推荐房源
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	@TM
	public Integer recommend(Map<String, Object> map) throws Exception {
		String[] houseInfoIds = ((String) map.get("houseInfoIds")).split(",");
		int res = 0;
		for (int i = 0; i < houseInfoIds.length; i++) {
			map.put("houseInfoId", houseInfoIds[i]);
			res = customerSourceDao.recommend(map);
			if (res == 0) {
				return res;
			}
		}
		return res;
	}

	/**
	 * 删除推荐房源
	 * 
	 * @param param
	 *            {}
	 * @return Integer
	 */
	@TM
	public Integer deleteRecommend(Map<String, Object> map) throws Exception {
		return customerSourceDao.deleteRecommend(map);
	}

	/**
	 * 分页查询约带看记录tab
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerPromiseModel> getTakeLookTabPage(
			Map<String, Object> map) {
		return customerSourceDao.getTakeLookTabPage(map);
	}

	/**
	 * 保存客源回访信息
	 * 
	 * @param param
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer saveCustCallBack(Map<String, Object> map) throws Exception {
		List<Integer> promiseIds = customerSourceDao
				.getPromiseIdByDemandId(map);

		if (promiseIds.size() != 0) {
			for (Integer promiseId : promiseIds) {
				map.put("promiseId", promiseId);
				customerSourceDao.saveCustCallBack(map);
			}
		} else {
			customerSourceDao.saveCustCallBack(map);
		}

		if (promiseIds.size() != 0) {
			customerSourceDao.setPromiseCallBackStatus(map);
		} else {
			customerSourceDao.setCustCallBackStatus(map);
		}

		return promiseIds.size();
	}

	/**
	 * 分页查询跟进记录tab
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceFollowModel> getFollowTabPage(
			Map<String, Object> map) {
		return customerSourceDao.getFollowTabPage(map);
	}

	/**
	 * 分页查询客源
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerCallBackModel> getCustCallBackPage(
			Map<String, Object> map) {
		return customerSourceDao.getCustCallBackPage(map);
	}

	/**
	 * 分页查询客源回访约带看详情
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerCallBackModel> getCallBackPromisePage(
			Map<String, Object> map) {
		String temp = map.get("takeDate").toString();
		if(temp != null && temp != ""){
			map.put("takeDate", DateUtil.getStrByLong(
					Long.parseLong(temp), "yyyy-MM-dd"));
		}
		return customerSourceDao.getCallBackPromisePage(map);
	}

	/**
	 * 保存跟进信息
	 * 
	 * @param param
	 * @return Integer
	 */
	@TM
	public Integer follow(Map<String, Object> map) throws Exception {
		return customerSourceDao.follow(map);
	}

	/**
	 * 分页查询客源分配记录tab
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<DispatchLogModel> getDispatchPage(Map<String, Object> map) {
		return customerSourceDao.getDispatchPage(map);
	}

	/**
	 * 将客源转入公客池
	 * 
	 * @param map
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer saveCustToPubPool(Map<String, Object> map) throws Exception {
		return customerSourceDao.saveCustToPubPool(map);
	}

	/**
	 * 保存调配客源
	 * 
	 * @param param
	 */
	@TM
	public Integer saveDispatchCustSource(Map<String, Object> map)
			throws Exception {
		return customerSourceDao.saveDispatchCustSource(map);
	}

	/**
	 * 保存转介客源
	 * 
	 * @param param
	 */
	@TM
	@Aop(name = "scriptAop", type = "before")
	public Integer transferCustomerToOther(Map<String, Object> map)
			throws Exception {
		return customerSourceDao.transferCustomerToOther(map);
	}

	/**
	 * 分页查询客源转介
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<CustomerSourceModel> getCustTransferPage(
			Map<String, Object> map) {
		return customerSourceDao.getCustTransferPage(map);
	}

	/**
	 * 确认接收转介客源
	 * 
	 * @param param
	 */
	@TM
	public Integer confirmReceiveTransfer(Map<String, Object> map)
			throws Exception {
		Integer model = customerSourceDao.confirmReceiveTransfer(map);
		customerSourceDao.updateUserAfterTransfer(map);
		return model;
	}
	
	/**
	 * 拒绝接收转介客源
	 * 
	 * @param param
	 */
	@TM
	public Integer refuseReceiveTransfer(Map<String, Object> map)
			throws Exception {
		Integer model = customerSourceDao.refuseReceiveTransfer(map);
		return model;
	}
	
	/**
	 * 根据客源id查询该客源的保护状态
	 * @param param
	 */
	@TM
	public Integer getProtectedByDemandId(Map<String, Object> map)
			throws Exception {
		Integer model = customerSourceDao.getProtectedByDemandId(map);
		return model;
	}
	
	/**
	 * 根据客源id查询该客源的cdType状态
	 * @param param
	 */
	@TM
	public Integer getDealedByDemandId(Map<String, Object> map)
			throws Exception {
		Integer model = customerSourceDao.getDealedByDemandId(map);
		return model;
	}
	

}
