package com.golden.ihome.common;

import java.util.HashMap;
import java.util.Map;

public class SysParam {
	
	public static Map<String,String> constMap = new HashMap<String,String>();
    //房源系统参数
	public static String WT = "WT";//委托录入配置  描述 1：是 2：否
	public static String FYBH = "FYBH";//房源添加保护数量配置
	public static String SKIMG = "SKIMG";//实勘上传图片时参数配置
	public static String MMFYMS = "MMFYMS";//买卖房源描述配置
	public static String MMFWSS = "MMFWSS";//买卖房屋设施配置
	public static String MMSNJJ = "MMSNJJ";//买卖室内家具配置
	public static String MMFYBQ = "MMFYBQ";//买卖房源标签配置
	public static String XZLDJ = "XZLDJ";//写字楼等级配置
	public static String MMKFFS = "MMKFFS";//买卖房源看房方式配置
	public static String YXSKQ = "YXSKQ";//优先实勘权天数配置
	public static String BHGSKTP = "BHGSKTP";//不合格实勘显示配置
	public static String GJFS = "GJFS";//房源跟进方式
	//房源系统参数-租赁
	public static String ZLSHJY = "ZLKFFS";//租赁看房方式配置
	public static String ZLFWSS = "ZLFWSS";//租赁房屋设施配置
	public static String ZLSNJJ = "ZLSNJJ";//租赁室内家具配置
	public static String ZLFYMS = "ZLFYMS";//租赁房源描述配置
	public static String ZLFYBQ = "ZLFYBQ";//租赁房源标签配置
	public static String ZLKFFS = "ZLSHJY";//租赁适合经营配置
	//客源系统参数
	public static String KHPJ = "KHPJ";//客户评价自定义配置
	//时间
	public static String SKZGK = "SKZGK";//私客转公客时间参数设置
	public static String SGIMG = "SGIMG";//修改约带看记录时间配置
	//跟进提醒
	public static String JJRGJ = "JJRGJ";//经纪人跟进提醒设置
	public static String DZHF = "DZHF";//店长回访提醒设置
	public static String HMDJB = "HMDJB";//黑名单级别设置
	public static String FYSSR = "FYSSR";//房源所属人提醒设置
	//查看电话次数配置
	public static String FYCKDH = "FYCKDH";//房源查看电话次数配置
	public static String KYCKDH = "KYCKDH";//客源查看电话次数配置
	//其他系统参数
	public static String LPTPFL = "LPTPFL";//楼盘图片分类
	public static String MBKHX = "MBKHX";//目标考核项
	
	public static String getStatusContent(String key){
		return constMap.get(key);
	}
	public static void setStatusContent(String key,String value){
		constMap.put(key, value);
	}
}
