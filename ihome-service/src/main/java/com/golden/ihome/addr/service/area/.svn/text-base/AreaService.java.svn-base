package com.golden.ihome.addr.service.area;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.basearea.BaseAreaDao;
import com.golden.ihome.addr.dao.busiArea.BusiAreaDao;
import com.golden.ihome.addr.dao.premisesManage.BasePremisesDao;
import com.golden.ihome.addr.dao.road.RoadDao;
import com.golden.ihome.addr.model.BaseAreaModel;
import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.ihome.addr.model.CommunityModel;
import com.golden.ihome.addr.model.RoadLogModel;
import com.golden.ihome.addr.model.SubdistrictModel;
import com.golden.ihome.common.CommonConst;
import com.golden.ihome.utils.PinYinUtil;
import com.golden.ihome.utils.SnCalUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/**
 * @author zhr
 * 类描述：省市区街道服务类
 */
@Service("area/areaService")
public class AreaService implements IBaseHandler{

	public static Logger logger = LoggerFactory.getLogger(AreaService.class);
	@Autowired
	private BaseAreaDao baseAreaDao;
	
	@Autowired
	private RoadDao roadDao;
	
	@Autowired
	private BusiAreaDao busiAreaDao;
	
	@Autowired
	private BasePremisesDao basePremisesDao;
	
	/**
	 * @param map { 
	 *      分页查询省市区
	 * 		areaId:地区ID
	 * 		areaLevel:查找级别55rrr
	 * 		currentPage:起始页数
	 * 		rowCount:查询条数
	 * } 
	 * @return
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		 return	 baseAreaDao.getAreaListPage(param);
	}
	/**
	 * 分页查询街道
	 * @param params
	 * @return
	 */
	public PagerResult<SubdistrictModel> getSubdistrictPage(Map<String, Object> params) {
		return baseAreaDao.getSubdistrictPage(params);
	}
	/**
	 * @param map {
	 * 		areaId:街道ID
	 * 		currentPage:起始页数
	 * 		rowCount:查询条数
	 * }  分页查询社区列表
	 * @return
	 */
	public PagerResult<CommunityModel> getCommunityPage(Map<String, Object> map) {
		return baseAreaDao.getCommunityPage(map);
	}
	/**
	 * @param map {
	 * 		省市区下拉List	
	 * 		areaId:地区ID
	 * 		areaLevel:查找级别
	 * } 
	 * @return
	 */
	public List<BaseAreaModel> getAreaList(Map<String, Object> param){
		return baseAreaDao.getAreaList(param); 
	}
	/**
	 * 根据ID查询BaseArea表信息
	 * 参数：map {baseAreaId：表的主ID,pid:所属父ID}
	 */
	public BaseAreaModel getAreaInfo(Map<String, Object> param){
		return baseAreaDao.getAreaInfo(param);
	}
	/**
	 * 根据ID查询街道表数据
	 * @param String 街道表ID
	 * @return SubdistrictModel
	 */
	public SubdistrictModel getSubdistrict(Map<String, Object> param){
		return baseAreaDao.getSubdistrict(param);
	}
	/**
	 * 根据名字和PID查询社区表信息
	 * 参数：map {subdistrictId：街道ID,areaName:社区名称}
	 */
	public CommunityModel getCommunityName(Map<String, Object> param){
		return baseAreaDao.getCommunityName(param);
	}
	/**
	 * 删除区域信息 逻辑删除 
	 * @param map
	 * @return
	 */
	@TM
	public Integer deleteArea(Map<String, Object> map){
		String different = map.get("different").toString();
		String rowIds = map.get("rowIds").toString();
		String type="";
		if(map.get("type")!=null){
			 type = map.get("type").toString();
		}
		int result = 2;
		String subdistrictId="";
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("status", 2);
		if(different.equals("2")){//删除区
			map2.put("areaId", rowIds);
			if(type.equals("1")){//如果区下有街道
				List<SubdistrictModel> subdistrictIdByAreaId = baseAreaDao.getSubdistrictIdByAreaId(map2);
				for(SubdistrictModel item:subdistrictIdByAreaId){
					subdistrictId += item.getId()+",";//根据区ID查询所有区下街道ID
				}
				String substring = subdistrictId.substring(0, subdistrictId.length()-1);
				map2.put("subdistrictId", substring);
				baseAreaDao.deleteArea(map2);//删除区
				baseAreaDao.deleteAreaSubdistrict(map2);//删除区下街道
				baseAreaDao.deleteAreaCommunity(map2);//删除街道下所有社区
				result = 1;
			}else{
				baseAreaDao.deleteArea(map2);//没有街道直接删除区
				result = 1;
			}
		}else if(different.equals("3")){//删除街道
			map2.put("subdistrictId", rowIds);
			if(type.equals("2")){//街道下存在社区 联级删除
				baseAreaDao.deleteAreaSubdistrict(map2);
				baseAreaDao.deleteAreaCommunity(map2);
				 result = 1;
			}else{//街道下无社区 直接删除街道
				baseAreaDao.deleteAreaSubdistrict(map2);
				 result = 1;
			}
		}else{//直接删除社区
			map2.put("communityId", rowIds);
			baseAreaDao.deleteAreaCommunity(map2);
			 result = 1;
		}
		return result;
	}

	/**
	 * 查询根据区ID查詢街道下拉集合数据
	 * @param params
	 * @return
	 */
	public List<SubdistrictModel> getSubdistrictList(Map<String, Object> param){
		String baseAreaId = param.get("baseAreaId").toString();
		return 	baseAreaDao.getSubdistrictList(baseAreaId);
	}
	
	/**
	 * 删除区域验证是否含有下一级数据  区 是否有道路号生成  生成后无法删除 街道和社区 是否被楼盘引用 
	 * @param map   rowIds : rowIds,  选择ID   逻辑删除
					different:different  选择行政等级
	 * @return
	 */
	@TM
	public Integer deteleHint(Map<String, Object> param){
		String different = param.get("different").toString();
		int result = 2;
		if(different.equals("2")){//删除区
			RoadLogModel roadLogCount = roadDao.getRoadLogCount(param);
				if(roadLogCount.getCount()>0){
					return 4;//当前区下存在已撒出的道路号
				}
			BusiAreaModel areaBusiCount = busiAreaDao.getAreaBusiCount(param);
				if(areaBusiCount.getCount()>0){
					return 5;//当前区下存在已关联的商圈
				}
			SubdistrictModel subdistrict = baseAreaDao.getSubdistrictCount(param);
			if(subdistrict!=null){
				Integer conunt = subdistrict.getConunt();
				if(conunt>0){
					return 3;//当前区下存在街道
				}
			}
		}else if(different.equals("3")){
			param.put("type", 1);
			Integer subdistrictVerify = basePremisesDao.getDeteleVerify(param);
			if(subdistrictVerify!=0){
				return 6;//删除街道时 楼盘下存在已引用街道
			}
			CommunityModel communityName = baseAreaDao.getCommunityCount(param);
			if(communityName!=null){
				Integer conunt = communityName.getConunt();
				if(conunt>0){
					return 1;//当前街道下存在社区
				}
			}	
		}else{
			param.put("type", 2);
			Integer communityVerify = basePremisesDao.getDeteleVerify(param);
			if(communityVerify!=0){
				return 7;//删除社区时 楼盘下存在已引用社区
			}
		}
		return 	result;
	}
	/**
	 * 更新区域-验证街道名是否存在
	 * @param params
	 * @return
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer verifyArea(Map<String, Object> param){
		int result = 2;
		String pId = param.get("pId").toString();
		String different = param.get("different").toString();
		String areaName = param.get("areaName").toString();
		if(different.equals("2")){
			//查询区是否存在
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("baseAreaPId", pId);
			map.put("areaName", areaName);
			BaseAreaModel areaInfo = baseAreaDao.getAreaInfo(map);
			if(areaInfo==null){
				return result = 1;//后台查不到就是成功
			}
		}else if(different.equals("3")){
			//查询街道是否存在
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("baseAreaPId", pId);
			map.put("areaName", areaName);
			SubdistrictModel subdistrictName = baseAreaDao.getSubdistrictName(map);//--------------------------------------------------
			if(subdistrictName==null){
				return result = 1;//后台查不到就是成功
			}
		}else{
			//查询社区是否存在
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("baseAreaPId", pId);
			map.put("areaName", areaName);
			CommunityModel communityName = baseAreaDao.getCommunityName(map);
			if(communityName==null){
				return result = 1;//后台查不到就是成功
			}
		}
		return result;
	}
	/**
	 * 修改
	 * @param params
	 * @return
	 */
	@TM
	@Aop(name="syncRoadAop",type="around")
	public Integer updateArea(Map<String, Object> param){
		int result = 2;
		String areaName = param.get("areaName").toString();
		String rowId = param.get("rowId").toString();
		String allArea = param.get("allArea").toString();
		String areaLevel = param.get("areaLevel").toString();
		String sort = "";
		sort = param.get("sort").toString();
		String showStatus = param.get("showStatus").toString();
		String remarkText = "";
		remarkText = param.get("remarkText").toString();
		String areaCode = "";
		if(param.get("areaCode")!=null){
			areaCode = param.get("areaCode").toString();
		}
		if(areaLevel.equals("2")){
			//更改区
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("mergerName", allArea+" "+areaName);
			map.put("areaId", rowId);
			map.put("name", areaName);
			map.put("showStatus", showStatus);
			map.put("sort", sort);
			map.put("remark", remarkText);
			map.put("areaCode", areaCode);
			Integer updateArea = baseAreaDao.updateArea(map);
			if(updateArea==1){
				return result = 1;  
			}
			//--更新sync 道路和楼盘详细地址
			map.clear();
			map.put("areaId", rowId);
			map.put("area", areaName);
			roadDao.updateRoadAddr(map);
			roadDao.updateHouseAddr(map);
			//--
		}else if(areaLevel.equals("3")){
			//更改街道
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("subdistrictId", rowId);
			map.put("subdistrictName", areaName);
			map.put("showStatus", showStatus);
			map.put("sort", sort);
			map.put("remark", remarkText);
			Integer updateSubdistrict = baseAreaDao.updateSubdistrict(map);
			if(updateSubdistrict==1){
				return result = 1;  
			}
		}else{
			//更改社区
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("communityId", rowId);
			map.put("communityName", areaName);
			map.put("showStatus", showStatus);
			map.put("sort", sort);
			map.put("remark", remarkText);
			Integer updateCommunity = baseAreaDao.updateCommunity(map);
			if(updateCommunity==1){
				return result = 1;
			}
		}
		return 	result;
	}
	/**
	 * 新增区域-验证街道名是否存在
	 * @param params
	 * @return
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer verifyAddArea(Map<String, Object> param){
		int result = 2;
		String areaCode = "";
		String areaName = "";
		String areaLevel = param.get("areaLevel").toString();
		if(param.get("areaName")!=null&&!param.get("areaName").equals("")){
			areaName = param.get("areaName").toString();
		}
		if(param.get("areaCode")!=null&&!param.get("areaCode").equals("")){
			areaCode = param.get("areaCode").toString();
		}
		if(!areaName.equals("")||!areaCode.equals("")){
			if(areaLevel.equals("3")){
				SubdistrictModel resultInfo = baseAreaDao.getSubdistrictName(param);
				if(resultInfo == null){
					return result ;//输入的该地区不存在上级地区
				}else{
					if(resultInfo.getName().equals(areaName)){   //验证街道
						return result = 1;//输入的数据库已存在
					}
				}
			}else if(areaLevel.equals("2")){
			if(!areaName.equals("")){
				BaseAreaModel areaInfo = baseAreaDao.getAreaInfo(param);
					if(areaInfo != null){
						if(areaInfo.getName().equals(areaName)){     //验证区
							return result = 1;//输入的数据库已存在  名字
						}
					}else{
						if(!areaCode.equals("")){
							BaseAreaModel areaCodeInfo = baseAreaDao.getAreaCodeInfo(param);
							if(areaCodeInfo!=null){
								if(areaCodeInfo.getAreaCode().equals(areaCode)){
									return result = 4;//输入的数据库已存在
								}
							}
						}else{
							return result;
						}
						
					}
			}
			if(!areaCode.equals("")){
				BaseAreaModel areaCodeInfo = baseAreaDao.getAreaCodeInfo(param);
				if(areaCodeInfo!=null){
					if(areaCodeInfo.getAreaCode().equals(areaCode)){
						return result = 4;//输入的数据库已存在
					}
				}else{
					return result;
				}
			}
			}else{
				CommunityModel communityName = baseAreaDao.getCommunityName(param);
				if(communityName == null){
					return result;//输入的该地区不存在上级地区
				}else{
					if(communityName.getName().equals(areaName)){     //验证社区
						 result = 1;//输入的数据库已存在
						return result;
					}
				}
			}
		}
		return result;
	}
	/**
	 * 新增区或街道或社区名称
	 * @param params
	 *  areaLevel:地区等级 3：代表区 2：代表市
	 * 		ID:主键ID
	 * baseAreaPid:代表所属地区的ID  添加区baseAreaPid表示市ID  添加街道baseAreaPid表示区ID
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer addArea(Map<String, Object> param) throws ClientProtocolException, IOException{
		int result = 2;
		String areaLevel = param.get("areaLevel").toString();
		String baseAreaPid = param.get("baseAreaPid").toString();
		String allArea = param.get("allArea").toString();
		String areaName = param.get("areaName").toString();
		String sort = param.get("sort").toString();
		String showStatus = "";
		if(param.get("showStatus")!=null){
			showStatus = param.get("showStatus").toString();
		}
		String remarkText = param.get("remarkText").toString();
		String areaCode = "";
		if(param.get("areaCode")!=null){
			areaCode = param.get("areaCode").toString();
		}
		param.put("status", CommonConst.UseIng);
				if(areaLevel.equals("3")){   //新增街道 参数传过来的areaLevel是所属地区的等级 3代表区
			Integer addSubdistrict = baseAreaDao.addSubdistrict(param);
			if(addSubdistrict==1){
				result=1;
			}
		}else if(areaLevel.equals("2")){   //新增区   2代表市
			String allAreaStr = "";
			allAreaStr = allArea+" "+areaName;
			String cn2FirstSpell = PinYinUtil.cn2FirstSpell(areaName);//首字母
			String cn2Spell = PinYinUtil.cn2Spell(areaName);//全拼
			Map<String,Object> map = new HashMap<String,Object>();
			try {
				Map<String, String> lngLat = SnCalUtil.getLngLat(allAreaStr);
				String areaLng = lngLat.get("lng");
				String areaLat = lngLat.get("lat");
				map.put("areaLng", areaLng);
				map.put("areaLat", areaLat);
			} catch (Exception e) {
				
			}
			map.put("pId", baseAreaPid);
			map.put("areaLevel", 3);
			map.put("areaCode", areaCode);
			map.put("areaName", areaName);
			map.put("cn2FirstSpell", cn2FirstSpell);
			map.put("cn2Spell", cn2Spell);
			map.put("mergerName", allAreaStr);
			map.put("sort", sort);
			map.put("showStatus", showStatus);
			map.put("remarkText", remarkText);
			map.put("status", CommonConst.UseIng);
			Integer insertAreaBorough = baseAreaDao.insertAreaBorough(map);
			if(insertAreaBorough==1){
				return 1;
			}
		}else{
			Integer addSubdistrict = baseAreaDao.addCommunity(param);
			if(addSubdistrict==1){
				return 1;
			}
		} 
		return 	result;
	}
	/**
	 * 模糊匹配 区
	 * @param param pId 父ID matchStr : 名称
	 * @return List<BaseAreaModel>
	 */
	public List<BaseAreaModel> getAreaByMatch(Map<String, Object> param){
		return baseAreaDao.getAreaByMatch(param);
	}
	/**
	 * 模糊匹配 街道
	 * @param param pId 父ID matchStr: 名称
	 * @return List<BaseAreaModel>
	 */
	public List<SubdistrictModel> getSubdistrictByMatch(Map<String, Object> param){
		return baseAreaDao.getSubdistrictByMatch(param);
	}
	/**
	 * 模糊匹配 社区
	 * @param param pId 父ID matchStr : 名称
	 * @return List<BaseAreaModel>
	 */
	public List<CommunityModel> getCommunityByMatch(Map<String, Object> param){
		return baseAreaDao.getCommunityByMatch(param);
	}
	/**
	 * 模糊匹配
	 * @param param matchStr : 名称
	 * @return List<BaseAreaModel>
	 */
	public List<BaseAreaModel> getAreaByMatchOfLevel3(Map<String, Object> param){
		return baseAreaDao.getAreaByMatchOfLevel3(param);
	}

	/**
	 * 获取社区列表
	 * @param String subdistrictId 街道ID
	 * @return List<CommunityModel>
	 */
	public List<CommunityModel> getCommunityList(Map<String, Object> map){
		return baseAreaDao.getCommunityList(map);
	}
}
