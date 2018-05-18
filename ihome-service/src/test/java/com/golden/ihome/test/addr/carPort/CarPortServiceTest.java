package com.golden.ihome.test.addr.carPort;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class CarPortServiceTest extends BaseTest{

	/*@Test
	public void insertCarPort(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "2");
		map.put("floor", "-1");
		map.put("parkNum", "B14");
		map.put("premisesId", "2");
		ResultValue process = process("carPort/carPortService.insertCarPort", map);
		System.out.println(process.getData());
	}
	@Test
	public void getCarPortListForPage(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", 1);
		map.put("rowCount", 3);
		map.put("premisesId", "1");
		map.put("parkNum", "");
		map.put("authorize", "");
		map.put("telephone", "");
		map.put("floor", "");
		ResultValue process = process("carPort/carPortService.getCarPortListForPage", map);
		System.out.println(process.getData());
	}
	@Test
	public void getCarPortIs(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "2");
		map.put("floor", "-2");
		map.put("parkNum", "A10333");
		map.put("premisesId", "1");
		ResultValue process = process("carPort/carPortService.getCarPortIs", map);
		System.out.println(process.getData());
	}
	@Test
	public void getCarPortById(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "2");
		ResultValue process = process("carPort/carPortService.getCarPortById", map);
		System.out.println(process.getData());
	}
	@Test
	public void updateCarPortById(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "2");
		map.put("floor", "1");
		map.put("parkNum", "A12");
		map.put("premisesId", "1");
		map.put("telephone", "232543");
		ResultValue process = process("carPort/carPortService.updateCarPortById", map);
		System.out.println(process.getData());
	}
	@Test
	public void insertCarPortRecord(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", "跟进记录22222");
		map.put("carPortId", "1");
		ResultValue process = process("carPortRecord/carPortRecordService.insertCarPortRecord", map);
		System.out.println(process.getData());
	}*/
	/*@Test
	public void getCarPortRecordListById(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("carPortId", "1");
		ResultValue process = process("carPortRecord/carPortRecordService.getCarPortRecordListById", map);
		System.out.println(process.getData());
	}*/
	/*@Test
	public void deleteCarPorts(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("carPortIds", "2,3");
		map.put("premisesId", "1");
		ResultValue process = process("carPort/carPortService.deleteCarPorts", map);
		System.out.println(process.getData());
	}
	@Test
	public void contactRoomByPortId(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roomId", "1");
		map.put("carPortId", "7");
		ResultValue process = process("carPort/carPortService.contactRoomByPortId", map);
		System.out.println(process.getData());
	}
	@Test
	public void getRoomList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("buildingId", "1");
		ResultValue process = process("carPort/carPortService.getRoomList", map);
		System.out.println(process.getData());
	}*/
	/**
	 * 批量生成车位
	 * @param 	prefix 前缀    
	 * 			suffix 后缀  
	 *   	   	startNum 起始号
	 *   		endNum 结束号
	 *   		ignore 忽略号
	 *   		isNumberFill 号段0补位  0:不补位  1：补位
	 *   		type 类型 1地上车位   2地下车位
	 *   		floor 楼层
	 *   		premisesId 楼盘id
	 * @return  Integer 0 保存失败 1 保存成功 2该号段数据已存在
	 */
//	@Test
//	public void addCarPorts(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("prefix", "");
//		map.put("suffix", "号");
//		map.put("startNum", 12);
//		map.put("endNum", 15);
//		map.put("ignore", "");
//		map.put("isNumberFill", 0);
//		map.put("type", 1);
//		map.put("floor", -2);
//		map.put("premisesId", 1);
//		ResultValue process = process("carPort/carPortService.insertCarPorts", map);
//		System.out.println(process.getData());
//	}
//	@Test
//	public void getParentSources(){
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("parentId", 3);
//		ResultValue process = process("houseSource/houseSourceService.getSourcesByParentId", map);
//		System.out.println(process.getData());
//	}
	/**
	 * #{carPortId,jdbcType=DECIMAL}, 
			#{addressDetail,jdbcType=VARCHAR}, 
			#{ownerName,jdbcType=VARCHAR}, 
			#{ownerTel,jdbcType=VARCHAR}, 
			#{propertyRightType,jdbcType=DECIMAL}, 
			#{leasePrice,jdbcType=DECIMAL}, 
			#{entrustPrice,jdbcType=DECIMAL}, 
			#{propertyFee,jdbcType=DECIMAL}, 
			#{fckCode,jdbcType=VARCHAR}, 
			#{fckDate,jdbcType=Date},
			#{houseSourceId,jdbcType=DECIMAL}, 
			#{status,jdbcType=DECIMAL}, 
			#{tags,jdbcType=DECIMAL}, 
			#{remark,jdbcType=VARCHAR},
	 */
//	@Test
//	public void insertHouseLeaseWithCarPort(){
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("carPortId", 10);
//		map.put("addressDetail", "111");
//		map.put("ownerName", "yezhu");
//		map.put("ownerTel", 3);
//		map.put("propertyRightType", 1);
//		map.put("leasePrice", 3);
//		map.put("entrustPrice", 3);
//		map.put("propertyFee", 3);
//		map.put("fckCode", 3);
//		map.put("fckDate", "2016-02-12");
//		map.put("houseSourceId", 24);
//		map.put("status", 2);
//		map.put("tags", 2);
//		ResultValue process = process("carPort/carPortService.insertHouseSaleWithCarPort", map);
//		System.out.println(process.getData());
//	}
//	@Test
//	public void carPortLeasedIs(){
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("carPortId", 14);
//		ResultValue process = process("carPort/carPortService.carPortLeasedIs", map);
//		System.out.println(process.getData());
//	}
	@Test
	public void insertHouseLeaseWithCarPort(){
		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("carPortId", 14);
		ResultValue process = process("carPort/carPortService.insertHouseLeaseWithCarPort", map);
		System.out.println(process.getData());
	}

}
