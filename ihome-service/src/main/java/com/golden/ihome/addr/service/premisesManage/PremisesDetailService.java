package com.golden.ihome.addr.service.premisesManage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.golden.ihome.addr.dao.premisesManage.PremisesDetailDao;
import com.golden.ihome.addr.model.FileDownloadModel;
import com.golden.ihome.addr.model.PremisesDetailModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

@Service("premisesDetail/premisesDetailService")
public class PremisesDetailService implements IBaseHandler {

	@Autowired
	private PremisesDetailDao premisesDetailDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return premisesDetailDao.getSalesGuide(param);
	}

	/**
	 * 得到销售指南List
	 * 
	 * @return
	 */
	public PremisesDetailModel getSalesGuide(Map<String, Object> param) {
		PremisesDetailModel model = premisesDetailDao.getSalesGuide(param);
		return model;
	}

	/**
	 * 保存修改销售指南
	 * 
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	@TM
	public int savePremisesGuide(Map<String, Object> param) {
		int model = premisesDetailDao.savePremisesGuide(param);
		return model;
	}
	
	/**
	 * 新建销售指南
	 * 
	 * @return
	 */
	@TM
	public int insertPremisesGuide(Map<String, Object> param) {
		int model = premisesDetailDao.insertPremisesGuide(param);
		return model;
	}

	/**
	 * 分页查询下载资料
	 * 
	 * @param params
	 * @return
	 */
	public PagerResult<FileDownloadModel> getFileList(Map<String, Object> map) {

		PagerResult<FileDownloadModel> result = premisesDetailDao
				.getFileList(map);
		return result;
	}

	/**
	 * 保存上传的文件
	 * 
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	@TM
	public int saveUploadFile(Map<String, Object> param) {
		String dataStr = (String) param.get("dataStr");
		JSONArray parseArray = JSON.parseArray(dataStr);
		param.put("dataStr", parseArray);
		int model = premisesDetailDao.saveUploadFile(param);
		return model;
	}

	/**
	 * 删除上传的文件
	 * 
	 * @return
	 */
	@TM
	public int deleteFiles(Map<String, Object> param) {
		String[] rowIds = (String[]) param.get("rowIds");
		String rowIdsStr = "";
		for (String id : rowIds) {
			rowIdsStr = rowIdsStr + id + ",";
		}
		rowIdsStr = rowIdsStr.substring(0, rowIdsStr.length() - 1);
		param.put("rowIdsStr", rowIdsStr);
		int model = premisesDetailDao.deleteFiles(param);
		return model;
	}
	
	/**
	 * 批量下载资料
	 * 参数：map
	 */
	public List<FileDownloadModel> getDownloadFiles(Map<String, Object> param) {
		
		String[] rowIds = (String[]) param.get("rowIds");
		String rowIdsStr = "";
		for (String id : rowIds) {
			rowIdsStr = rowIdsStr + id + ",";
		}
		rowIdsStr = rowIdsStr.substring(0, rowIdsStr.length() - 1);
		param.put("rowIdsStr", rowIdsStr);
		
		List<FileDownloadModel> model = premisesDetailDao.getDownloadFiles(param);
		return model;
	}

}
