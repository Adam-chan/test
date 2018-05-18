package com.golden.ihome.addr.dao.premisesManage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.PremisesPicturesModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
* @author weizhichao
 * 类名称：楼盘管理--楼盘详情--楼盘图片Dao
 * 类描述：楼盘图片
 * 时间：2016-10-24
 */
@Repository(value="premisesPicturesDao")
public class PremisesPicturesDao extends IBaseDao{
	
	/**
	 * 分页查询楼盘图片
	 * @param map
	 * @return PagerResult
	 */
	public PagerResult<PremisesPicturesModel> getPremisesPicturesPage(Map<String, Object> map) {
		return this.excutor.queryListPage("premisesPictures.getPremisesPicturesPage", map);
	}
	
	/**
	 * 保存上传的文件 
	 * 参数：map
	 */
	public int saveUploadPicture(Map<String, Object> param) {
		int model = this.excutor.insert("premisesPictures.saveUploadPicture", param);
		return model;
	}
	
	/**
	 * 删除图片
	 * 参数：map
	 */
	public int deletePicture(Map<String, Object> param) {
		int model = this.excutor.delete("premisesPictures.deletePicture", param);
		return model;
	}
	
	/**
	 * 分组查询楼盘图片
	 * 
	 * @param map
	 * @return List
	 */
	public List<PremisesPicturesModel> getGroupsByPicType(Map<String, Object> map) {
		return this.excutor.queryForList("premisesPictures.getGroupsByPicType", map);
	}
	
	/**
	 * 设置代表图片
	 * 参数：map
	 */
	public int setRepresentPic(Map<String, Object> param) {
		
		this.excutor.update("premisesPictures.resetRepresent", param);
		int model = this.excutor.update("premisesPictures.setRepresentPic", param);
		return model;
	}

}
