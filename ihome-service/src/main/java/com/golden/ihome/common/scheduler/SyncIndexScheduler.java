package com.golden.ihome.common.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.golden.ihome.addr.dao.ctxdll.RoomAddrDao;

/**
 * spring 定时器
 * 优化道路和房间的索引碎片 
 * 每天午夜执行，详见scheduler.xml
 * @author zhr
 */
@Component("syncIndexScheduler")
public class SyncIndexScheduler {
	
	@Autowired
	private RoomAddrDao roomAddrDao;
	
	public void syncIndex(){
		//优化房间索引碎片
		roomAddrDao.houseOptimizeIndex();
		//优化道路索引碎片
		roomAddrDao.roadOptimizeIndex();
	}
}
