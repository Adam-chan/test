package com.golden.ihome.common.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.common.CodeConst;
import com.golden.ihome.crm.dao.code.CodeDao;
import com.golden.ihome.crm.model.CodeModel;
/**
 * 编号生成服务 
 */
@Service(value = "commonCode")
public class CommonCode{

	public static Logger logger = LoggerFactory.getLogger(CommonCode.class);
	
	@Autowired
	private CodeDao codeDao;
	
	public final String codeNum = CodeConst.CODE_NUM;
	/**
	 * 获取单号编码
	 * @param codeType 编码类型
	 * @return
	 * @throws Exception 
	 */
	public String getCode(String codeType) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		String code = "";
		if(codeType!=null && !codeType.equals("")){
			CodeModel codeModel = codeDao.getCode(codeType);
			if(codeModel != null){
				code = compare(codeModel, codeType);
				map.put("code", code);
				map.put("id", codeModel.getId());
				map.put("codeType", codeType);
				//更新语句
				logger.info("更新编号："+code+"，更新主键："+codeModel.getId()+",更新类型："+codeType);
				Integer type = codeDao.updataCode(map);
				codeType+=code;
				if(type==0){
					logger.error("编号回写失败："+codeType);
					throw new Exception();
				}		
			}else{
				code = createCode(codeType);
				map.put("code", code);
				map.put("codeType", codeType);
				logger.info("编号回写："+code+",插入类型："+codeType);
				//插入语句
				Integer type = codeDao.insertCode(map);
				codeType+=code;
				if(type==0){
					logger.error("编号回写失败："+codeType);
					throw new Exception();
				}
		}

		}
		return codeType;	
	}
	/**
	 * 创建code
	 * @param codeType 创建code的类型
	 * @return
	 */
	public String createCode(String codeType) {
		String code = "";
		String dateStr = "";
		dateStr = getDate();
		code=dateStr+codeNum;
		return code ;
	}
	/**
	 * 获取当前日期 
	 */
	private String getDate(){
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CodeConst.CODE_TIME);
		return  simpleDateFormat.format(date);
	}
	
	/**
	 * 创建code
	 * @param codeType 创建code的类型
	 * @return
	 */
	public String compare(CodeModel codeModel,String codeType) {
		String code = "";
		String codeNumber = codeModel.getCodeNumber();
		//获取数据库codeNumber字段里日期
		String dataCode = codeNumber.substring(0, codeNumber.length()-codeNum.length());
		//获取当前日期
		String dateStr = getDate();
		//判断日期是否相同
		if(dataCode.equals(dateStr)){
			String str = codeNumber.substring(codeNumber.length()-codeNum.length(), codeNumber.length());
			int num = Integer.parseInt(str);
			num+=1;
			String newNum = "";
			for (int i = String.valueOf(num).length(); i < str.length(); i++) {
				newNum+="0";
			}
			newNum+=num;
			code= dateStr+newNum;
		}else{
			 code = createCode(codeType);
		}
		return code;
	}
}
