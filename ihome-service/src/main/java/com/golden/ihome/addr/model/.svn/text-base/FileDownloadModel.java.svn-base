package com.golden.ihome.addr.model;

import java.io.Serializable;
import java.sql.Date;

import com.golden.ihome.utils.DateUtil;

public class FileDownloadModel implements Serializable {

	private static final long serialVersionUID = -5315269525138322186L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件夹名称
	 */
	private String folderName;
	/**
	 * 服务器上的文件名称
	 */
	private String fileNameLong;
	/**
	 * 返回的json数据
	 */
	private String dataStr;

	/**
	 * 上传时间
	 */
	private Date uploadDate;
	/**
	 * 上传时间
	 */
	private String uploadDateStr;
	/**
	 * 上传人
	 */
	private String uploadPerson;
	/**
	 * 楼盘id
	 */
	private Integer premisesId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadPerson() {
		return uploadPerson;
	}

	public void setUploadPerson(String uploadPerson) {
		this.uploadPerson = uploadPerson;
	}

	public Integer getPremisesId() {
		return premisesId;
	}

	public void setPremisesId(Integer premisesId) {
		this.premisesId = premisesId;
	}

	public String getUploadDateStr() {
		this.uploadDateStr = DateUtil.getStringByDate(this.uploadDate,"yyyy-MM-dd");
		return uploadDateStr;
	}

	public void setUploadDateStr(String uploadDateStr) {
		this.uploadDateStr = uploadDateStr;
	}
	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFileNameLong() {
		return fileNameLong;
	}

	public void setFileNameLong(String fileNameLong) {
		this.fileNameLong = fileNameLong;
	}

	public String getDataStr() {
		return dataStr;
	}

	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
}
