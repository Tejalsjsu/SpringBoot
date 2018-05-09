package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class tblbids {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bidId;
	
	@ManyToOne
	private Integer projectId;
	
	private Integer userId;
	private Integer bidAmount;
	private Integer completionDays;
	public Integer getBidId() {
		return bidId;
	}
	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Integer bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Integer getCompletionDays() {
		return completionDays;
	}
	public void setCompletionDays(Integer completionDays) {
		this.completionDays = completionDays;
	}
	

}
