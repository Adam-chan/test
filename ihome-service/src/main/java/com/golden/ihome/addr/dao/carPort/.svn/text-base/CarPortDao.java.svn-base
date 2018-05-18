package com.golden.ihome.addr.dao.carPort;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BaseBuildingModel;
import com.golden.ihome.addr.model.BuildingGroupModel;
import com.golden.ihome.addr.model.BuildingUnitsModel;
import com.golden.ihome.addr.model.CarPortModel;
import com.golden.ihome.addr.model.ParkContactRoomModel;
import com.golden.port.framework.mybatis.IBaseDao;
import com.golden.port.framework.pages.PagerResult;
/**
 * @author dl
 * 类名称：车位信息dao
 * 时间：2016-10-19
 */
@Repository(value="carPortDao")
public class CarPortDao extends IBaseDao{

	public Integer insertCarPort(Map<String, Object> map) {
		return this.excutor.insert("carPort.insertCarPort", map);
	}

	public PagerResult<CarPortModel> getCarPortListForPage(Map<String, Object> map) {
		return this.excutor.queryListPage("carPort.getCarPortListForPage", map);
	}

	public List<CarPortModel> getParkNumsByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getParkNumsByMatch",map);
	}

	public CarPortModel getCarPortById(Map<String, Object> map) {
		return this.excutor.queryForObject("carPort.getCarPortById", map);
	}

	public Integer updateCarPortById(Map<String, Object> map) {
		return this.excutor.update("carPort.updateCarPortById", map);
	}

	public List<Integer> getCarPortIs(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getCarPortIs", map);
	}

	public Integer deleteCarPorts(Map<String, Object> map) {
		return this.excutor.delete("carPort.deleteCarPorts", map);
	}
	
	public List<CarPortModel> getPortListContactedRoom(Map<String, Object> map){
		return this.excutor.queryForList("carPort.getPortListContactedRoom", map);
	}

	public Integer contactRoomByPortId(Map<String, Object> map) {
		return this.excutor.update("carPort.contactRoomByPortId", map);
	}

	public Integer removeRoom(Map<String, Object> map) {
		return this.excutor.update("carPort.removeRoom", map);
	}

	public List<BaseBuildingModel> getBuildingsByPremisesId(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getBuildingsByPremisesId", map);
	}

	public List<BuildingGroupModel> getGroupsByPremisesId(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getGroupsByPremisesId", map);
	}

	public List<BaseBuildingModel> getBuildingsByGroupId(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getBuildingsByGroupId", map);
	}
	public List<BuildingUnitsModel> getUnitsByBuildingId(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getUnitsByBuildingId", map);
	}

	public List<ParkContactRoomModel> getRoomList(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getRoomList",map);
	}

	public Integer insertCarPortLog(Map<String, Object> map) {
		return this.excutor.insert("carPort.insertCarPortLog", map);
	}

	public List<String> getAllPortNumList(Map<String,Object> map) {
		return this.excutor.queryForList("carPort.getAllPortNumList",map);
	}

	public Integer insertCarPorts(Map<String, Object> map) {
		return this.excutor.insert("carPort.insertCarPorts", map);
	}
	
	public Object carPortLeasedIs(Map<String, Object> map) {
		return this.excutor.queryForObject("carPort.carPortLeasedIs", map);
	}

	public Object carPortSaledIs(Map<String, Object> map) {
		return this.excutor.queryForObject("carPort.carPortSaledIs", map);
	}

	public Integer updateAuthorizeByPortId(Map<String, Object> map) {
		return this.excutor.insert("carPort.updateAuthorizeByPortId", map);
	}

	public Integer deleteCarPortByIds(Map<String, Object> map) {
		return this.excutor.delete("carPort.deleteCarPortByIds", map);
	}
	/**
	 * 转为出租/转为出售 保存HOUSE_INFO
	 * @param map
	 * @return
	 */
	public Integer insertHouseInfo(Map<String, Object> map) {
		return this.excutor.insert("carPort.insertHouseInfo", map);
	}
	/**
	 * 转为出租
	 * @param map
	 * @return
	 */
	public Integer insertCarPortLease(Map<String, Object> map) {
		return this.excutor.insert("carPort.insertCarPortLease", map);
	}
	/**
	 * 转为出售
	 * @param map
	 * @return
	 */
	public Integer insertCarPortSale(Map<String, Object> map) {
		return this.excutor.insert("carPort.insertCarPortSale", map);
	}
	/**
	 * 批量保存房源联系人
	 * @param map
	 * @return
	 */
	public Integer insertHouseLinkMans(Map<String, Object> map) {
		return this.excutor.insert("carPort.insertHouseLinkMans", map);
	}
	/**
	 * 模糊搜索车位
	 * @param map
	 * @return
	 */
	public List<CarPortModel> getCarPortByMatch(Map<String, Object> map) {
		return this.excutor.queryForList("carPort.getCarPortByMatch", map);
	}

}
