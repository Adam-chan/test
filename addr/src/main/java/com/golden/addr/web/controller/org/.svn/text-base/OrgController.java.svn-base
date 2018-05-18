package com.golden.addr.web.controller.org;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.aihome.OAService;
/**
 * 获取组织结构 
 */
@Controller
@RequestMapping(value = "org")
public class OrgController {
	
	@Resource(name="oaService")
	private OAService oaService;
	
	/**
	 * ajax获取下一级组织结构列表
	 * 参数：orgCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "orgList")
	public String orgList(String orgCode){
		return oaService.getOrgListStr(orgCode);
	}
	/**
	 * 传递组的编号，获取经纪人列表
	 */
	@ResponseBody
	@RequestMapping(value = "userList")
	public String userList(String orgCode){
		return oaService.getOrgUserListStr(orgCode);
	}
}
