package com.golden.ihome.addr.service.traffic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.traffic.AroundLineDao;
import com.golden.ihome.addr.dao.traffic.AroundSiteDao;
import com.golden.ihome.addr.model.AroundSiteLineModel;
import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;

@Service("traffic/aroundSiteService")
public class AroundSiteService implements IBaseHandler{

	public static Logger logger = LoggerFactory.getLogger(AroundSiteService.class);
	
	@Autowired
	private AroundSiteDao aroundSiteDao;
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
	public PagerResult<AroundSiteModel> getSiteListForPage(Map<String,Object> map){
		return aroundSiteDao.getSiteListForPage(map);
	}
	/**
	 * 查询所有站点信息
	 * @param map
	 * @return
	 */
	public List<AroundSiteModel> getSiteList(){
		return aroundSiteDao.getSiteList();
	}
	/**
	 * 模糊匹配站点信息
	 * @param map
	 * @return
	 */
	public List<AroundSiteModel> getSiteListByMatch(Map<String,Object> map){
		return aroundSiteDao.getSiteListByMatch(map);
	}
	/**
	 * 查询站点名称是否存在
	 * @param map
	 * @return
	 */
	public Integer getSiteByNameIs(Map<String,Object> map){
		return Integer.parseInt(aroundSiteDao.getSiteByNameIs(map).toString());
	}
	/**
	 * 根据id查询站点
	 * @param map
	 * @return
	 */
	public AroundSiteModel getSiteById(Map<String,Object> map){
		List<AroundSiteModel> list = aroundSiteDao.getSiteById(map);
		AroundSiteModel site = new AroundSiteModel();
		if(list.size()>0){
			site = list.get(0);
		}
		return site;
	}
	/**
	 * 新增站点信息
	 * @param map
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	public Integer insertSite(Map<String, Object> map){
		 AroundSiteModel site = new AroundSiteModel();
		 site.setSiteName(map.get("siteName").toString());
		 site.setTrafficType(Integer.parseInt(map.get("trafficType").toString()));
		 site.setAssistSign(map.get("assistSign").toString());
		 site.setCloseSite(map.get("closeSite").toString());
		 aroundSiteDao.insertSite(site);
		 map.put("siteId", site.getId()-1);
		 //保存站点和线路的关联关系
		 Integer result = insertSiteLineContact(map);
		 return result;
	}
	/**
	 * 修改站点信息
	 * @param map
	 * @return
	 */
	@Aop(name="scriptAop",type="before")
	public Integer updateSite(Map<String, Object> map){
		aroundSiteDao.updateSite(map);
		map.put("siteId", map.get("id"));
		//删除已关联的线路关联关系
		List<AroundSiteLineModel> list = aroundSiteDao.getSiteLineListBySiteId(map);
		StringBuilder sb = new StringBuilder();
		if(!list.isEmpty()){
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i)!=null){
					if(i<list.size()-1){
						sb.append(list.get(i).getId()).append(",");
					}else{
						sb.append(list.get(i).getId());
					}
				}
			}
		}
		Map<String, Object> idsMap = new HashMap<String, Object>();
		idsMap.put("ids", sb.toString());
		if(idsMap.get("ids")!=null && !idsMap.get("ids").equals("")){
			aroundSiteDao.deleteSiteLines(idsMap);
		}
		//保存站点和线路的关联关系
		Integer result = insertSiteLineContact(map);
		return result;
	}
	/**
	 * 根据id删除站点信息
	 * @param map
	 * @return
	 */
	public Integer deleteSiteById(Map<String, Object> map){
		return aroundSiteDao.deleteSiteById(map);
	}
	/**
	 * 批量删除站点信息
	 * @param map
	 * @return
	 */
	public Integer deleteSites(Map<String, Object> map){
		return aroundSiteDao.deleteSites(map);
	}
	/**
	 * 批量保存站点和线路关联关系
	 * @param map(siteId,lineId的拼接字符串)
	 * @return
	 */
	public Integer insertSiteLineContact(Map<String, Object> map){
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String lineIdStr = map.get("lineIdStr").toString();
		String lineIds[] = lineIdStr.split(",");
		if(lineIds.length>0){
			paramsMap.put("siteId", map.get("siteId"));
			paramsMap.put("lineIds", lineIds);
			Integer result = aroundSiteDao.insertSiteLineContact(paramsMap);
			if(result>0){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 1;
		}
	}

}