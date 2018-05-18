package com.golden.ihome.crm.service.paper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.crm.dao.paper.PaperDao;
import com.golden.ihome.crm.model.PaperModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;
/***
 * 房源纸服务
 * @author zhr 
 * 
 */
@Service("paper/paperService")
public class PaperService implements IBaseHandler{

	@Autowired
	private PaperDao paperDao;
	/**
	 * 房源纸列表分页查询 
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return paperDao.getPaperListPage(param);
	}
	/**
	 * 保存模板
	 * @return 1成功，2模板已存在
	 */
	@TM
	public Integer save(Map<String, Object> param){
		String content = param.get("content").toString();
		Integer houseNum = content.split("\\[更多房源\\]").length;
		Map<String,String> tempMap = new HashMap<String,String>();
		tempMap.put("tempName", param.get("tempName").toString());
		PaperModel paperTemp = paperDao.getPaperTemp(tempMap);
		if(paperTemp!=null){
			return 2;//模板已存在
		}
		param.put("houseNum", houseNum);
		return paperDao.insertPaperTemp(param);
	}
	/**
	 * 修改模板 
	 */
	@TM
	public Integer updateTemp(Map<String, Object> param){
		String paperId = param.get("paperId").toString();
		//判断该ID以外的模板名称是否与之相同
		Map<String,Object> tempMap = new HashMap<String,Object>();
		tempMap.put("tempName", param.get("tempName").toString());
		tempMap.put("paperId", paperId);
		Integer count = paperDao.getPaperCountOfName(tempMap);
		if(count > 0){
			return 2;//模板已存在
		}
		String content = param.get("content").toString();
		Integer houseNum = content.split("\\[更多房源\\]").length;
		param.put("houseNum", houseNum);
		return paperDao.updatePaperTemp(param);
	}
	/**
	 * 修改模板 
	 */
	@TM
	public Integer updatePaperStatus(Map<String, Object> param){
		return paperDao.updatePaperStatus(param);
	}
	
}
