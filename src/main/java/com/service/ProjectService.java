package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.tblproject;
import com.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public Iterable<tblproject> getAllProjects(){
		return projectRepository.findAll();
	}
	
	public void addProject(tblproject projectDetails) {
		projectRepository.save(projectDetails);
	}
	
	public Iterable<tblproject> findByemployerId(Integer employerId){
		return projectRepository.findByemployerId(employerId);
	}
	
	public Iterable<tblproject> findByAssignedTo(Integer AssignedTo){
		return projectRepository.findByAssignedTo(AssignedTo);
	}
	
	public Iterable<tblproject> findBystatus(String status){
		return projectRepository.findBystatus(status);
	}
}
