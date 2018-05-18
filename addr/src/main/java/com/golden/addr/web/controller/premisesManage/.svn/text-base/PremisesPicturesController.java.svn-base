package com.golden.addr.web.controller.premisesManage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author weizhichao 
 * 类名称：楼盘管理--楼盘详情--楼盘图片Controller 
 * 类描述：楼盘图片
 * 时间：2016-10-24
 */
@RequestMapping(value = "premisesPictures")
@Controller
public class PremisesPicturesController {
	
	@Resource(name = "addrService")
	private IServiceStore addrService;

	/**
	 * 楼盘图片初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "pictureIndex")
	public String pictureIndex(@RequestParam Map<String, Object> map,
			ModelMap model) throws IOException {

		model.addAttribute("premisesId", map.get("id"));
		ResultValue result = addrService.access("premisesPictures/premisesPicturesService",map);
		model.addAttribute("sysHouseLPTPFLList", result.getJsonArray());
		return "premisesManage/premises_picture_index";
	}
	
	/**
	 * 分页查询楼盘图片
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPremisesPicturesPage")
	public String getPremisesPicturesPage(@RequestParam Map<String,Object> map) throws IOException {
		
		ResultValue result = addrService.access("premisesPictures/premisesPicturesService.getPremisesPicturesPage",map);
		return result.getData();
	}
	
	/**
	 * 根据图片类型分页查询楼盘图片
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getGroupsByPicType")
	public String getGroupsByPicType(@RequestParam Map<String,Object> map) throws IOException {

		ResultValue result = addrService.access("premisesPictures/premisesPicturesService.getGroupsByPicType",map);
		return result.getData();
	}
	
	/**
	 * 上传图片初始化页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "uploadPicture")
	public String uploadPicture(@RequestParam Map<String, Object> map) {
		
		return "premisesManage/add_upload_picture";
	}
	
	/**
	 * 保存上传的图片
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveUploadPicture")
	public String saveUploadFile(@RequestParam Map<String, Object> map) {
		String dataStr = (String) map.get("dataStr");
		if (dataStr == "[]") {
			return "";
		}
		ResultValue result = addrService.access(
				"premisesPictures/premisesPicturesService.saveUploadPicture", map);
		return result.getData();
	}

	/**
	 * 删除图片
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deletePicture")
	public String deletePicture(@RequestParam("idList") ArrayList<String> idList,@RequestParam Map<String, Object> map) {
		map.put("idList", idList);
		ResultValue result = addrService.access("premisesPictures/premisesPicturesService.deletePicture", map);
		return result.getData();
	}
	
	/**
	 * 设置代表图片
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "setRepresentPic")
	public String setRepresentPic(@RequestParam("idList") ArrayList<String> idList,@RequestParam Map<String, Object> map) {
		
		String id = idList.get(0);
		map.put("id", id);
		
		ResultValue result = addrService.access("premisesPictures/premisesPicturesService.setRepresentPic", map);
		return result.getData();
	}
	
}
