package com.golden.ihome.test.addr.building;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class BudingText extends BaseTest{

/*	@Test
	public void executeTest(){
		
		Map<String, Object> roomMap = new HashMap<String, Object>();
		roomMap.put("prefix","A");
		roomMap.put("name","101");
		roomMap.put("suffix","B");
		roomMap.put("floor","1");
		Map<String, Object> roomMap1 = new HashMap<String, Object>();
		roomMap1.put("prefix","A");
		roomMap1.put("name","101");
		roomMap1.put("suffix","B");
		roomMap1.put("floor","1");
		Map<String, Object> roomMap2 = new HashMap<String, Object>();
		roomMap2.put("prefix","A");
		roomMap2.put("name","101");
		roomMap2.put("suffix","B");
		roomMap2.put("floor","1");
		
		List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
		roomList.add(roomMap);
		roomList.add(roomMap1);
		roomList.add(roomMap2);
		Map<String, Object> unitMap = new HashMap<String, Object>();
		unitMap.put("unit", "ssss");
		unitMap.put("roomList", roomList);
		
		//{"roomList":[{"floor":"1","name":"101","prefix":"A","suffix":"B"},{"floor":"1","name":"101","prefix":"A","suffix":"B"},{"floor":"1","name":"101","prefix":"A","suffix":"B"}],"unit":"1"}
		//ResultValue process = process("busiArea/BusiAreaService.getBusiAreaQCPage", map);
		String obj = JSON.toJSONString(unitMap);
		System.out.println(obj);
		JSONObject parseObject = JSON.parseObject(obj);
		System.out.println(parseObject.get("unit"));
	}*/
	/*@Test
	public void unit(){
		
		//一单元
		//一个房间对象
		Map <String, Object> roomMap = new HashMap<String, Object>();
		roomMap.put("prefix","A");
		roomMap.put("name","101");
		roomMap.put("suffix","B");
		roomMap.put("floor","1");
		//两个房间对象
		Map <String, Object> roomMap1 = new HashMap<String, Object>();
		roomMap1.put("prefix","A");
		roomMap1.put("name","101");
		roomMap1.put("suffix","B");
		roomMap1.put("floor","1");
		//一单元房间数组
		List list = new ArrayList<>();
		list.add(roomMap);//往单元里放每个房间对象
		list.add(roomMap1);
		//一个单元对象
		Map<String, Object> unitMap = new HashMap<String, Object>();
		unitMap.put("unitfix", "a");
		unitMap.put("unitsuffix", "b");
		unitMap.put("roomList", list);
		
		//二单元
        //一个房间对象
		Map <String, Object> roomMap2 = new HashMap<String, Object>();
		roomMap2.put("prefix","A");
		roomMap2.put("name","101");
		roomMap2.put("suffix","B");
		roomMap2.put("floor","1");
		//两个房间对象
		Map <String, Object> roomMap3 = new HashMap<String, Object>();
		roomMap3.put("prefix","A");
		roomMap3.put("name","101");
		roomMap3.put("suffix","B");
		roomMap3.put("floor","1");
		//一单元房间数组
		List list1 = new ArrayList<>();
		list1.add(roomMap2);
		list1.add(roomMap3);
		//二单元对象
		Map<String, Object> unitMap1 = new HashMap<String, Object>();
		unitMap1.put("unitfix", "a");
		unitMap1.put("unitsuffix", "b");
		unitMap1.put("roomList", list1);
		
		//一单元和二单元的数据
		List unitList = new ArrayList<>();
		unitList.add(unitMap1);
		unitList.add(unitMap);
		//所有单元和房间
		Map all = new HashMap();
		all.put("unitList", unitList);
		
		System.out.println(JSON.toJSONString(all));
		
		all.get("unitList");
		System.out.println(JSON.toJSONString(all.get("unitList")));
		//在service获取的map 的 vaule
		String jsonString = JSON.toJSONString(all.get("unitList"));
		
		List listunit = JSON.parseObject(jsonString, List.class);
		for (Object object : listunit) {
			Map map = JSON.parseObject(JSON.toJSONString(object), Map.class);
			System.out.println(map);
			Object roomList = map.get("roomList");
			List roomLists = JSON.parseObject(JSON.toJSONString(roomList), List.class);
			for (Object object2 : roomLists) {
				Map maproom = JSON.parseObject(JSON.toJSONString(object2), Map.class);
				System.out.println(maproom);
			}
			System.out.println(map.get("roomList"));
		}
		
	}*/
	/*@Test
	public void unit3(){

		Map<String, Object> roomMap = new HashMap<String, Object>();
		roomMap.put("prefix","A");
		roomMap.put("name","101");
		roomMap.put("suffix","B");
		roomMap.put("floor","1");
		Map<String, Object> roomMap1 = new HashMap<String, Object>();
		roomMap1.put("prefix","A");
		roomMap1.put("name","101");
		roomMap1.put("suffix","B");
		roomMap1.put("floor","1");
		Map<String, Object> roomMap2 = new HashMap<String, Object>();
		roomMap2.put("prefix","A");
		roomMap2.put("name","101");
		roomMap2.put("suffix","B");
		roomMap2.put("floor","1");
		
		List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
		roomList.add(roomMap);
		roomList.add(roomMap1);
		roomList.add(roomMap2);
		Map<String, Object> unitMap = new HashMap<String, Object>();
		unitMap.put("unit", "ssss");
		unitMap.put("roomList", roomList);
		
		String  listStr = JSON.toJSONString(roomList);
		
		System.out.println(listStr);
		List list = JSON.parseObject(listStr, List.class);
		for (Object object : list) {
			Map map = JSON.parseObject(JSON.toJSONString(object), Map.class);
			System.out.println(map.getClass());
			System.out.println(map.get("floor"));
		
		}
		
		ResultValue process = process("busiArea/BusiAreaService.getBusiAreaQCPage", map);
	}*/
	

/*	@Test
	public void executeTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("premisesId", 3);
		ResultValue process = process("baseBuilding/baseBuildingService.getPremisesMenu", map);
		System.out.println(process.getData());
	}*/
	/**
	 * 批量添加房间
	 */
	@Test
	public void executeTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("numEnd", 1013);//号段结束
		map.put("numStart", 1013);//号段开始
		map.put("houseCodeType", 2);//号段类型1字母 2是数字（控制开始和结束号段）
		map.put("premisesId", 3);//楼盘id
		map.put("houseNum", 1);//楼栋数
		//map.put("buildingGroupId", "");//分组id
		ResultValue process = process("baseBuilding/baseBuildingService.insertSelective", map);
		
	}
}
