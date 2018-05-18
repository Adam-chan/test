package com.golden.ihome.addr.dao.baseBuilding;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.BaseBuildingModel;
import com.golden.ihome.addr.model.BasePremisesModel;
import com.golden.ihome.addr.model.PremisesMenuModel;
import com.golden.port.framework.mybatis.IBaseDao;

/**
 * @author lza
 * 类名称：楼栋管理Dao
 * 类描述：针对楼栋表的数据访问
 * 日          期：2016-10-17
 */
@Repository(value="baseBuildingDao")
public class BaseBuildingDao extends IBaseDao{
	
	/**
	 * 根据id获取一条楼栋数据
	 * @param param{BaseBuildingId：id}
	 * @return BaseBuildingModel
	 */
	public BaseBuildingModel getBaseBuilding(Map<String,Object> param){
		return this.excutor.queryForObject("BaseBuilding.getBaseBuilding", param);
	}
	
	/**
	 * 根据楼盘id获取多条楼栋数据
	 * @param param{BaseBuildingId：id}
	 * @return BaseBuildingModel
	 */
	public List<Object> getBaseBuildingList(Map<String,Object> param){
		return this.excutor.queryForList("BaseBuilding.getBaseBuildingList", param);
	}

	/**
	 * 根据 楼盘id,分组id,编号范围 查询楼栋实体
	 * @param param{BaseBuildingId：id}
	 * @return BaseBuildingModel
	 */
	public Integer hasBaseBuilding(Map<String,Object> param){
		return this.excutor.queryForObject("BaseBuilding.hasBaseBuilding", param);
	}

	/**
	 * 批量插入楼栋
	 * @param param{BaseBuildingId：id}
	 * @return BaseBuildingModel
	 */
	public Integer insertBatch(Map<String,Object> param){
		return this.excutor.insert("BaseBuilding.insertBatch", param);
	}
	
	/**
	 * 根据id更新楼栋实体
	 * @param param{BaseBuildingId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer updateBaseBuilding(Map<String,Object> param){
		return this.excutor.update("BaseBuilding.updateSelective", param);
	}
	
	/**
	 * 根据分组id给楼栋表里的分组id赋值为null
	 * @param param{BaseBuildingId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer isGroupIdNull(Map<String,Object> param){
		return this.excutor.update("BaseBuilding.isGroupIdNull", param);
	}
	/**
	 * 根据id删除楼栋实体
	 * @param param{BaseBuildingId：id}
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer deleteBaseBuilding(Map<String,Object> param){
		return this.excutor.delete("BaseBuilding.deleteBaseBuilding", param);
	}
	
	/**
	 * 可选择添加字段的新增一条楼栋数据
	 * @param param 实体的所有属性
	 * @return Integer(大于0成功，小于0不成功)
	 */
	public Integer insertSelective(Map<String,Object> param){
		return this.excutor.insert("BaseBuilding.insertSelective", param);
	}
	/**
	 * 新增单条栋座信息 dl
	 * @param map
	 * @return
	 */
	public Integer insertOneBaseBuilding(Map<String, Object> map) {
		return this.excutor.insert("BaseBuilding.insertOneBaseBuilding",map);
	}
	/**
	 * 校验栋座是否被引用 dl
	 * @param map
	 * @return
	 */
	public Integer isQuotedWithBuilding(Map<String, Object> map) {
		return this.excutor.queryForObject("BaseBuilding.isQuotedWithBuilding", map);
	}
	
	/**
	 * 根据分组id获取楼栋个数
	 * @param param{groupId：楼栋分组id}
	 * @return Integer
	 */
	public Integer getBaseBuildingNum(Map<String,Object> param){
		return this.excutor.queryForObject("BaseBuilding.getBaseBuildingNum", param);
	}
	/**
	 * 根据楼盘id获取楼盘数据
	 * @param param{premisesId：楼盘id}
	 * @return BasePremisesModel
	 */
	public BasePremisesModel getpremises(Map<String,Object> param){
		return this.excutor.queryForObject("BaseBuilding.getpremises", param);
	}
	/**
	 * 根据楼盘id获取楼盘数据
	 * @param param{premisesId：楼盘id}
	 * @return BasePremisesModel
	 */
	public List<PremisesMenuModel> getBuildingMenu(Map<String,Object> param){
		return this.excutor.queryForList("BaseBuilding.getBuildingMenu", param);
	}

}
