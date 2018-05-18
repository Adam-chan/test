package com.golden.ihome.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.golden.port.framework.stores.IServiceStore;
import com.golden.port.framework.stores.results.ResultValue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/ApplicationContext.xml"})
public class BaseTest {
	
	public Map<String,Object> param = new HashMap<String,Object>();
	
	@Autowired
    protected ApplicationContext applicationContext;
	@Autowired
	private IServiceStore serviceStore;
	
	public ResultValue process(String path, Map<String,Object> param){
		return serviceStore.access(path, param);
	}
	
	public <T> T getBean(Class<T> className){
		 return applicationContext.getBean(className);
	}
}
