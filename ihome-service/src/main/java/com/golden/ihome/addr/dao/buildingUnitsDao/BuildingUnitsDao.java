package com.golden.ihome.addr.dao.buildingUnitsDao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BuildingUnitsModel;
import com.golden.port.framework.mybatis.IBaseDao;
/**
 * @author lza
 * 类名称：单元管理Dao
 * 类描述：针对单元表的数据访问
 * 日          期：2016-10-17
 */
@Repository("buildingUnitsDao")
public class BuildingUnitsDao extends IBaseDao{
	/**
	 * 根据id获取一条单元数据
	 * @param param{BuildingUnitsId：id}
	 * @return buildingUnits
	 */
	
	public BuildingUnitsModel getbuildingUnits(Map<String,Object> param){
		return this.excutor.queryForObject("buildingUnits.getBuildingUnits", param);
	}
	/**
	 * 根据id更新单元实体
	 * @param param{buildingUnitsId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer updatebuildingUnits(Map<String,Object> param){
		return this.excutor.update("buildingUnits.updateSelective", param);
	}
	/**
	 * 根据id删除单元一条或多条数据
	 * @param param{buildingUnitsId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer deletebuildingUnits(Map<String,Object> param){
		return this.excutor.delete("buildingUnits.deleteBuildingUnits", param);
	}
	
	/**
	 * 可选择添加字段的新增一条单元数据
	 * @param param 实体的所有属性均可
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insertSelective(Map<String,Object> param){
		return this.excutor.insert("buildingUnits.insertSelective", param);
	}
	
	/**
	 * 批量添加单元编号
	 * @param param {codes：单元编号数组}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insertBatch(Map<String,Object> param){
		return this.excutor.insert("buildingUnits.insertBatch", param);
	}
	/**
	 * 获取楼栋下的单元个数
	 * @param param {buildingId：楼栋id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer getBuildingUnitNum(Map<String,Object> param){
		return this.excutor.queryForObject("buildingUnits.getBuildingUnitNum", param);
	}
	
	
	/**
	 * 回显单元规则
	 * @param param
	 * @return
	 */
	public List<BuildingUnitsModel> geteditUnit(Map<String,Object> param){
		return this.excutor.queryForList("BaseBuilding.getBuildingUnitRule", param);
	}
	
	/**
	 * 查询单元是否存在
	 * @param param
	 * @return
	 */
	public Integer getUnit(Map<String,Object> param){
		return this.excutor.queryForObject("buildingUnits.getUnit", param);
	}
	
	/**
	 * 
	 * @param param{}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer updateGroupid(Map<String,Object> param){
		return this.excutor.update("buildingUnits.updateGroupid", param);
	}
}
