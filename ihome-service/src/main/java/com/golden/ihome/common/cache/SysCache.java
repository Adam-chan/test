package com.golden.ihome.common.cache;

import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.golden.port.framework.cache.ICache;
/**
 * 系统配置缓存服务 
 * 
 * 所有缓存服务必须实现ICache
 */
public class SysCache implements ICache{
	
	private EhCacheCacheManager cacheManager;
	private Cache cache;
	@Override
	public Object get(String key) {
		ValueWrapper valueWrapper = cache.get(key);
		return  valueWrapper!=null ? valueWrapper.get():null;
	}

	@Override
	public void put(String key, Object value) {
		cache.put(key, value);
	}

	@Override
	public List<String> getKeys() {
		return null;
	}
	/**
	 * 删除某个数据
	 * 如果不传任何参数则清空缓存，既所有内容全部删除 
	 */
	@Override
	public void remove(String key) {
		if(key == null || "".equals(key)){
			cache.clear();
		}else{
			cache.evict(key);
		}
	}

	public EhCacheCacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(EhCacheCacheManager cacheManager) {
		this.cacheManager = cacheManager;
		this.cache = this.cacheManager.getCache("sysCacheTemp");
	}
}
