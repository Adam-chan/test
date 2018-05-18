package com.golden.ihome.crm.dao.house;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.BuildingPapersModel;
import com.golden.port.framework.mybatis.IBaseDao;
/**
 * @author lza
 * 类名称：限时速递管理Dao
 * 类描述：限时速递表的数据访问
 * 日          期：2016-11-18
 */
@Repository(value="buildingPapersDao")
public class BuildingPapersDao extends IBaseDao{


	/**
	 * 根据限时速递id获取证件列表
	 * @param map{timeLimitId：限时速递表的id}
	 * @return list<BuildingPapersModel>
	 */
	public  List<BuildingPapersModel> getBuildingPapers(Map<String, Object> map) {
		return this.excutor.queryForList("buildingPapers.getBuildingPapers", map);
	}
	
	/**
	 * 插入限速递
	 * @param map{BuildingPapersModel：实体的所有字段有选择插入}
	 * @return Integer 大于0 成功  小于0失败
	 */
	public Integer insertBuildingPapers(Map<String, Object> map) {
		return this.excutor.insert("buildingPapers.insertSelective", map);
	}
	/**
	 * 插入限速递
	 * @param map{BuildingPapersModel：实体的所有字段有选择插入}
	 * @return Integer 大于0 成功  小于0失败
	 */
	public Integer insertBatch(Map<String, Object> map) {
		return this.excutor.insert("buildingPapers.insertBatch", map);
	}
}
