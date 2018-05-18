package com.golden.ihome.addr.service.dist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.dist.AddrDistDao;
import com.golden.ihome.addr.model.DistModel;
import com.golden.ihome.utils.DateUtil;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.pages.PagerResult;
import com.golden.port.framework.transaction.TM;

@Service("addrDist/addrDistService")
public class AddrDistService implements IBaseHandler{

	@Autowired
	private AddrDistDao addrDistDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 道路
	 */
	public List<Map<String, Object>> getRoadList(Map<String, Object> map) {
		return addrDistDao.getRoadList(map);
	}

	/**
	 * 楼盘
	 */
	public List<Map<String, Object>> getPremisesListByMatch(Map<String, Object> map) {
		return addrDistDao.getPremisesListByMatch(map);
	}

	/**
	 * 楼栋分组
	 */
	public List<Map<String, Object>> getGroup(Map<String, Object> map) {
		return addrDistDao.getGroup(map);
	}

	/**
	 * 楼栋
	 */
	public List<Map<String, Object>> getBuilding(Map<String, Object> map) {
		return addrDistDao.getBuilding(map);
	}

	/**
	 * 单元/商铺
	 */
	public List<Map<String, Object>> getUnit(Map<String, Object> map) {
		return addrDistDao.getUnit(map);
	}

	/**
	 * 地址库列表分页
	 */
	public PagerResult<DistModel> getSaleAddrDistList(Map<String, Object> map) {
		return addrDistDao.getSaleAddrDistList(map);
	}

	/**
	 * 原分配人
	 */
	public Object getSaleAssignment(Map<String, Object> map) {
		if("1".equals(map.get("dataType"))) {
			map.put("dataId", map.get("dataPremisesId"));
		} else if("2".equals(map.get("dataType"))) {
			map.put("dataId", map.get("dataGroupId"));
		} else if("3".equals(map.get("dataType"))) {
			map.put("dataId", map.get("dataBuildingId"));
		} else {
			map.put("dataId", map.get("dataUnitId"));
		}
		Map<String, Object> assignmentMap = new HashMap<String, Object>();
		Map<String, Object> oldAssignment = addrDistDao.oldSaleAssignment(map);
		if(oldAssignment != null) {
			assignmentMap.putAll(oldAssignment);
		}
		if(!"1".equals(map.get("dataType"))) {
			String lastOrg = addrDistDao.lastSaleOrg(map);
			assignmentMap.put("LASTASSIGNMENT", lastOrg);
		}
		if(!"4".equals(map.get("dataType")) && !"6".equals(map.get("dataType"))) {
			String nextAssignment = addrDistDao.nextSaleAssignment(map);
			assignmentMap.put("NEXTASSIGNMENT", nextAssignment);
		}
		return assignmentMap;
	}

	/**
	 * 添加分配
	 */
	@TM
	public Integer addSaleAssignment(Map<String, Object> map) {
		if(map.get("orgCode") != null && map.get("lastAssignment") != null && !map.get("orgCode").toString().startsWith(map.get("lastAssignment").toString())) {
			return 2;
		}
		if("1".equals(map.get("dataType"))) {
			map.put("dataId", map.get("premisesId"));
		} else if("2".equals(map.get("dataType"))) {
			map.put("dataId", map.get("groupId"));
		} else if("3".equals(map.get("dataType"))) {
			map.put("dataId", map.get("buildingId"));
		} else {
			map.put("dataId", map.get("unitId"));
		}
		map.put("operateDate", DateUtil.getDateByLong(System.currentTimeMillis()));
		if("".equals(map.get("dutySaleId"))) {
			addrDistDao.addSaleAssignment(map);
		} else {
			addrDistDao.updateSaleAssignment(map);
		}
		if(!"".equals(map.get("nextAssignment")) && !"0".equals(map.get("nextAssignment"))) {
			addrDistDao.deleteSaleAssignment(map);
		}
		if("2".equals(map.get("updateFlag"))) {
			addrDistDao.addAndUpdateSaleAssignment(map);
		}
		return 0;
	}

	/**
	 * 地址库列表分页
	 */
	public PagerResult<DistModel> getLeaseAddrDistList(Map<String, Object> map) {
		return addrDistDao.getLeaseAddrDistList(map);
	}

	/**
	 * 原分配人
	 */
	public Object getLeaseAssignment(Map<String, Object> map) {
		if("1".equals(map.get("dataType"))) {
			map.put("dataId", map.get("dataPremisesId"));
		} else if("2".equals(map.get("dataType"))) {
			map.put("dataId", map.get("dataGroupId"));
		} else if("3".equals(map.get("dataType"))) {
			map.put("dataId", map.get("dataBuildingId"));
		} else {
			map.put("dataId", map.get("dataUnitId"));
		}
		Map<String, Object> assignmentMap = new HashMap<String, Object>();
		Map<String, Object> oldAssignment = addrDistDao.oldLeaseAssignment(map);
		if(oldAssignment != null) {
			assignmentMap.putAll(oldAssignment);
		}
		if(!"1".equals(map.get("dataType"))) {
			String lastOrg = addrDistDao.lastLeaseOrg(map);
			assignmentMap.put("LASTASSIGNMENT", lastOrg);
		}
		if(!"4".equals(map.get("dataType")) && !"6".equals(map.get("dataType"))) {
			String nextAssignment = addrDistDao.nextLeaseAssignment(map);
			assignmentMap.put("NEXTASSIGNMENT", nextAssignment);
		}
		return assignmentMap;
	}

	/**
	 * 添加分配
	 */
	@TM
	public Integer addLeaseAssignment(Map<String, Object> map) {
		if(map.get("orgCode") != null && map.get("lastAssignment") != null && !map.get("orgCode").toString().startsWith(map.get("lastAssignment").toString())) {
			return 2;
		}
		if("1".equals(map.get("dataType"))) {
			map.put("dataId", map.get("premisesId"));
		} else if("2".equals(map.get("dataType"))) {
			map.put("dataId", map.get("groupId"));
		} else if("3".equals(map.get("dataType"))) {
			map.put("dataId", map.get("buildingId"));
		} else {
			map.put("dataId", map.get("unitId"));
		}
		map.put("operateDate", DateUtil.getDateByLong(System.currentTimeMillis()));
		if("".equals(map.get("dutyLeaseId"))) {
			addrDistDao.addLeaseAssignment(map);
		} else {
			addrDistDao.updateLeaseAssignment(map);
		}
		if(!"0".equals(map.get("nextAssignment"))) {
			addrDistDao.deleteLeaseAssignment(map);
		}
		if("2".equals(map.get("updateFlag"))) {
			addrDistDao.addAndUpdateLeaseAssignment(map);
		}
		return 0;
	}
}
