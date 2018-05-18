package com.golden.ihome.addr.service.traffic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.ihome.addr.dao.traffic.AroundLineDao;
import com.golden.ihome.addr.dao.traffic.AroundSiteDao;
import com.golden.ihome.addr.model.AroundLineModel;
import com.golden.ihome.addr.model.AroundSiteModel;
import com.golden.port.framework.handleable.IBaseHandler;
import com.golden.port.framework.transaction.TM;

@Service("traffic/readSiteExcelService")
public class ReadSiteExcelService implements IBaseHandler{
	
	public static Logger logger = LoggerFactory.getLogger(AroundSiteService.class);

	private final static String excel2003 =".xls";   
    private final static String excel2007 =".xlsx";   
    
	@Autowired
	private AroundSiteDao aroundSiteDao;
	@Autowired
	private AroundLineDao aroundLineDao;
	@Autowired 
	private AroundSiteService aroundSiteService;
	
	@Override
	public Object execute(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 读EXCEL文件，获取客户信息集合
	 * @param map
	 * @return result
	 */
	public String batchImport(Map<String, Object> map){
		 String result = "";
		 //站点类型
		 Integer trafficType = Integer.parseInt(map.get("trafficType").toString());
		 //文件名称
		 String fileName = map.get("fileName").toString();
		 //文件流
		 InputStream is =  new ByteArrayInputStream((byte[]) map.get("isArray"));
		 try{
             //解析Excel并保存数据
	         result = getExcelInfo(is,fileName,trafficType); 
             is.close();
         }catch(Exception e){
        	 result = "上传失败！";
             e.printStackTrace();
         } finally{
             if(is !=null){
            	 try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
             }
          }
	      return result;
	 }
	 /**
	  * 解析Excel并保存数据
	  * @param fis
	  * @param fileName
	  * @param trafficType
	  * @return
	  * @throws Exception 
	  */
	 public String getExcelInfo(InputStream is,String fileName,Integer trafficType) throws Exception{
		   String result = "";
		   List<AroundSiteModel> existSiteList = new ArrayList<AroundSiteModel>();
		   List<AroundSiteModel> siteNameIsEmptyList = new ArrayList<AroundSiteModel>();
	       try{
	    	   //创建Excel工作薄  
	           Workbook work = this.getWorkbook(is,fileName);  
	           if(null == work){  
	               throw new Exception("创建Excel工作薄为空！");  
	           }  
	           List<AroundSiteModel> dataList = new ArrayList<AroundSiteModel>();
	           Sheet sheet=work.getSheetAt(0); 
	           if(sheet==null){
	        	   result = "Excel工作簿为空！";
        	   }else{
        		   //行数
    	           int totalRows=sheet.getLastRowNum();
    	           //列数
    	           int totalCells = 0;
    	           if(totalRows>=1 && sheet.getRow(0) != null){
    	               totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
    	           }
    	           //循环Excel行数,从第二行开始
    	           for(int r=0;r<=totalRows;r++){
    	        	   if(r==0){
    	        		   //判断Excel表头是否正确
    	    	           Row row1 = sheet.getRow(0);
    	    	           for(int c = 0; c < totalCells; c++){
    	    	        	   Cell cell = row1.getCell(c);
    	    	        	   String cellValue = convertDataType(cell);
    	    	        	   if((c==0 && !cellValue.equals("站点名称")) || (c==1 && !cellValue.equals("经过线路")) 
    	    	        			   || (c==2 && !cellValue.equals("辅助标识")) || (c==3 && !cellValue.equals("临近站点"))){
    	                           return "上传失败！请下载模板，阅读模板备注后上传文件！";
    	                       }
    	    	           }
    	        	   }else{
    	        		   Row row = sheet.getRow(r);
    	        		   if (row != null) {
    	        			   AroundSiteModel site = new AroundSiteModel();     
            	               //循环Excel的列
            	               for(int c = 0; c < totalCells; c++){    
            	                   Cell cell = row.getCell(c);
            	                   String cellValue = convertDataType(cell);
            	                   if (null != cell){
            	                	   if(c==0){
            	                           site.setSiteName(cellValue);//站点名称
            	                       }else if(c==1){
            	                           site.setLines(cellValue);//经过线路
            	                       }else if(c==2){
            	                           site.setAssistSign(cellValue);//辅助标识
            	                       }else if(c==3){
            	                           site.setCloseSite(cellValue);//临近站点
            	                       }
            	                   }
            	               }
            	               if(site!=null){
            	            	   //逻辑：1)如果站点名称不为空 2)站点名称唯一校验 3)添加到list
            	            	   if(site.getSiteName()!=null && !(site.getSiteName()).equals("")){
            	            		   Map<String,Object> map = new HashMap<String,Object>();
            	            		   map.put("siteName", site.getSiteName());
            	            		   map.put("trafficType", trafficType);
            	            		   Integer i = aroundSiteService.getSiteByNameIs(map);
            	            		   if(i==0){
            	            			   site.setTrafficType(trafficType);
            	            			   dataList.add(site);
            	            		   }else{
            	            			   //siteName在数据库中已存在不添加到list
            	            			   existSiteList.add(site);
            	            		   }
            	            	   }else{
            	            		   //siteName为空时不添加到list
            	            		   siteNameIsEmptyList.add(site);
            	            	   }
            	               }
    	        		   }
    	        	   }
    	           }
    	           logger.debug("#公共交通-Excel解析-已存在的站点数据:", existSiteList);
    	           logger.debug("#公共交通-Excel解析-siteName为空的数据:", siteNameIsEmptyList);
    	           result = handleDataList(dataList,trafficType,existSiteList);
        	   }
	       }catch (IOException e)  {  
	    	   result = "上传失败！";
	           e.printStackTrace();  
	       }  
	       return result;
	}
	/**
	 * 处理从Excel中读取的数据
	 * @param dataList
	 * @return result
	 */
	@TM
	public String handleDataList(List<AroundSiteModel> dataList,Integer trafficType,List<AroundSiteModel> existSiteList){
		String result = "";
		String lines = "";
		List<AroundSiteModel> contactSaveFailList = new ArrayList<AroundSiteModel>();
        if(dataList.size()>0){
     	   for (int i = 0; i < dataList.size(); i++) {
     		   AroundSiteModel site = dataList.get(i);
     		   //Excel上传的线路拼接字符串
			   lines = site.getLines();
			   //保存站点信息
			   Integer in = aroundSiteDao.insertSite(site);
			   //保存站点和线路关联关系
			   if(in == 1 && lines!=null && !lines.equals("")){
				   List<String> allLineList = Arrays.asList(lines.split("、"));
				   List<String> existLineList = new ArrayList<String>();
				   if(allLineList.size()>0){
					   for (int j = 0; j < allLineList.size(); j++) {
						   //逻辑：1)校验线路是否存在 2)若存在，则保存站点和线路关系 3)若线路不存在，则不保存关联关系
						   Map<String,Object> map = new HashMap<String,Object>();
						   map.put("lineName", allLineList.get(j));
						   map.put("trafficType", trafficType);
						   List<AroundLineModel> validLineOnlyList = aroundLineDao.getLineByName(map);
						   if(!validLineOnlyList.isEmpty()){
							   existLineList.add(validLineOnlyList.get(0).getId().toString());
						   }
					   }
				   }
				   if(!existLineList.isEmpty()){
					   Map<String,Object> map = new HashMap<String,Object>();
					   map.put("siteId", site.getId()-1);
					   map.put("lineIds", existLineList.toArray());
					   Integer r = aroundSiteDao.insertSiteLineContact(map);
					   if(r==0){
						   //当前站点和线路关联关系保存失败
						   contactSaveFailList.add(site);
					   }else{
						   //当前站点和线路关联关系保存成功
					   }
				   }
			   }else{
				   //保存站点时出错的数据
			   }
     	   }
     	   logger.debug("#公共交通-Excel解析-站点和线路关联关系保存失败的数据:", contactSaveFailList);
     	   if(!existSiteList.isEmpty()){
     		   result = "保存成功！已存在的数据，自动筛选未上传！";
     	   }else{
     		   result = "保存成功！";
     	   }
        }else{
           //从Excel中未读取出数据,dataList为空
           if(!existSiteList.isEmpty()){
        	   result = "上传数据已存在！";
      	   }else{
      		   result = "上传数据为空！";
      	   }
        }
		return result;
	}
	/**
	 * 根据文件后缀，自适应上传文件的版本 
	 * @param is
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
    public  Workbook getWorkbook(InputStream is,String fileName) throws Exception{  
        Workbook workbook = null;  
        String fileType = fileName.substring(fileName.lastIndexOf("."));  
        if(excel2003.equals(fileType)){  
        	workbook = new HSSFWorkbook(is);  
        }else if(excel2007.equals(fileType)){  
        	workbook = new XSSFWorkbook(is);  
        }else{  
            throw new Exception("解析的文件格式有误！");  
        }  
        return workbook;  
    }
    /**
     * 转换数据类型
     * @param cell
     * @return
     */
    @SuppressWarnings("deprecation")
	public  String convertDataType(Cell cell){
    	String cellValue  = "";
    	if (null != cell) {  
            // 以下是判断数据的类型  
            switch (cell.getCellType()) {  
	            case HSSFCell.CELL_TYPE_NUMERIC: // 数字  
	                DecimalFormat df = new DecimalFormat("0");  
	                cellValue = df.format(cell.getNumericCellValue());  
	                break;  
	            case HSSFCell.CELL_TYPE_STRING: // 字符串  
	                cellValue = cell.getStringCellValue();  
	                break;  
	            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean  
	                cellValue = cell.getBooleanCellValue() + "";  
	                break;  
	            case HSSFCell.CELL_TYPE_FORMULA: // 公式  
	                cellValue = cell.getCellFormula() + "";  
	                break;  
	            case HSSFCell.CELL_TYPE_BLANK: // 空值  
	                cellValue = "";  
	                break;  
	            default:  
	                cellValue = "";  
	                break;  
            }  
        }  
    	return cellValue;
    }

}
