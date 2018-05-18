package com.golden.ihome.addr.model;

import java.io.Serializable;
/**
 * 公共交通-线路维护
 * @author dl
 *
 */
public class AroundLineModel implements Serializable{

	private static final long serialVersionUID = 3881848104054928312L;
	
	private Integer id;
	private String lineName;//线路名称
	private Integer trafficType;//1、公交 2、地铁
	private String firstTime;//首班时间
	private String lastTime;//末班时间
	private Double ticketPrice;//票价
	private String remark;//备注
	private String startStation;//始发站
	private String endStation;//终点站
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public Integer getTrafficType() {
		return trafficType;
	}
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public void setTrafficType(Integer trafficType) {
		this.trafficType = trafficType;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	/**
	 * 将首末班时间转换为时分
	 * @return
	 */
	/*public String getFirstTimeFormat(){
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		if(firstTime!=null){
			return format.format(this.firstTime);
		}
		return "";
	}
	public String getLastTimeFormat(){
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		if(lastTime!=null){
			return format.format(this.lastTime);
		}
		return "";
	}*/
	
}
