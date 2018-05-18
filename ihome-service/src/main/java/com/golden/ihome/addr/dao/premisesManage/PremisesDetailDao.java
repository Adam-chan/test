package com.golden.ihome.addr.dao.premisesManage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.FileDownloadModel;
import com.golden.ihome.addr.model.PremisesDetailModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * 楼盘详情
 * 
 * @author weizhichao
 */
@Repository(value = "premisesDetailDao")
public class PremisesDetailDao extends IBaseDao {

	/**
	 * 获得销售指南 
	 * 参数：map
	 */
	public PremisesDetailModel getSalesGuide(Map<String, Object> param) {
		PremisesDetailModel model = this.excutor.queryForObject(
				"premisesDetail.getSalesGuide", param);
		return model;
	}

	/**
	 * 保存修改销售指南 
	 * 参数：map
	 */
	public int savePremisesGuide(Map<String, Object> param) {
		int model = this.excutor.update("premisesDetail.savePremisesGuide",
				param);
		return model;
	}
	
	/**
	 * 新建销售指南 
	 * 参数：map
	 */
	public int insertPremisesGuide(Map<String, Object> param) {
		int model = this.excutor.insert("premisesDetail.insertPremisesGuide",
				param);
		return model;
	}

	/**
	 * 分页查询下载资料 
	 * 参数：map
	 */
	public PagerResult<FileDownloadModel> getFileList(Map<String, Object> map) {
		PagerResult<FileDownloadModel> model = this.excutor.queryListPage(
				"premisesDetail.getFileListPage", map);
		return model;
	}

	/**
	 * 保存上传的文件 
	 * 参数：map
	 */
	public int saveUploadFile(Map<String, Object> param) {
		int model = this.excutor.insert("premisesDetail.saveUploadFile", param);
		return model;
	}
	
	/**
	 * 删除下载资料
	 * 参数：map
	 */
	public int deleteFiles(Map<String, Object> param) {
		int model = this.excutor.delete("premisesDetail.deleteFiles", param);
		return model;
	}
	
	/**
	 * 批量下载资料
	 * 参数：map
	 */
	public List<FileDownloadModel> getDownloadFiles(Map<String, Object> param) {
		List<FileDownloadModel> model = this.excutor.queryForList("premisesDetail.getDownloadFiles", param);
		return model;
	}

}
