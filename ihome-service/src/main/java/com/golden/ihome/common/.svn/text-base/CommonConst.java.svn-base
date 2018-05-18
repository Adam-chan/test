package com.golden.ihome.common;

/**
 * 常量类
 * 
 * @author ChenHuan
 */
public class CommonConst {
	//区域示范对外网显示
	/**
	 * 外网显示状态：显示
	 */
	public static final Integer UseIng = 1;

	/**
	 * 外网显示状态：不显示
	 */
	public static final Integer DeteleIng= 2;

	/**
	 * 获取：使用状态文本
	 */
	public static String getShowStatus(Integer tradeType) {
		switch (tradeType) {
		case 1:
			return "是";
		case 2:
			return "否";
		}
		return "其它";
	}
	//道路日志--生成号段的规则
	/**
	 * 1：单号撒号
	 */
	public static final Integer SINGULAR_NUM = 1;

	/**
	 * 2：双号撒号
	 */
	public static final Integer DOUBLE_NUM = 2;
	
	/**
	 * 3：连续撒号
	 */
	public static final Integer CONTINUOUS_NUM = 3;

	/**
	 * 获取：道路号生成规则
	 */
	public static String getRoadNumType(Integer creatType) {
		switch (creatType) {
		case 1:
			return "连续撒号";
		case 2:
			return "单号撒号";
		case 3:
			return "双号撒号";
		}
		return "其它";
	}
	//道路号使用状态
	/**
	 * 使用
	 */
	public static final Integer NUM_USEING = 1;

	/**
	 * 不使用 忽略
	 */
	public static final Integer Num_UNUSEING= 2;

	/**
	 * 获取：使用状态文本
	 */
	public static String getUseStatus(Integer status) {
		switch (status) {
		case 1:
			return "启用中";
		case 2:
			return "禁用中";
		}
		return "其它";
	}
	//道路日志删除状态
	/**
	 * 使用中
	 */
	public static final Integer LOG_USEING = 1;

	/**
	 * 已作废
	 */
	public static final Integer LOG_USED= 2;

	/**
	 * 获取：使用状态文本
	 */
	public static String getLogUseStatus(Integer status) {
		switch (status) {
		case 1:
			return "使用中";
		case 2:
			return "已作废";
		}
		return "其它";
	}
	//房间状态
	/**
	 * 正常
	 */
	public static final Integer HOUSE_STATUS = 1;

	/**
	 * 删除
	 */
	public static final Integer HOUSE_STATUS_HIDDEN= 2;

	//教育设施--教育机构类型 1：幼儿园 2：小学 3：中学 4：大学 5：图书馆 6：培训机构  7:少年宫 
	/**
	 * 幼儿园
	 */
	public static final Integer KINDERGARTEN = 1;

	/**
	 * 小学
	 */
	public static final Integer PRIMARY_SCHOOL= 2;
	/**
	 * 中学
	 */
	public static final Integer MIDDLE_SCHOOL = 3;

	/**
	 * 大学
	 */
	public static final Integer COLLEGE= 4;
	/**
	 * 图书馆
	 */
	public static final Integer LIBRARY = 5;

	/**
	 * 培训机构
	 */
	public static final Integer TRAINING_INSTITUTION= 6;
	/**
	 * 少年宫
	 */
	public static final Integer YOUTH_PALACE = 7;

	/**
	 * 获取：教育机构文本
	 */
	public static String getEduType(Integer eduType) {
		switch (eduType) {
		case 1:
			return "幼儿园";
		case 2:
			return "小学";
		case 3:
			return "中学";
		case 4:
			return "大学";
		case 5:
			return "图书馆";
		case 6:
			return "培训机构";
		case 7:
			return "少年宫";
		}
		return "其它";
	}
	//楼盘约带看带看状态
	/**
	 * 1 新建
	 */
	public static final Integer Look_ING = 1;

	/**
	 * 2 已带看
	 */
	public static final Integer Look_ED= 2;
	/**
	 * 3 已带看
	 */
	public static final Integer Look_CANCEL= 3; 

	/**
	 * 获取：使用状态文本
	 */
	public static String getLookStatus(Integer ledStatus) {
		switch (ledStatus) {
		case 1:
			return "新建";
		case 2:
			return "禁用中";
		case 3:
			return "已取消";
		}
		return "其它";
	}
	
	//临时地址库业务类型
	/**
	 * 买卖
	 */
	public static final Integer SALE= 1;

	/**
	 * 租赁
	 */
	public static final Integer LEASE= 2;

	/**
	 * 获取：使用状态文本
	 */
	public static String getBizType(Integer status) {
		switch (status) {
		case 1:
			return "买卖";
		case 2:
			return "租赁";
		}
		return "其它";
	}
	//限时速递签约状态
	/**
	 * 新签
	 */
	public static Integer STATUS_NEW_CONTRACT = 1;
	/**
	 * 续签
	 */
	public static Integer STATUS_RENEW = 2;
	/**
	 * 结束
	 */
	public static Integer STATUS_END = 3;
	/**
	 * 终止
	 */
	public static Integer STATUS_TERMINATION = 4;
	/**
	 * 获取：限时速递签约状态文本
	 */
	public static String getManageTimeLimitExpressStatus(Integer status) {
		switch (status) {
		case 1:
			return "新签";
		case 2:
			return "续签";
		case 3:
			return "结束";
		case 4:
			return "终止";
		}
		return "";
	}
	
	public static String getLinkManTypeStr(Integer type){
		switch (type) {
			case 1:
				return "产权人";
			case 2:
				return "父母";
			case 3:
				return "丈夫";
			case 4:
				return "妻子";
			case 5:
				return "子女";
			case 6:
				return "亲戚";
			case 7:
				return "其他";
		}
		return "";
	}
}
