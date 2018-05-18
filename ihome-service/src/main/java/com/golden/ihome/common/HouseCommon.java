package com.golden.ihome.common;

import java.util.List;

public class HouseCommon {
	//house sale 
	/**
	 * 使用类别1住宅，2商铺，3写字楼，4车库
	 */
	public static String getUseTypeStr(Integer useType) {
		if(useType == null)return "";
		switch (useType) {
		case 1:
			return "住宅";
		case 2:
			return "商铺";
		case 3:
			return "写字楼";
		case 4:
			return "车库";
		}
		return "其它";
	}
	/**
	 * 房屋性质1已购公房2商铺房3空置房4使用权房5央产6经济适用房
	 */
	public static String getPropertyStr(Integer property) {
		switch (property) {
		case 1:
			return "已购公房";
		case 2:
			return "商品房";
		case 3:
			return "空置房";
		case 4:
			return "使用权房";
		case 5:
			return "央产";
		case 6:
			return "经济适用房";
		}
		return "其它";
	}
	/**
	 * 楼型（建筑类型）1高层2多层3平房4别墅5其它
	 */
	public static String getBuildingTypeStr(Integer buildingType) {
		switch (buildingType) {
		case 1:
			return "高层";
		case 2:
			return "多层";
		case 3:
			return "平房";
		case 4:
			return "别墅";
		}
		return "其它";
	}
	/**
	 * 朝向1东，2南，3西，4北
	 */
	public static String getChaoXiangStr(Integer chaoXiang){
		switch (chaoXiang) {
		case 1:
			return "东";
		case 2:
			return "南";
		case 3:
			return "西";
		case 4:
			return "北";
		}
		return "其它";
	}
	/**
	 * 户籍信息类型1有-可迁出,2无-不可迁出,3无
	 */
	public static String getHjInfoTypeStr(Integer hjInfoType) {
		switch (hjInfoType) {
		case 1:
			return "有-可迁出";
		case 2:
			return "无-不可迁出";
		case 3:
			return "无";
		}
		return "其它";
	}
	/**
	 * 证贷情况1有证无贷,2有证有贷,3无证有贷,4无证无贷
	 */
	public static String getZhengDaiStr(Integer zhengDai) {
		switch (zhengDai) {
		case 1:
			return "有证无贷";
		case 2:
			return "有证有贷";
		case 3:
			return "无证有贷";
		case 4:
			return "无证无贷";
		}
		return "其它";
	}
	/**
	 * 税费情况1免税，2只有个税，3只有营业税，4有营业税有个税
	 */
	public static String getTaxationStr(Integer taxation) {
		switch (taxation) {
		case 1:
			return "免税";
		case 2:
			return "只有个税";
		case 3:
			return "只有营业税";
		case 4:
			return "有营业税有个税";
		}
		return "其它";
	}
	/**
	 * 房源等级1普通房源，2诚盘,3必卖盘，4诚盘+必卖盘
	 */
	public static String getHouseLevelStr(Integer houseLevel) {
		switch (houseLevel) {
		case 1:
			return "普通房源";
		case 2:
			return "诚盘";
		case 3:
			return "必卖盘";
		case 4:
			return "诚盘+必卖盘";
		}
		return "其它";
	}
	/**
	 * 迁出时间1随时，2过户后，3半年内
	 */
	public static String getMoveOutTypeStr(Integer moveOutType) {
		switch (moveOutType) {
		case 1:
			return "随时";
		case 2:
			return "过户后";
		case 3:
			return "半年内";
		}
		return "其它";
	}
	/**
	 * 腾空时间1签约后1周内，2签约后10天内，3签约后20天内
	 */
	public static String getTakeEmptyStr(Integer takeEmpty) {
		switch (takeEmpty) {
		case 1:
			return "签约后1周内";
		case 2:
			return "签约后10天内";
		case 3:
			return "签约后20天内";
		}
		return "其它";
	}
	/**
	 * 卖房原因1长期置闲，2买新房，3出国，4新房还贷，5其它原因
	 */
	public static String getSellReasonStr(Integer sellReason) {
		switch (sellReason) {
		case 1:
			return "长期置闲";
		case 2:
			return "买新房";
		case 3:
			return "出国";
		case 4:
			return "新房还贷";
		}
		return "其它原因";
	}
	
	/**
	 * 装修类型1毛坯,2简装,3精装,4豪装,5中等
	 */
	public static String getDecoradionStr(Integer decoradion) {
		switch (decoradion) {
		case 1:
			return "毛坯";
		case 2:
			return "简装";
		case 3:
			return "精装";
		case 4:
			return "豪装";
		case 5:
			return "中等";
		}
		return "其它";
	}
	/**
	 * 装修时间1半年以内，2一年以内，3一年至三年，4三年以上
	 */
	public static String getDecoradionTimeStr(Integer decoradionTime) {
		switch (decoradionTime) {
		case 1:
			return "半年以内";
		case 2:
			return "一年以内";
		case 3:
			return "一年至三年";
		case 4:
			return "三年以上";
		}
		return "其它";
	}
	
	//联系人
	/**
	 * 联系人类型1.业主(产权人) 2.父母 3.丈夫 4.妻子 5.子女 6.亲戚 7.其他
	 */
	public static String getLinkTypeStr(Integer linkType) {
		switch (linkType) {
		case 1:
			return "业主";
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
		}
		return "其它";
	}
	//钥匙管理
	/**
	 * 钥匙类型：1钥匙，2门禁卡，3密码
	 */
	public static String getKeyTypeStr(Integer keyType) {
		switch (keyType) {
		case 1:
			return "钥匙";
		case 2:
			return "门禁卡";
		case 3:
			return "密码";
		
		}
		return "其它";
	}
	//商铺 
	/**
	 * 适合经营 1服装2餐饮
	 */
	public static String getFitManagementStr(Integer fitManagement) {
		switch (fitManagement) {
		case 1:
			return "服装";
		case 2:
			return "餐饮";
		}
		return "其它";
	}
	/**
	 * 楼层1高层2中间层3顶楼4底楼5地下室
	 */
	public static String getBuildingFloorStr(Integer buildingFloor) {
		switch (buildingFloor) {
		case 1:
			return "高层";
		case 2:
			return "中间层";
		case 3:
			return "顶楼";
		case 4:
			return "底楼";
		case 5:
			return "地下室";
		}
		return "其它";
	}
	//写字楼 
	/**
	 * 适合经营 1服装2餐饮
	 */
	public static String getOfficeLevelStr(Integer officeLevel) {
		switch (officeLevel) {
		case 1:
			return "甲级";
		case 2:
			return "乙级";
		case 3:
			return "丙级";
		case 4:
			return "丁级";
		}
		return "其它";
	}
	/**
	 * /厕所1公厕2私厕
	 */
	public static String getToiletStr(Integer toilet) {
		switch (toilet) {
		case 1:
			return "公厕";
		case 2:
			return "私厕";
		}
		return "其它";
	}
	//楼盘
	/**
	 * 小区维护类别 责任盘  非责任盘
	 */
	public static String getMaintenanceCategoryStr(Integer maintenanceCategory) {
		switch (maintenanceCategory) {
		case 1:
			return "责任盘";
		case 2:
			return "非责任盘";
		}
		return "其它";
	}
	/**
	 * 房源类型，1买卖，2租赁
	 */
	public static String getHouseTypeStr(Integer houseType) {
		if(houseType == null)
			return "";
		switch (houseType) {
		case 1:
			return "买卖";
		case 2:
			return "租赁";
		}
		return "其它";
	}
	
	/**
	 * 实勘审审核核状态，1未审核，2合格，3不合格
	 */
	public static String getProspectCheckStatus(Integer status) {
		if(status == null)
			return "";
		switch (status) {
		case 1:
			return "未提交";
		case 2:
			return "未审核";
		case 3:
			return "审核通过";
		case 4:
			return "审核未通过";
		case 5:
			return "审核未通过显示图片";
		}
		return "其它";
	}
	
	/**
	 * 实勘审核分配状态，0未分配，1已分配
	 */
	public static String getAllotStatus(Integer status) {
		if(status == null)
			return "";
		switch (status) {
		case 0:
			return "未分配";
		case 1:
			return "已分配";
		}
		return "其它";
	}
	/**
	 * 土地使用年限
	 */
	public static String getLandLimitNames(Integer status) {
		if(status == null)
			return "";
		switch (status) {
		case 1:
			return "70年";
		case 2:
			return "60年";
		case 3:
			return "50年";
		case 4:
			return "40年";
		}
		return " ";
	}
	
	/**
	 * 判断当前人是否有该房源的运营权限 
	 * @return true /false
	 */
	public static Boolean checkOperatePerview(List<String> houseOrgMapList,String dataPowers){
		Boolean flag = false;
		//如果判断是否有责任权限
		if(null != dataPowers && null != houseOrgMapList){
			for(String per :houseOrgMapList){
				if(per!=null && dataPowers.indexOf(per+",")>0){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
}
