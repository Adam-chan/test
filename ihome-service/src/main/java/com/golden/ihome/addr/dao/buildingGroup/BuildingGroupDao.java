package com.golden.ihome.addr.dao.buildingGroup;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BaseBuildingModel;
import com.golden.ihome.addr.model.BuildingGroupModel;
import com.golden.ihome.addr.model.PremisesMenuModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * @author lza
 * 类名称：楼栋分组Dao
 * 类描述：针对分组表的数据访问
 * 日          期：2016-10-20
 */
@Repository(value="buildingGroupDao")
public class BuildingGroupDao extends IBaseDao{

	/**
	 * 根据id获取一条分组数据
	 * @param param{BaseBuildingId：id}
	 * @return BaseBuildingModel
	 */
	public BuildingGroupModel getBuildingGroup(Map<String,Object> param){
		return this.excutor.queryForObject("BuildingGroup.getBuildingGroup", param);
	}
	/**
	 * 根据楼盘id获取分组数据
	 * @param param{BaseBuildingId：id}
	 * @return Object
	 */
	public List<Object> getBuildingGroupList(Map<String,Object> param){
		return this.excutor.queryForList("BuildingGroup.getBuildingGroupList", param);
	}
	/**
	 * 根据楼盘id获取分组数据
	 * @param param{BaseBuildingId：id}
	 * @return BaseBuildingModel
	 */
	public List<BaseBuildingModel> getBuildingsGroupList(Map<String,Object> param){
		return this.excutor.queryForList("BuildingGroup.getBuildingGroupList", param);
	}
	
	/**
	 * 校验名字是否重复
	 * @param param{groupName：groupName} or param{updateGroupName:updateGroupName,groupId:groupId}
	 * @return Integer
	 */
	public Integer	getGroupNum(Map<String,Object> param){
		return this.excutor.queryForObject("BuildingGroup.getGroupNum", param);
	}
	

	/**
	 * 根据id删除分组实体
	 * @param param {BuildingGroup：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer delete(Map<String,Object> param){
		return this.excutor.delete("BuildingGroup.delete", param);
	}
	
	/**
	 * 新增一条分组数据
	 * @param param 实体的所有属性
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insert(Map<String,Object> param){
		return this.excutor.insert("BuildingGroup.insert", param);
	}
	
	/**
	 * 可选择添加字段的新增一条分组数据
	 * @param param {BuildingGroup：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insertSelective(Map<String,Object> param){
		return this.excutor.insert("BuildingGroup.insertSelective", param);
	}

	/**
	 * 根据id有选择的更新分组实体
	 * @param param{BaseBuildingId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer updateSelective(Map<String,Object> param){
		return this.excutor.update("BuildingGroup.updateSelective", param);
	}
	
	
	/**
	 * 根据id更新分组实体
	 * @param param {BuildingGroup：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer update(Map<String,Object> param){
		return this.excutor.update("BuildingGroup.update", param);
	}
	/**
	 * 根据id获取分组导航及楼栋导航
	 * @param param {premisesId：id}
	 * @return List<PremisesMenuModel>(大于0成功，小于0不成功)
	 */
	public PagerResult<PremisesMenuModel> getPremisesMenuPage(Map<String,Object> param){
		return this.excutor.queryListPage("BuildingGroup.getPremisesMenuPage", param);
	}
	
	/**
	 * 批量插入楼盘分组
	 * @param param {key:groupList}groupList为数组名称的数组
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insertBatch(Map<String,Object> param){
		return this.excutor.insert("BuildingGroup.insertBatch", param);
	}
}
