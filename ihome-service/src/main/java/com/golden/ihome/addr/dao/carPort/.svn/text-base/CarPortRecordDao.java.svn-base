package com.golden.ihome.addr.dao.carPort;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.addr.model.CarPortRecordModel;
import com.golden.port.framework.mybatis.IBaseDao;
/**
 * @author dl
 * 类名称：车位跟进记录信息dao
 * 时间：2016-10-19
 */
@Repository(value="carPortRecordDao")
public class CarPortRecordDao extends IBaseDao{

	public Integer insertCarPortRecord(Map<String, Object> map) {
		return this.excutor.insert("carPortRecord.insertCarPortRecord", map);
	}

	public List<CarPortRecordModel> getCarPortRecordListById(Map<String, Object> map) {
		return this.excutor.queryForList("carPortRecord.getCarPortRecordListById", map);
	}

}
