package com.golden.ihome.addr.service.operate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.basearea.BaseAreaDao;
import com.golden.ihome.addr.dao.operate.OperateDao;
import com.golden.ihome.addr.model.BaseAreaModel;
import com.golden.ihome.addr.model.CommunityModel;
import com.golden.ihome.addr.model.OperateModel;
import com.golden.ihome.addr.model.SubdistrictModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

@Service("operate/operateService")
public class OperateService implements IBaseHandler{

	@Autowired
	private OperateDao operateDao;
	
	@Autowired
	private BaseAreaDao baseAreaDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 查询行政区划 
	 * @param map
	 * @return
	 */
	public List<BaseAreaModel> getAreaList(Map<String,Object> map){
		return baseAreaDao.getAreaList(map);
	}
	/**
	 * 查询所有街道 
	 * @param map
	 * @return
	 */
	public List<SubdistrictModel> getSubdistrictList(Map<String,Object> map){
		return baseAreaDao.getSubdistrictIdByAreaId(map);
	}
	/**
	 * 查询社区 
	 * @param map
	 * @return
	 */
	public List<CommunityModel> getCommunityList(Map<String,Object> map){
		return baseAreaDao.getCommunityList(map);
	}
	/**
	 * 楼盘列表  
	 * @param map
	 * @return
	 */
	public PagerResult<OperateModel> getPremisesAddrForPage(Map<String,Object> map){
		return operateDao.getPremisesAddrForPage(map);
	}
	
	
	
	
	
	//************************************************************************************************
	
	/**
	 * 分页查询楼盘的经营范围分配(买卖) 列表 sy
	 * @param map
	 * @return
	 */
	public PagerResult<OperateModel> getOperateSaleListForPage(Map<String,Object> map){
		return operateDao.getOperateSaleListForPage(map);
	}
	
	
	
}
