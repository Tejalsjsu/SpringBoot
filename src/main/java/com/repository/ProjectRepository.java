package com.repository;

import org.springframework.data.repository.CrudRepository;
import com.entity.tblproject;

public interface ProjectRepository extends CrudRepository<tblproject, Integer> {
	Iterable<tblproject> findAll();
	tblproject findOne(Integer idtblProject);
	Iterable<tblproject> findByemployerId(Integer employerId);
	Iterable<tblproject> findByAssignedTo(Integer AssignedTo);
	Iterable<tblproject> findBystatus(String status);	
}
