package com.golden.ihome.addr.service.traffic;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.traffic.AroundLineDao;
import com.golden.ihome.addr.model.AroundLineModel;
import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.ihome.addr.service.road.RoadService;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

@Service("traffic/aroundLineService")
public class AroundLineService implements IBaseHandler{

	public static Logger logger = LoggerFactory.getLogger(RoadService.class);
	
	@Autowired
	private AroundLineDao aroundLineDao;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 分页查询站点信息
	 * @param map
	 * @return
	 */
	public PagerResult<AroundLineModel> getLineListForPage(Map<String,Object> map){
		return aroundLineDao.getLineListForPage(map);
	}
	/**
	 * 新增线路信息
	 * @param map
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	public Integer insertLine(Map<String, Object> map){
		return aroundLineDao.insertLine(map);
	}
	/**
	 * 根据id查询线路
	 * @param map
	 * @return
	 */
	public AroundLineModel getLineById(Map<String,Object> map){
		List<AroundLineModel> list = aroundLineDao.getLineById(map);
		AroundLineModel line = new AroundLineModel();
		if(list.size()>0){
			line = list.get(0);
		}
		return line;
	}
	/**
	 * 根据id删除站点信息
	 * @param map
	 * @return
	 */
	public Integer deleteLineById(Map<String, Object> map){
		return aroundLineDao.deleteLineById(map);
	}
	/**
	 * 根据id修改线路信息
	 * @param map
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	public Integer updateLineById(Map<String, Object> map){
		return aroundLineDao.updateLineById(map);
	}
	/**
	 * 批量删除线路信息
	 * @param map,map参数(key："lineIds",value:"id拼接字符串")
	 * @return
	 */
	public Integer deleteLines(Map<String, Object> map){
		return aroundLineDao.deleteLines(map);
	}
	/**
	 * 根据站点id查询所有关联线路信息
	 * @param map
	 * @return
	 */
	public List<AroundLineModel> getLinesBySiteId(Map<String,Object> map){
		List<AroundLineModel> list =  aroundLineDao.getLinesBySiteId(map);
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i)==null){
					list.remove(i);
				}
			}
		}
		return list;
	}
	/**
	 * 查询所有线路信息
	 * @param map
	 * @return
	 */
	public List<AroundLineModel> getLineList(Map<String,Object> map){
		return aroundLineDao.getLineList(map);
	}
	/**
	 * 查询站点名称是否存在
	 * @param map
	 * @return
	 */
	public Integer getLineByNameIs(Map<String,Object> map){
		List<AroundSiteModel> list = aroundLineDao.getLineByNameIs(map);
		if(list.size()>0){
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 * 模糊匹配线路信息
	 * @param map
	 * @return
	 */
	public List<AroundLineModel> getLineListByMatch(Map<String,Object> map){
		return aroundLineDao.getLineListByMatch(map);
	}
	/**
	 * 根据线路名称查询线路
	 * @param map
	 * @return
	 */
	public List<AroundLineModel> getLineByLineName(Map<String,Object> map){
		return aroundLineDao.getLineByLineName(map);
	}

}
