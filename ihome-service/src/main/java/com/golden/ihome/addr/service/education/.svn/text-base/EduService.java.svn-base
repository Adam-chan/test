package com.golden.ihome.addr.service.education;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.education.EduDao;
import com.golden.ihome.addr.model.AroundEduImgModel;
import com.golden.ihome.addr.model.EduFacilityModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;

@Service("education/EduService")
public class EduService implements IBaseHandler{

	public static Logger logger = LoggerFactory.getLogger(EduService.class);
	
	@Autowired
	private EduDao eduDao;
	/**
	 * 分页查询教育设施
	 * @param params
	 * @return
	 */
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		return eduDao.getEduPage(param);
	}
	/**
	 * 编辑教育信息(新增、修改)
	 * @param map
	 * @return
	 */
	@TM
	@Aop(name="scriptAop",type="before")
	public Integer editEdu(Map<String, Object> map){
		String editType = map.get("num").toString();
		String folderName = map.get("folderNames").toString();
		String fileName = map.get("fileNames").toString();
		String imgEmpty = map.get("imgEmpty").toString();
		String eduId = map.get("eduId").toString();
		int result=1;
		if(editType.equals("1")){//保存
			map.put("status",1);
			Integer saveResult = eduDao.insertEdu(map);
			if(saveResult==1){
				if(folderName!=null&&fileName!=null){
					String[] folderNameStr = folderName.split(",");
					String[] fileNameStr = fileName.split(",");
					AroundEduImgModel areaEduImg;
					List<AroundEduImgModel> list = new ArrayList<AroundEduImgModel>();
					for (int i = 0; i < fileNameStr.length; i++) {
						areaEduImg = new AroundEduImgModel();
						areaEduImg.setFolderName(folderNameStr[i]);
						areaEduImg.setFileName(fileNameStr[i]);
						list.add(areaEduImg);
					}
					map.put("file",list);
					String newEduId = map.get("newEduId").toString();
					int newEduIdInt = Integer.parseInt(newEduId);
					int eduNewId = newEduIdInt+1;
					map.put("eduNewId", eduNewId);
					map.put("createTime", DateUtil.getDateByLong(System.currentTimeMillis()));
					eduDao.insertEduImg(map);
				}
				return result;
			}
		}else{//更新
			if(!"".equals(folderName)&&!"".equals(fileName)){
				String[] folderNameStr = folderName.split(",");
				String[] fileNameStr = fileName.split(",");
				AroundEduImgModel areaEduImg;
				List<AroundEduImgModel> list = new ArrayList<AroundEduImgModel>();
				for (int i = 0; i < fileNameStr.length; i++) {
					areaEduImg = new AroundEduImgModel();
					areaEduImg.setFolderName(folderNameStr[i]);
					areaEduImg.setFileName(fileNameStr[i]);
					list.add(areaEduImg);
				}
				map.put("file",list);
				map.put("createTime", DateUtil.getDateByLong(System.currentTimeMillis()));
				if(imgEmpty==null||imgEmpty.equals("")){//更新中的新增
					map.put("eduNewId", eduId);
					eduDao.insertEduImg(map);
				}else{
					eduDao.deleteEduImg(map);
					map.put("eduNewId", eduId);
					eduDao.insertEduImg(map);
					Integer updateResult = eduDao.updateEduInfo(map);
					if(updateResult==0){
						return 2;//操作失败
					}
				}
			}else{
				map.put("eduNewId", eduId);
				eduDao.deleteEduImg(map);
				Integer updateResult = eduDao.updateEduInfo(map);
				if(updateResult==0){
					return 2;//操作失败
				}
			}
			
		}
		return result;
	}
	/**
	 * 模糊匹配 教育设施名字
	 * @param String eduId 教育设施ID   matchStr 模糊教育设施名字
	 * @return List<EduFacilityModel>
	 */
	public List<EduFacilityModel> geteduNameByMatch(Map<String, Object> param){
		 List<EduFacilityModel> geteduNameByMatch = eduDao.geteduNameByMatch(param);
		 for(EduFacilityModel item : geteduNameByMatch){
			 String eduName = item.getEduName();
			 String eduTypeStr = item.getEduTypeStr();
			 item.setAllEduName(eduName+" ……… "+eduTypeStr);
		 }
		 return geteduNameByMatch;
	}
	/**
	 * 逻辑删除教育设施
	 * @param map
	 * @return
	 */
	@TM
	public Integer updateEduStatus(Map<String, Object> map){
		map.put("eduStatus", 2);
		return eduDao.updateEduInfo(map);
	}
	/**
	 * 教育设施对口学校
	 * @param map 
	 * @return EduFacilityModel
	 */
	public Map<String,Object> getEduAllInfoList(Map<String, Object> map){
		Map<String,Object> parame = new HashMap<String,Object>();
		EduFacilityModel eduInfo = eduDao.getEduInfo(map);
		String counterpartsPrimary = eduInfo.getCounterpartsPrimary();
		if(counterpartsPrimary!=null){//对口小学
			String[] counterpartsPrimaryArry = counterpartsPrimary.split(",");
			parame.put("counterpartsPrimaryArry", counterpartsPrimaryArry);
			parame.put("counterpartstype", 1);
		}
		String counterpartsMiddle = eduInfo.getCounterpartsMiddle();
		if(counterpartsMiddle!=null){//对口中学
			String[] counterpartsMiddleArry = counterpartsMiddle.split(",");
			parame.put("counterpartsMiddleArry", counterpartsMiddleArry);
			parame.put("counterpartstype", 2);
		}
		return parame;
	}
	/**
	 * 教育设施全部信息
	 * @param map 
	 * @return EduFacilityModel
	 */
	public EduFacilityModel getEduAllInfo(Map<String, Object> map){
		return	 eduDao.getEduInfo(map);
	}
	/**
	 * 教育设施图片
	 * @param map 
	 * @return List<AreaEduImgModel>
	 */
	public Map<String,Object> getEduImgList(Map<String, Object> map){
		List<AroundEduImgModel> aroundEduImgList = eduDao.getEduImgList(map);
		String allStr = "";
		for(AroundEduImgModel item:aroundEduImgList){
			if(item.getFolderName()==null)continue;
			String folderName = item.getFolderName();
			String fileName = item.getFileName();
			allStr+=folderName+"/"+fileName+",";
		}
		map.clear();
		map.put("aroundEduImgList", aroundEduImgList);
		map.put("allStr", allStr.substring(0, allStr.length()-1));
		return map;
	}
	/**
	 * 教育设施名字和地址验证
	 * @param map 
	 * @return Integer
	 */
	@TM
	public Integer getEduInfo(Map<String, Object> param){
		int result = 1;
		String eduName = param.get("eduName").toString();
			EduFacilityModel eduInfo = eduDao.getEduInfo(param);
			if(eduInfo!=null){
				if(eduInfo.getEduName().equals(eduName)){
					return result = 2; //该名字存在 
				}
			}
		return result; //验证成功
	}
}
