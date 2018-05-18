package com.golden.ihome.addr.dao.baseHouse;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BaseHouseModel;
import com.golden.ihome.addr.model.BuildingUnitsModel;
import com.golden.ihome.addr.model.HouseAllAddressModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;

/**
 * 
 * @author lza
 * 类名称：房间管理dao
 * 类描述：房间管理dao
 * 时间：2016-10-18
 */
@Repository("baseHouseDao")
public class BaseHouseDao extends IBaseDao{
	
	/**
	 * 根据id获取一房间元数据
	 * @param param{baseHouseId：id}
	 * @return baseHouse
	 */
	
	public BaseHouseModel getbaseHouse(Map<String,Object> param){
		return this.excutor.queryForObject("baseHouse.getBaseHouse", param);
	}
	/**
	 * 根据条件获取多条房间元数据
	 * @param param{baseHouseId：id}
	 * @return baseHouse
	 */
	
	public List<BaseHouseModel> getBaseHouseList(Map<String,Object> param){
		return this.excutor.queryForList("baseHouse.getBaseHouseList", param);
	}
	/**
	 * 根据id更新房间实体
	 * @param param{baseHouseId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer updatebaseHouse(Map<String,Object> param){
		return this.excutor.update("baseHouse.updateSelective", param);
	}
	/**
	 * 根据id删除房间一条或多条数据
	 * @param param{baseHouseId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer deletebaseHouse(Map<String,Object> param){
		return this.excutor.delete("baseHouse.delete", param);
	}
	
	/**
	 * 可选择添加字段的新增一房间元数据
	 * @param param 实体的所有属性均可
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insertSelective(Map<String,Object> param){
		return this.excutor.insert("baseHouse.insertSelective", param);
	}
	
	/**
	 * 批量添加房间编号
	 * @param param {codes：房间编号数组}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insertBatch(List<Map<String, Object>> list){
		return this.excutor.insert("baseHouse.insertBatch", list);
	}
	
	/**
	 * 根据unitId 楼层获取房间信息
	 * @param param
	 * @return
	 */
	public List<BaseHouseModel> getRoomsMatchFloor(Map<String,Object> param){
		return this.excutor.queryForList("baseHouse.getRoomsMatchFloor", param);
	}
	
	/**
	 * 根据buildingId获取房间信息
	 * @param param
	 * @return
	 */
	public List<BaseHouseModel> getRoomInfo(Map<String,Object> param){
		return this.excutor.queryForList("baseHouse.selectRoomsInfo", param);
	}
	
	/**
	 * 根据buildingId获取单元信息
	 * @param param
	 * @return
	 */
	public List<BuildingUnitsModel> getUnitsInfo(Map<String,Object> param){
		return this.excutor.queryForList("buildingUnits.getBuildingUnitInfo", param);
	}
	
	/**
	 * 获取房间分页数据
	 * @param param 
	 * @return 
	 */
	public PagerResult<BaseHouseModel> getStorePage(Map<String, Object> param) {
		return this.excutor.queryListPage("baseHouse.getStorePage", param);
	}
	/**
	 * 校验重名 updateHouse != null and baseHouseId!='' and buildingId !='' and buildingId !=null
	* @param param map{updateHouse：跟新名字 or houseName：添加名字 ,baseHouseId:房间id（跟新需要）buildingId：楼栋id}
	 *@return 
	 */
	public Integer getByNum(Map<String,Object> param){
		return this.excutor.queryForObject("baseHouse.getByNum", param);
	}
	/**
	 *校验单元下有是否有房间
	* @param {unitId：单元id}
	 *@return 
	 */
	public Integer getbyUnitDelNum(Map<String,Object> param){
		return this.excutor.queryForObject("baseHouse.getbyUnitDelNum", param);
	}
	
	/**
	 *获取房间全地址
	* @param {houseIds：房间id字符串}
	 *@return 
	 */
	public List<HouseAllAddressModel> getHouseAllAddress(Map<String,Object> param){
		return this.excutor.queryForList("baseHouse.getHouseAllAddress", param);
	}
	
	/**
	 *获取房间全地址一条数据
	* @param {houseIds：房间id字符串}
	 *@return 
	 */
	public HouseAllAddressModel getOneHouseAllAddress(Map<String,Object> param){
		return this.excutor.queryForObject("baseHouse.getOneHouseAllAddress", param);
	}
	/**
	 *
	 * @param param{}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer updateGroupid(Map<String,Object> param){
		return this.excutor.update("baseHouse.updateGroupid", param);
	}
	
	/**
	 * 获取房间是否被引用为房源
	 * @param param
	 * @return
	 */
	public Integer getHouseSource(Map<String, Object> param){
		return this.excutor.queryForObject("baseHouse.houseSource", param);
	}
}
