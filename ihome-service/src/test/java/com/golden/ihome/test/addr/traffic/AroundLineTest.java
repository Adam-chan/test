package com.golden.ihome.test.addr.traffic;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class AroundLineTest extends BaseTest{

	/**
	 * 新增线路信息
	 * @param map
	 * @return
	 */
//	@Test
//	public void insertSiteTest(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("lineName", "10路");
//		map.put("firstTime", "06:00");
//		map.put("lastTime", "20:00");
//		map.put("ticketPrice", 2);
//		map.put("trafficType", 1);
//		map.put("remark", "");
//		ResultValue process = process("traffic/aroundLineService.insertLine", map);
//		System.out.println(process.getData());
//	}
//	@Test
//	public void getLineByName(){
//		ResultValue process = process("traffic/aroundLineService.getLineByName", "33路");
//		System.out.println(process.getData());
//	}
//	/**
//	 * 修改线路信息
//	 * @param map
//	 * @return
//	 */
//	@Test
//	public void updateSite(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "2");
//		map.put("lineName", "13路");
//		map.put("firstTime", new Date());
//		map.put("lastTime", new Date());
//		map.put("ticketPrice", "");
//		map.put("remark", "rrrrrrrr");
//		ResultValue process = process("traffic/aroundLineService.updateLineById", map);
//		System.out.println(process.getData());
//	}
	/**
	 * 新增单条栋座信息 dl
	 * @param   premisesId 楼盘id
		    	groupId 楼盘分组id
				purpose 房屋用途（1商用，2民用）
				buildingYear 建筑年代 （数值型）
				buildingConst 建筑结构（数值型）
				buildingType 建筑类型（数值型）
				buildingName 楼栋编号（字符型）
				propertyNature 产权性质（数值型）
				costType 缴费类型（1物业费2清洁费）
				propertyFee 物业费/清洁费
	 * @return
	 */
//	@Test
//	public void insertOneBaseBuilding(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("premisesId", 1);
//		map.put("groupId", 2);
//		map.put("purpose", 2);
//		map.put("buildingYear", 2);
//		map.put("buildingConst", 1);
//		map.put("buildingType", 1);
//		map.put("buildingName", "基督山");
//		map.put("propertyNature", 1);
//		map.put("costType", 1);
//		map.put("propertyFee", 20);
//		ResultValue process = process("baseBuilding/baseBuildingService.insertOneBaseBuilding", map);
//		System.out.println(process.getData());
//	}
	/**
	 * 新增单条栋座信息 dl
	 * @param   buildingId 栋座id
	 * @return	0删除失败 1删除成功 2该楼栋有关联数据
	 */
	@Test
	public void deleteBaseBuildingById(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("buildingId", 219);
		ResultValue process = process("baseBuilding/baseBuildingService.deleteBaseBuildingById", map);
		System.out.println(process.getData());
	}
	
}
