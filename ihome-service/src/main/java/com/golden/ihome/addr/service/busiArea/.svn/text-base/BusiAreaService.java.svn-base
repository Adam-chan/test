package com.golden.ihome.addr.service.busiArea;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.busiArea.BusiAreaDao;
import com.golden.ihome.addr.model.BusiAreaModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;
/**
 * @author lza
 * 类名称：商圈管理Controller
 * 类描述：商圈的新增 、修改、分页列表显示
 * 时间：2016-9-27
 */
@Service("busiArea/busiAreaService")
public class BusiAreaService implements IBaseHandler{
	@Autowired
	private BusiAreaDao busiAreaDao;
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return null;
	}
	/**
	 * 添加商圈
	 * @param param {key:businessAreaId,商圈名:AreaName,区划id:zoningId,行政区id集合:adminIds}
	 * @return Integer(type非等于0 成功，否则失败)
	 * @throws Exception
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer addBusiArea(Map<String, Object> param) throws Exception {
		//关系表的参数
		Map<String, Object> map = new HashMap<>();
		//添加和修改的返回值
		Integer type = 0;
		//判断重名
		 String busiName = (String) param.get("busiName");
		 map.put("busiName", busiName);
		 BusiAreaModel busiNameModel = busiAreaDao.getBusiName(map);
		 map.clear();
		 if(busiNameModel!=null){
			 type=-1;
			 return type;
		 }
		//判断关联行政区是否重复
		String adminIdArray = (String) param.get("adminIds");
		String[] Array = adminIdArray.split(",");
		for (int i = 0; i < Array.length; i++) {
			// 将数组元素依次与后面的数组元素比较  
			for (int j = i + 1; j < Array.length; j++) {
				if (Array[i] == Array[j]) {
					return type;
				}
			}
		}
		//判断名字是否为空或是空格
		 if(busiName.trim()==null||busiName.trim().equals("")||busiName.trim().equals("undefined")){
			 return type;
		 }
		//参数（行政区id集合 ）
		String adminIds = (String) param.get("adminIds");
		//新增商圈
		type = busiAreaDao.addBusiArea(param);
		Integer sqe = (Integer) param.get("id");
		if(type != 0 && sqe != 0){
			String[] adminIdArry = adminIds.split(",");
			for (int i = 0; i < adminIdArry.length; i++) {
				//参数（行政区id、商圈id）
				map.put("adminId", adminIdArry[i]);
				map.put("businessAreaId", sqe);
				//插入商圈和行政区关系
				type = busiAreaDao.addRelation(map);
				if(type==0){
					return type;
				}
			}
		}
		return type;
	}
	/**
	 * 修改商圈
	 * @param param {key:businessAreaId,商圈名:AreaName,区划id:zoningId,行政区id集合:adminIds}
	 * @return Integer (type非等于0 成功，否则失败)
	 * @throws Exception 
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer updateBusiArea(Map<String, Object> param) throws Exception {
		//关系表的参数
				//添加和修改的返回值
				Integer type = 0;
				//判断数据是否存在锁表
				Map<String, Object> map = new HashMap<>();
				map.put("id", param.get("busiAreaId"));
				BusiAreaModel busiArea = busiAreaDao.getBusiAreaById(map);
				if(busiArea==null){
					return type;
				}
				//判断关联行政区是否重复
				String adminIdArray = (String) param.get("adminIds");
				String[] Array = adminIdArray.split(",");
				for (int i = 0; i < Array.length; i++) {
					// 将数组元素依次与后面的数组元素比较  
					for (int j = i + 1; j < Array.length; j++) {
						if (Array[i] == Array[j]) {
							return type;
						}
					}
				}
				//判断名字是否为空或是空格
				 String busiName = (String) param.get("busiName");
				 if(busiName.trim()==null||busiName.trim().equals("")||busiName.trim().equals("undefined")){
					 return type;
				 }
				//判断是否重名
				 String busiAreaId = (String) param.get("busiAreaId");
				 map.put("updataBusiName", busiName);
				 map.put("busiAreaId", busiAreaId);
				 BusiAreaModel busiNameModel = busiAreaDao.getBusiName(map);
				 map.clear();
				 if(busiNameModel!=null){
						 type=-1;
						 return type;
				 }
				//参数（行政区id集合 ）
				String adminIds = (String) param.get("adminIds");
				param.put("businessAreaId", busiAreaId);
				//判断商圈id
				if(busiAreaId!=null){
					//新增商圈
					type = busiAreaDao.updateBusiArea(param);
					if(type != 0){
						map.put("businessAreaId", busiAreaId);
						busiAreaDao.deleteRelation(map);
						map.clear();
						String[] adminIdArry = adminIds.split(",");
						for (int i = 0; i < adminIdArry.length; i++) {
							//参数（行政区id、商圈id）
							map.put("adminId", adminIdArry[i]);
							map.put("businessAreaId", busiAreaId);
							//插入商圈和行政区关系
							type = busiAreaDao.addRelation(map);
							if(type==0){
								return type;
							}
						}
					}
				}
				return type;
	}
	/**
	 * 删除商圈及商圈和行政区关联（一条或多条）
	 * @param map
	 * @return
	 */
	@TM
	public Integer deleteBusiArea(Map<String, Object> map){
		//删除商圈
		map.put("id", map.get("ids"));
		Integer type = busiAreaDao.deleteBusiArea(map);
		 if(type != 0){
				//删除商圈和行政区的关系
			 String ids = (String) map.get("ids");
			 map.clear();
			 map.put("businessAreaId", ids);
			type = busiAreaDao.deleteRelation(map);
		 }
		return type;
	}
	/**
	 * 获取商圈列表分页
	 * @param param {pId:市id，busiZoningID：区划id，及分页参数}
	 * @return PagerResult<BusiAreaModel>
	 * @throws Exception 
	 */
	public PagerResult<BusiAreaModel> getBusiAreaQCPage(Map<String, Object> map) {
		String type = (String) map.get("genre");
		if(type.equals( "busiZoning") ){
			map.put("busiZoning", "is null");
		}else if(type.equals("busiarea")){
			map.put("busiarea", "is not null");
		}
		PagerResult<BusiAreaModel> busiAreaQCPage = busiAreaDao.getBusiAreaQCPage(map);
		Integer count = busiAreaDao.getBusiAreaCount(map);
		busiAreaQCPage.setTotalCount(count);
		return busiAreaQCPage;
	}
	
	/**
	 * 获取区划列表
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getbusiZoningAll(Map<String, Object> map){
		return busiAreaDao.getbusiZoningAll(map);
	}
	
	/**
	 * 获取要修改商圈列表
	 * @return  List<BusiAreaModel>
	 */
	public BusiAreaModel getBusiArea(Map<String, Object> map) {
		return busiAreaDao.getBusiArea(map);
	}/**
	 * 获取商圈名称
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public BusiAreaModel getBusiName(Map<String, Object> map){
		return busiAreaDao.getBusiName(map);
	}
	
	/**
	 * 获取商圈名称
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiNameList(Map<String, Object> map){
		return busiAreaDao.getBusiNameList(map);
	}
	/**
	 * 获取商圈
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getQueryBusiArea(Map<String, Object> map) {
		return busiAreaDao.getQueryBusiArea(map);
	}

	/**
	 * 获取大商圈
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getParentBusiAreaList(Map<String, Object> map) {
		return busiAreaDao.getParentBusiAreaList(map);
	}

	/**
	 * 获取小商圈
	 * @param map
	 * @return  List<BusiAreaModel>
	 */
	public List<BusiAreaModel> getBusiAreaList(Map<String, Object> map) {
		return busiAreaDao.getBusiAreaList(map);
	}
	/**
	 * 根据id获商圈
	 * @param map{id：busiAreaId}
	 * @return BusiAreaModel
	 */
	public BusiAreaModel getBusiAreaById(Map<String, Object> map){
		return busiAreaDao.getBusiAreaById(map);
	}
	
	
	/**
	 * 获取楼盘下的商圈数量
	 * @return integer
	 *map{busiAreaId：商圈id}
	 */
	public Integer getPremisesCount(Map<String, Object> map){
		return busiAreaDao.getPremisesCount(map);
	}
}

