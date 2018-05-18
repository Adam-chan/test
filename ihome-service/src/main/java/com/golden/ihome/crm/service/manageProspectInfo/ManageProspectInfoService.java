package com.golden.ihome.crm.service.manageProspectInfo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.ihome.crm.dao.house.CommonSearchDao;
import com.golden.ihome.crm.dao.manageProspectInfo.ManageProspectInfoDao;
import com.golden.ihome.crm.model.ManageProspectInfoModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.stores.results.ResultValue;
@Service("manageProspectInfo/manageProspectInfoService")
public class ManageProspectInfoService implements IBaseHandler{
	
	@Autowired
	private ManageProspectInfoDao manageProspectInfoDao;
	@Autowired
	private CommonSearchDao commonSearchDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return null;
	}
	/**
	 * 实勘审核分页查询
	 * @param map{}
	 * @return  PagerResult<ManageProspectInfoModel>
	 * @throws Exception 
	 */
	public PagerResult<ManageProspectInfoModel> getManageProspectInfoPage(Map<String, Object> param) throws Exception{
		
		if(param.get("createTimeStart")!=null){
			param.put("createTimeStart",DateUtil.getDate(param.get("createTimeStart").toString(), "yyyy-MM-dd"));
		}else if(param.get("createTimeEnd")!=null){
			param.put("createTimeEnd",DateUtil.getDate(param.get("createTimeEnd").toString(), "yyyy-MM-dd"));
		}else if(param.get("examineTimeStart")!=null){
			param.put("examineTimeStart",DateUtil.getDate(param.get("examineTimeStart").toString(), "yyyy-MM-dd"));
		}else if(param.get("examineTimeEnd")!=null){
			param.put("examineTimeEnd",DateUtil.getDate(param.get("examineTimeEnd").toString(), "yyyy-MM-dd"));
		}else if(param.get("allotTimeStart")!=null){
			param.put("allotTimeStart",DateUtil.getDate(param.get("allotTimeStart").toString(), "yyyy-MM-dd"));
		}else if(param.get("allotTimeEnd")!=null){
			param.put("allotTimeEnd",DateUtil.getDate(param.get("allotTimeEnd").toString(), "yyyy-MM-dd"));
		}
		return manageProspectInfoDao.getManageProspectInfoPage(param);
	}
	/**
	 * 模糊查询
	 * @param map
	 * @return
	 */
	public  List<ManageProspectInfoModel> getVagueSelect(Map<String, Object> map) {
		return manageProspectInfoDao.getVagueSelect(map);
	}
	/**
	 * 获取一条审核数据
	 */
	public ManageProspectInfoModel getManageProspectInfo(Map<String, Object> map) {
		return manageProspectInfoDao.getManageProspectInfo(map);
	}
	
	/**
	 * 跟新
	 * @throws Exception 
	 */
	public Integer updateManageProspectInfo(Map<String, Object> map) throws Exception{
		map.put("id", map.get("prospectCheckId"));
		map.put("createTime", DateUtil.getDate(map.get("createTime").toString(), "yyyy-DD-mm"));
		return manageProspectInfoDao.updateManageProspectInfo(map);
	} 
	/**
	 * 删除图片
	 * @param map{id：manage_Prospect_Image表的主键}
	 * @return Integer 0失败 大于1成功
	 */
	public Integer delImage(@RequestParam Map<String, Object> map) {
		return commonSearchDao.deleteManageProspectImage(map);
	}
	/**
	 * 修改审核状态
	 */
	public Integer updateStatus(@RequestParam Map<String, Object> map) {
		return manageProspectInfoDao.updateManageProspectInfo(map);
	}
}
