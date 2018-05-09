package com.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.entity.tbllogin;

// this would be auto implemented into a bean called tblloginrepository
// create a crud interface

public interface tblloginRepository extends CrudRepository<tbllogin, Integer>{
	//List<tbllogin> findByEmailAndPassword(String userEmail,String userPassword);
	Iterable<tbllogin> findAll();
	tbllogin findUsersByUserEmailAndUserPassword(String userEmail, String password);
	tbllogin findOne(Integer userId);
	Iterable<tbllogin> findByuserId(Integer userId);
}
