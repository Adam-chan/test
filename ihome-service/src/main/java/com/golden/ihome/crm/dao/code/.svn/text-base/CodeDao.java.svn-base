package com.golden.ihome.crm.dao.code;



import java.util.Map;

import org.springframework.stereotype.Repository;

import com.golden.ihome.crm.model.CodeModel;
import com.golden.port.framework.mybatis.IBaseDao;
@Repository(value="codeDao")
public class CodeDao  extends IBaseDao{

	/**
	 * 获取编码
	 * 
	 */
	public CodeModel getCode(String code){
		return this.excutor.queryForObject("code.getCode",code);
	}
	/**
	 * 插入编码
	 * 
	 */
	public Integer updataCode(Map<String, Object> map){
		return this.excutor.update("code.updateCode",map);
	}
	/**
	 * 跟新编码
	 * 
	 */
	public Integer insertCode(Map<String, Object> map){
		return this.excutor.insert("code.insertCode",map);
	}
}
