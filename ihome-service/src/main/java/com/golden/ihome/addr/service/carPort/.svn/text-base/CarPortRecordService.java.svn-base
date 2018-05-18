package com.golden.ihome.addr.service.carPort;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.carPort.CarPortRecordDao;
import com.golden.ihome.addr.model.CarPortRecordModel;
import com.golden.port.framework.handleable.IBaseHandler;
/**
 * 车位信息
 * @author dl
 *
 */
@Service("carPortRecord/carPortRecordService")
public class CarPortRecordService implements IBaseHandler{
	
	@Autowired
	private CarPortRecordDao carPortRecordDao;

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 添加车位跟进记录
	 * @param map
	 * @return
	 */
	public Integer insertCarPortRecord(Map<String, Object> map){
		map.put("operater", map.get("userName").toString());//注：取当前登陆人姓名
		return carPortRecordDao.insertCarPortRecord(map);
	}
	/**
	 * 根据车位id查询车位跟进记录list
	 * @param map
	 * @return
	 */
	public List<CarPortRecordModel> getCarPortRecordListById(Map<String,Object> map){
		return carPortRecordDao.getCarPortRecordListById(map);
	}
	
}
