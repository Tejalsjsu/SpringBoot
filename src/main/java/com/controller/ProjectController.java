package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.tbllogin;
import com.entity.tblproject;
import com.service.ProjectService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/project") // This means URL's start with /user (after Application path)
public class ProjectController {

	private ProjectService projectService;
	
	 @PostMapping(path="/addProject",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
	    public  ResponseEntity<?> addNewProject (@RequestBody tblproject projectDetails) {
	        // @ResponseBody means the returned String is the response, not a view name
	        // @RequestParam means it is a parameter from the GET or POST request
	    	projectService.addProject(projectDetails);
	        System.out.println("Saved");
	        return new ResponseEntity(null,HttpStatus.CREATED);
	    }
	 
	 @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody Iterable<tblproject> getAllProjects() {
	        // This returns a JSON
	        return projectService.getAllProjects();
	    }
	    
	    @GetMapping(path="/employer",produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody Iterable<tblproject> getAllProjectsEmployer(Integer employerId) {
	        // This returns a JSON
	        return projectService.findByemployerId(employerId);
	    }
	
	    @GetMapping(path="/user",produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody Iterable<tblproject> getAllProjectsAssignedTo(Integer AssignedTo) {
	        return projectService.findByAssignedTo(AssignedTo);
	    }
	    
	    @GetMapping(path="/status",produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody Iterable<tblproject> getAllProjectsstatus(String status) {
	        // This returns a JSON
	        return projectService.findBystatus(status);
	    }

}
