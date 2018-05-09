package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.tblbids;

public interface BidRepository extends CrudRepository<tblbids, Integer>  {
	//Iterable<tblbids> findAll();
	//tblbids findAll(Integer idtblProject);
	Iterable<tblbids> findByuserId(Integer userId);
	Iterable<tblbids> findByprojectId(Integer projectId);
}
