package com.golden.addr.web.controller.buildingUnit;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;

/**
 * @author Administrator 单元添加
 */

@Controller
@RequestMapping("buildingUnit")
public class BuildingUnitController {

	@Resource(name = "addrService")
	private IServiceStore addrService;

	/**
	 * @author Administrator return 单元添加html
	 */
	@RequestMapping("index")
	public String selectRoom() {
		return "building/buildingUnit";
	}

	@ResponseBody
	@RequestMapping("addRoom")
	public String creatRoom(@RequestParam Map<String, Object> params) {
		
		ResultValue result = addrService.access("buildingUnits/buildingUnitsService.insertBatch", params);
		return result.getData();
	}

}
