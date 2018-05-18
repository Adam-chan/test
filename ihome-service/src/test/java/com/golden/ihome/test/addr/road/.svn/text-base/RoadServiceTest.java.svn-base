package com.golden.ihome.test.addr.road;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.golden.ihome.test.BaseTest;
import com.golden.port.framework.stores.results.ResultValue;

public class RoadServiceTest extends BaseTest{

//	/**
//	 * 新增道路信息
//	 */
	@Test
	public void addRoadTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i = 0 ; i < 100000L ;i++ ){
			map.put("roadName", "测试道路"+i);
			ResultValue process = process("road/roadService.insertRoad", map);
			System.out.println(process.getData());
		}
		
	}
//	/**
//	 * 更新道路信息
//	 */
//	@Test
//	public void updateRoadTest(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "2");
//		map.put("roadName", "hhhh");
//		ResultValue process = process("road/roadService.updateRoad", map);
//		System.out.println(process.getData());
//	}
//	/**
//	 * 分页查询道路
//	 * @param params
//	 * @return
//	 */
//	@Test
//	public void getRoadListForPage(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "13");
//		map.put("currentPage", 1);
//		map.put("rowCount", 3);
//		ResultValue process = process("road/roadService.getRoadListForPage", map);
//		System.out.println(process.getData());
//	}
//	/**
//	 * 查询所有道路信息
//	 * @param 
//	 * @return
//	 */
//	@Test
//	public void getRoadList(){
//		ResultValue process = process("road/roadService.getRoadList",null);
//		System.out.println(process.getData());
//	}
//	/**
//	 * 根据id查询道路
//	 * @param map
//	 * @return
//	 */
//	@Test
//	public void getRoadById(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "1343");
//		ResultValue process = process("road/roadService.getRoadById", map);
//		System.out.println(process.getJsonObject());
//	}
//	/**
//	 * 批量删除道路
//	 */
//	@Test
//	public void delRoads(){
//		Map<String, Object> map = new HashMap<String,Object>();
//		String str = 12+","+13+","+14;
//		map.put("rowIds", str);
//		ResultValue process = process("road/roadService.deleteRoads", map);
//		System.out.println(process.getData());
//	}
	/**
	 * 批量插入道路和区域关联关系
	 */
	@Test
	public void insertRoadAreaContact(){
		Map<String, Object> map = new HashMap<String, Object>();
		String areaIdStr = "936,939";
		map.put("areaIdStr", areaIdStr);
		ResultValue process = process("road/roadService.insertRoadAreaContact", map);
		System.out.println(process.getData());
	}
	/**
	 * 查询浙江省杭州市下所有区
	 * @param map
	 * @return
	 */
	@Test
	public void getAreasList(){
		ResultValue process = process("road/roadService.getAreasList", null);
		System.out.println(process.getData());
	}
	
	/**
	 * 撒号
	 */
	@Test
	public void saveRoadNumTest(){
		//以下方法已经执行了280多万，如果再生成撒号，需要查询数据库，看看数据。在重新输入下方 循环中i的起始值（道路ID）
		/*String [] areaList = new String[]{"935","936","937","938","939","940","941","942","943","944","945","946","947"};
		Map<String, Object> map = new HashMap<String, Object>();
		int j = 0;
		for(int i = 43 ; i < 28666L;i++){
			map.put("creatNumType", 1);//连续撒号
			map.put("startNum", 1);//起始号
			map.put("endNum",500);//终止号
			if(j >12){
				j = 0;
			}
			map.put("areaId", areaList[j]);//区ID
			map.put("roadId", i);//道路ID
			map.put("ignore","");//忽略号段 
			map.put("operator", "test1");//操作员
			ResultValue result = process("road/roadService.addRoadNum", map);
			System.out.println(result.getData()+"道路撒号管数据成功");
			j++;
		}*/
		//{creatNumType=1, endNum=10, startNum=1, areaId=935, roadId=24469, ignore=, operator=test1}
		
	}
}
