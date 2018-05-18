package com.golden.addr.web.controller.premisesManage;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.configs.AihomeConst;
import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author weizhichao 类名称：楼盘管理--楼盘详情Controller 类描述：楼盘的销售指南和资料下载 时间：2016-10-20
 */
@RequestMapping(value = "premisesDetail")
@Controller
public class PremisesDetailController {

	@Resource(name = "addrService")
	private IServiceStore addrService;

	/**
	 * 查詢销售指南
	 * 
	 * @param params
	 * @return
	 */

	@RequestMapping(value = "getSalesGuide")
	public String index(@RequestParam Map<String, Object> map,
			HttpServletRequest request) throws IOException {

		request.setAttribute("id", map.get("id").toString());
		ResultValue result = addrService.access(
				"premisesDetail/premisesDetailService.getSalesGuide", map);
		request.setAttribute("salesGuide", result.getJsonObject());
		if (null == result.getData()) {
			addrService.access(
					"premisesDetail/premisesDetailService.insertPremisesGuide",
					map);
		}

		return "premisesManage/premises_sales_guide";
	}

	/**
	 * 保存销售指南
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "savePremisesGuide",method=RequestMethod.POST)
	public String savePremisesGuide(@RequestParam Map<String, Object> map)
			throws IOException {
		 
		ResultValue result = addrService.access(
				"premisesDetail/premisesDetailService.savePremisesGuide", map);
		return result.getData();
	}

	/**
	 * 下载资料初始化页面
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "fileIndex")
	public String fileIndex(@RequestParam Map<String, Object> map,
			ModelMap model) throws IOException {

		model.addAttribute("premisesId", map.get("id"));

		return "premisesManage/premises_file_download";
	}

	/**
	 * 分页查询下载资料
	 * 
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getFileList")
	public String getFileList(@RequestParam Map<String, Object> map,
			HttpServletRequest request) throws IOException {
		String currentPage = map.get("page").toString();
		String rowCount = map.get("rows").toString();
		map.put("currentPage", currentPage);
		map.put("rowCount", rowCount);
		ResultValue result = addrService.access(
				"premisesDetail/premisesDetailService.getFileList", map);
		return result.getData();
	}

	/**
	 * 上传文件初始化页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toUploadFile")
	public String toAddLayout(@RequestParam Map<String, Object> map,
			HttpServletRequest request) {
		request.setAttribute("premisesId", map.get("premisesId").toString());
		return "premisesManage/add_upload_file";
	}

	/**
	 * 保存上传的文件
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveUploadFile")
	public String saveUploadFile(@RequestParam Map<String, Object> map,HttpSession session) {
		
		String uploadPerson = session.getAttribute(AihomeConst.SESSION_USER_NAME_KEY).toString();
		map.put("uploadPerson", uploadPerson);
		String dataStr = (String) map.get("dataStr");
		if (dataStr == "[]") {
			return "";
		}
		ResultValue result = addrService.access(
				"premisesDetail/premisesDetailService.saveUploadFile", map);
		return result.getData();
	}

	/**
	 * 删除文件
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteFiles")
	public String deleteFiles(@RequestParam("rowIds") String[] rowIds,
			@RequestParam Map<String, Object> map) {
		map.put("rowIds", rowIds);
		ResultValue result = addrService.access(
				"premisesDetail/premisesDetailService.deleteFiles", map);
		return result.getData();
	}

	/**
	 * 批量下载文件
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "downloadFiles")
	public String downloadFiles(@RequestParam("rowIds") String[] rowIds,
			@RequestParam Map<String, Object> map) {
		map.put("rowIds", rowIds);
		ResultValue result = addrService.access(
				"premisesDetail/premisesDetailService.getDownloadFiles", map);
		return result.getData();
	}

}
