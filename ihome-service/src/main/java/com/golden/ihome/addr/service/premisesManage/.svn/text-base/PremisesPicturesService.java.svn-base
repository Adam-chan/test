package com.golden.ihome.addr.service.premisesManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.golden.ihome.addr.dao.premisesManage.PremisesPicturesDao;
import com.golden.ihome.addr.model.PremisesPicturesModel;
import com.golden.ihome.common.SysParam;
import com.golden.ihome.crm.dao.sysParame.SysParamDao;
import com.golden.ihome.crm.model.SysParameterModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

/**
 * @author weizhichao 类名称：楼盘管理--楼盘详情--楼盘图片Service 类描述：楼盘图片 时间：2016-10-24
 */
@Service("premisesPictures/premisesPicturesService")
public class PremisesPicturesService implements IBaseHandler {
	@Autowired
	private SysParamDao sysParamDao;
	@Autowired
	private PremisesPicturesDao premisesPicturesDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		if(param == null){
			param = new HashMap<String,Object>();
		}
		param.put("sysHouseType", SysParam.LPTPFL);
		List<SysParameterModel> sysHouseLPTPFLList = sysParamDao.getSysHouseList(param);
		return sysHouseLPTPFLList;
	}

	/**
	 * 分页查询楼盘图片
	 * 
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<PremisesPicturesModel> getPremisesPicturesPage(
			Map<String, Object> map) {
		return premisesPicturesDao.getPremisesPicturesPage(map);
	}

	/**
	 * 保存上传的文件
	 * 
	 * @return
	 */
	@TM
	public int saveUploadPicture(Map<String, Object> param) {

		String dataStr = (String) param.get("dataStr");
		JSONArray parseArray = JSON.parseArray(dataStr);
		param.put("dataStr", parseArray);

		int model = premisesPicturesDao.saveUploadPicture(param);
		return model;
	}

	/**
	 * 删除楼盘图片
	 * 
	 * @return
	 */
	@TM
	public int deletePicture(Map<String, Object> param) {

		@SuppressWarnings("unchecked")
		ArrayList<String> idList = (ArrayList<String>) param.get("idList");
		String rowIdsStr = "";
		for (String id : idList) {
			rowIdsStr = rowIdsStr + id + ",";
		}

		rowIdsStr = rowIdsStr.substring(0, rowIdsStr.length() - 1);
		param.put("rowIdsStr", rowIdsStr);

		int model = premisesPicturesDao.deletePicture(param);
		return model;
	}

	/**
	 * 分组查询楼盘图片
	 * 
	 * @param map
	 * @return List
	 */
	public List<PremisesPicturesModel> getGroupsByPicType(Map<String, Object> map) {
		return premisesPicturesDao.getGroupsByPicType(map);
	}
	
	/**
	 * 设置代表图片
	 * 
	 * @return
	 */
	@TM
	public int setRepresentPic(Map<String, Object> param) {

		int model = premisesPicturesDao.setRepresentPic(param);
		return model;
	}

}
