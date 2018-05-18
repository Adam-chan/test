package com.golden.ihome.crm.model;

import java.math.BigDecimal;
import java.util.Date;

import com.golden.ihome.utils.DateUtil;

public class ManageProspectModel {
    private Double startDate;

    private Long houseInfoId;

    private String houseCode;

    private String houseType;

    private BigDecimal houseArea;

    private String prospectUser;

    private String prospectUserId;

    private Date createTime;

    private Short status;

    private String examineUser;

    private String examineUserId;

    private String examineOrg;

    private String examineOrgCode;
    
    private String demandType;
    
    private String name;
    
    private String useType;
    
    private String reason;
    
    private String proposerUser;
    
    private Date fakeTime;
    
    public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getProposerUser() {
		return proposerUser;
	}

	public void setProposerUser(String proposerUser) {
		this.proposerUser = proposerUser;
	}

	public Date getFakeTime() {
		return fakeTime;
	}

	public void setFakeTime(Date fakeTime) {
		this.fakeTime = fakeTime;
	}

	public String getDemandType() {
		return demandType;
	}

	public void setDemandType(String demandType) {
		this.demandType = demandType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public Double getStartDate() {
        return startDate;
    }

    public void setStartDate(Double startDate) {
        this.startDate = startDate;
    }

    public Long getHouseInfoId() {
        return houseInfoId;
    }

    public void setHouseInfoId(Long houseInfoId) {
        this.houseInfoId = houseInfoId;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode == null ? null : houseCode.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public String getProspectUser() {
        return prospectUser;
    }

    public void setProspectUser(String prospectUser) {
        this.prospectUser = prospectUser == null ? null : prospectUser.trim();
    }

    public String getProspectUserId() {
        return prospectUserId;
    }

    public void setProspectUserId(String prospectUserId) {
        this.prospectUserId = prospectUserId == null ? null : prospectUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getExamineUser() {
        return examineUser;
    }

    public void setExamineUser(String examineUser) {
        this.examineUser = examineUser == null ? null : examineUser.trim();
    }

    public String getExamineUserId() {
        return examineUserId;
    }

    public void setExamineUserId(String examineUserId) {
        this.examineUserId = examineUserId == null ? null : examineUserId.trim();
    }

    public String getExamineOrg() {
        return examineOrg;
    }

    public void setExamineOrg(String examineOrg) {
        this.examineOrg = examineOrg == null ? null : examineOrg.trim();
    }

    public String getExamineOrgCode() {
        return examineOrgCode;
    }

    public void setExamineOrgCode(String examineOrgCode) {
        this.examineOrgCode = examineOrgCode == null ? null : examineOrgCode.trim();
    }
    
	public String getCreateTimeStr() {
		String createTimeStr = "";
		if (this.createTime == null) {
			return null;
		} else {
			createTimeStr = DateUtil.getStringByDate(this.createTime,"yyyy-MM-dd");
			return createTimeStr;
		}
	}
	
	public String getFakeTimeStr() {
		String fakeTimeStr = "";
		if (this.fakeTime == null) {
			return null;
		} else {
			fakeTimeStr = DateUtil.getStringByDate(this.fakeTime,"yyyy-MM-dd");
			return fakeTimeStr;
		}
	}
}