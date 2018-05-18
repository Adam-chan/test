package com.golden.ihome.addr.service.addrBaseManage;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.addrBaseManage.AddrBaseManageDao;
import com.golden.ihome.addr.model.AddressBaseManageModel;
import com.golden.ihome.addr.model.TemporaryAddrBaseModel;
import com.golden.ihome.crm.dao.house.HouseLeaseDao;
import com.golden.ihome.crm.dao.house.HouseSaleDao;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/**
 * @author LB
 * 类描述：地址库管理
 */
@Service("addrBaseManage/AddrBaseManageService")
public class AddrBaseManageService implements IBaseHandler{

	public static Logger logger = LoggerFactory.getLogger(AddrBaseManageService.class);
	
	@Autowired
	private AddrBaseManageDao addrBaseManageDao;
	
	@Autowired
	private HouseLeaseDao houseLeaseDao;
	
	@Autowired
	private HouseSaleDao houseSaleDao;
	/**
	 * @param map { 
	 *      标准地址库分页查询
	 * 		rowCount:查询条数
	 * @return
	 */
	@Override
	public Object execute(Map<String, Object> map) throws Exception {
		return addrBaseManageDao.getStandAddrManagePage(map);
	}
	/**
	 * @param map { 
	 *      临时地址库分页查询
	 * 		rowCount:查询条数
	 * @return
	 */
	public PagerResult<TemporaryAddrBaseModel> getTemAddrBasePage(Map<String, Object> map) {
		return addrBaseManageDao.getTemAddrBasePage(map);
	}
	/**
	 * 模糊匹配道路 楼盘 楼盘分组 
	 * @param 
	 * @return List<AddressBaseManageModel>
	 */
	public List<AddressBaseManageModel> getAddrKeyWordMatch(Map<String, Object> param){
		return addrBaseManageDao.getAddrKeyWordMatch(param);
	}
	/**
	 * 模糊匹配道路 楼盘 楼盘分组 
	 * @param 
	 */
	public Integer updateHouseStatus(Map<String, Object> param){
		return addrBaseManageDao.updateHouseStatus(param);
	}
	/**
	 * 模糊匹配临时地址 
	 * @param 
	 * @return List<TemporaryAddrBaseModel>
	 */
	public List<TemporaryAddrBaseModel> getTemAddrkeyWordByMatch(Map<String, Object> param){
		List<TemporaryAddrBaseModel> temAddrkeyWordByMatch = addrBaseManageDao.getTemAddrkeyWordByMatch(param);
		 for(TemporaryAddrBaseModel item : temAddrkeyWordByMatch){
			 String bizTypeStr = item.getBizTypeStr();
			 String temporaryAddtr = item.getTemporaryAddtr();
			 item.setAdllTemporaryAddtr(temporaryAddtr+" ……… "+bizTypeStr);
		 }
		return temAddrkeyWordByMatch;
	}
	/**
	 * 临时地址库审核 修改临时地址为地址库地址
	 * @param params   checkTime 审核时间  checkMan 审核人
	 * 		  temAddrBaseId 临时地址库ID   bizType 业务类型 1买卖 2租赁	
	 * 	      houseInfoId  houseInfo表ID  refuseReson 拒绝审核原因  houseAddr  地址库地址		  
	 * @return
	 */
	@TM
	public Integer updateHouseAddr(Map<String, Object> param){
		int result = 2;
		String houseAddr= "";
		String checkType= "";
		checkType = param.get("checkType").toString();
		houseAddr = param.get("houseAddr").toString();
		String bizType = param.get("bizType").toString();
		if(checkType.equals("2")){//拒绝
			param.remove("houseAddr");
		}
		param.put("checkTime", DateUtil.getDateByLong(System.currentTimeMillis()));
		Integer updateHouseAddr = addrBaseManageDao.updateHouseAddr(param);
		if(updateHouseAddr!=0){
			result = 1;
		}
		if(!houseAddr.equals("")&&checkType.equals("1")){
			if(bizType.equals("1")){
			 	Integer updateHouseSale = houseSaleDao.updateHouseSale(param);
			 	if(updateHouseSale!=0){
					result = 1;
				}
			}else{
				Integer updateHouseLease = houseLeaseDao.updateHouseLease(param);
				if(updateHouseLease!=0){
					result = 1;
				}
			}
		}
		return 	result;
	}
}
