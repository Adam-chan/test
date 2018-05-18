package com.golden.ihome.crm.service.house;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.common.CodeConst;
import com.golden.ihome.common.service.CommonCode;
import com.golden.ihome.crm.dao.house.BuildingPapersDao;
import com.golden.ihome.crm.dao.house.HouseLeaseDao;
import com.golden.ihome.crm.dao.house.HouseSaleDao;
import com.golden.ihome.crm.dao.house.ManageTimeLimitExpressDao;
import com.golden.ihome.crm.model.BuildingPapersModel;
import com.golden.ihome.crm.model.HouseLeaseModel;
import com.golden.ihome.crm.model.HouseSaleModel;
import com.golden.ihome.crm.model.ManageTimeLimitExpressModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/**
 * @author lza
 * 类名称：限时速递管理service
 * 类描述：限时速递表的数据访问
 * 日          期：2016-11-18
 */
@Service("house/manageTimeLimitExpressService")
public class ManageTimeLimitExpressService implements IBaseHandler{
	
	@Autowired
	private ManageTimeLimitExpressDao manageTimeLimitExpressDao;
	@Autowired
	private BuildingPapersDao buildingPapersDao;
	@Autowired
	private HouseLeaseDao houseLeaseDao;
	@Autowired
	private HouseSaleDao houseSaleDao;
	@Resource(name="commonCode")
	private CommonCode commonCode;
	
	/**
	 * 获取限时速递分页列表
	 * map{houseInfoId：房源表id，type：1买卖，2租赁}
	 * return PagerResult<ManageTimeLimitExpressModel>
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return manageTimeLimitExpressDao.getManageTimeLimitExpressPage(param);
	}
	/**
	 * 获取限时速递分页列表
	 * map{houseInfoId：房源表id，type：1买卖，2租赁}
	 * return PagerResult<ManageTimeLimitExpressModel>
	 */
	public PagerResult<ManageTimeLimitExpressModel> getManageTimeLimitExpressPage(Map<String, Object> param) throws Exception {
		return manageTimeLimitExpressDao.getManageTimeLimitExpressPage(param);
	}
	/**
	 * 根据限时速递id获取证件列表
	 * @param map{timeLimitId：限时速递表的id}
	 * @return list<getBuildingPapers>
	 */
	public  List<BuildingPapersModel> getBuildingPapers(Map<String, Object> param){
		return buildingPapersDao.getBuildingPapers(param);
	}
	
	/**
	 * 根据id获取限时速递表的一条数据
	 * map{id：限时速递表id}
	 * ManageTimeLimitExpressModel
	 */
	public ManageTimeLimitExpressModel getManageTimeLimitExpress(Map<String, Object> param){
		return manageTimeLimitExpressDao.getManageTimeLimitExpress(param);
	}
	/**
	 * 获取限时速递编码
	 * @throws Exception 
	 */
	@TM
	public String getCode() throws Exception{
		return commonCode.getCode(CodeConst.MANAGE_TIME_LIMIT_EXPRESS_CODE);
	}
	
	
	/**
	 * 获取出租限时速递所需参数
	 * 参数：map {所属ID}
	 */
	public HouseSaleModel getManageTimeLimitExpressSale(Map<String, Object> map){
		return houseSaleDao.getManageTimeLimitExpress(map);
	}
	
	/**
	 * 获取买卖限时速递所需参数
	 * 参数：map {所属ID}
	 */
	public HouseLeaseModel getManageTimeLimitExpressLease(Map<String, Object> map){
		return houseLeaseDao.getManageTimeLimitExpress(map) ;
	}
	/**
	 * 保存限时速递数据
	 * @throws Exception 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer insertManageTimeLimitExpressLease(Map<String, Object> map) throws Exception{
		
		Integer type = 0;
		Integer [] credentialsType = (Integer[]) map.get("credentialsType");
		String [] credentialsNum = (String[]) map.get("credentialsNum");
		map.remove("credentialsType");
		map.remove("credentialsNum");
		map.put("status", Integer.parseInt(map.get("status").toString()));
		BuildingPapersModel buildingPapers;
		List<BuildingPapersModel> list = new ArrayList<BuildingPapersModel>(); 
		map.put("entrustStartime", DateUtil.getDate(map.get("entrustStartime").toString(),"yyyy-MM-dd"));
		map.put("entrustEndtime", DateUtil.getDate(map.get("entrustEndtime").toString(),"yyyy-MM-dd"));
		map.put("contractDate", DateUtil.getDate(map.get("contractDate").toString(),"yyyy-MM-dd"));
		Object originalContract = map.get("originalContract");
		if(originalContract!=null && originalContract!=null){
			map.put("status",2);
		}
		type = manageTimeLimitExpressDao.insertManageTimeLimitExpress(map);
		Object id = map.get("id");
		map.clear();
		for (int i = 0; i < credentialsNum.length; i++) {
			buildingPapers = new BuildingPapersModel();
			buildingPapers.setCredentialsType(credentialsType[i]);
			buildingPapers.setCredentialsNum(credentialsNum[i]);
			list.add(buildingPapers);
		}
		map.put("timeLimitId", id);
		map.put("list", list);
		if(type>0){
			type = buildingPapersDao.insertBatch(map);
		}
		return type;
	}
	/**
	 * 限时速递保存校验
	 * @throws Exception 
	 */
	public Integer getBycount(Map<String, Object> map) {
		return manageTimeLimitExpressDao.getBycount(map);
	}
	/**
	 * 限时速递结束和终止操作
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer updataStuts(Map<String, Object> map) {
		return manageTimeLimitExpressDao.updataStuts(map);
	}
}
