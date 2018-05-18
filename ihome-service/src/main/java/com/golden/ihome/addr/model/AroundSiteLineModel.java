package com.golden.ihome.addr.model;

import java.io.Serializable;
/**
 * 公共交通-站点和线路关联关系
 * @author dl
 *
 */
public class AroundSiteLineModel implements Serializable{

	private static final long serialVersionUID = 4406677309191175616L;
	
	private Integer id;
	private Integer siteId;
	private Integer lineId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public Integer getLineId() {
		return lineId;
	}
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

}
