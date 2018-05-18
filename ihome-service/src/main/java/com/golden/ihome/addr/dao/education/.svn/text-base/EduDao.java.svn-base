package com.golden.ihome.addr.dao.education;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.AroundEduImgModel;
import com.golden.ihome.addr.model.EduFacilityModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

@Repository(value="eduDao")
public class EduDao extends IBaseDao{
	/**
	 * 教育设施信息
	 * 分页查询
	 * 参数：map {currentPage:当前页,rowCount：查询条数}
	 */
	public PagerResult<EduFacilityModel> getEduPage(Map<String, Object> map) {
		return this.excutor.queryListPage("edu.queryEduPage", map);
	}
	/**
	 * 模糊匹配 教育设施名字
	 * @param String eduId 教育设施ID   matchStr 模糊教育设施名字
	 * @return List<EduFacilityModel>
	 */
	public List<EduFacilityModel> geteduNameByMatch(Map<String, Object> map){
		return this.excutor.queryForList("edu.getEduNameByMatch", map);
	}
	/**
	 * 逻辑删除教育设施 更改教育设施
	 * @param map
	 * @return
	 */
	public Integer updateEduInfo(Map<String, Object> map) {
		return this.excutor.update("edu.updateEduStatus", map);
	}
	/**
	 * 教育设施名字和地址验证
	 * @param map 
	 * @return Integer
	 */
	public EduFacilityModel getEduInfo(Map<String, Object> map){
		return this.excutor.queryForObject("edu.getEduInfo", map);
	}
	/**
	 * 保存教育设施
	 * @param 
	 * @return Integer
	 */
	public Integer insertEdu(Map<String, Object> map) {
		return this.excutor.insert("edu.insertEdu", map);
	}
	
	/**
	 * 保存教育设施图片
	 * @param 
	 * @return Integer
	 */
	public Integer insertEduImg(Map<String, Object> map) {
		return this.excutor.insert("edu.insertEduImg", map);
	}
	
	/**
	 * 删除教育设施图片
	 * @param 
	 * @return Integer
	 */
	public Integer deleteEduImg(Map<String, Object> map) {
		return this.excutor.delete("edu.deleteEduImg", map);
	}
	/**
	 * 查询教育设施图片
	 * @param String eduId 教育设施ID  
	 * @return List<AroundEduImgModel> 
	 */
	public List<AroundEduImgModel> getEduImgList(Map<String, Object> map){
		return this.excutor.queryForList("edu.getEduImg", map);
	}
	/**
	 * 根据楼盘id拼接周边教育设施名称 dl
	 * @param map 
	 * @return 
	 */
	public Object getEduNameConcat(String eduIds) {
		return this.excutor.queryForObject("edu.getEduNameConcat", eduIds);
	}
}
