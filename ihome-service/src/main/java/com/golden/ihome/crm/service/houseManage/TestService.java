package com.golden.ihome.crm.service.houseManage;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.golden.ihome.crm.model.PaperModel;
import com.golden.port.framework.aop.Aop;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;
@Service("houseManage/testService")
public class TestService implements IBaseHandler{

	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		PaperModel pm = new PaperModel();
		pm.setContent("ahahha");
		pm.setTempName("临时");
		return  pm;
	}
	@TM
	@Aop(name="scriptAop",type="before")
	public Object test(){
		
		return 1;
	}
}
