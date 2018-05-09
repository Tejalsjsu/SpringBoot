package com.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class tblproject {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idtblProject;
	private Integer employerId;
	private String projectName;
	private String projectDescription;
	private String budgetRange;
	private String filePath;
	private String status;
	private String duration;
	private Date startDate;
	private String projectPay;
	private String skills;
	private String currency;
	
	@ManyToOne
	private Integer AssignedTo;
	
	public Integer getAssignedTo() {
		return AssignedTo;
	}
	public void setAssignedTo(Integer assignedTo) {
		AssignedTo = assignedTo;
	}
	public Integer getIdtblProject() {
		return idtblProject;
	}
	public void setIdtblProject(Integer idtblProject) {
		this.idtblProject = idtblProject;
	}
	public Integer getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getBudgetRange() {
		return budgetRange;
	}
	public void setBudgetRange(String budgetRange) {
		this.budgetRange = budgetRange;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getProjectPay() {
		return projectPay;
	}
	public void setProjectPay(String projectPay) {
		this.projectPay = projectPay;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
