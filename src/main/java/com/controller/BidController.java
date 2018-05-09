package com.controller;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.json.JSONObject;
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

import com.entity.tblbids;
import com.entity.tblproject;
import com.service.BidService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/bid") // This means URL's start with /user (after Application path)
public class BidController {
	
	private BidService bidService;
	
	 @ResponseBody
	 @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	   public String demo() {
	       return "{\"hello\":\"world\"}";
	   }
	
	@PostMapping(path="/addBid", consumes = MediaType.APPLICATION_JSON_VALUE)  //Maps Post Request
	public ResponseEntity<?> addNewBid(@RequestBody tblbids bidDetails){
		bidService.addBid(bidDetails);
		System.out.println("Bid Placed");
		return new ResponseEntity(null, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/ByProject",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<tblbids> getBidByProject(@RequestBody tblbids bidDetails) {
    	JSONObject jsonObject = new JSONObject(bidDetails);
        Integer projectId = Integer.parseInt(jsonObject.getString("projectId"));
        // This returns a JSON with the users
        return bidService.findByprojectId(projectId);
    }

    @GetMapping(path="/ByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<tblbids> getBidsByUser(@RequestBody tblbids bidDetails) {
    	JSONObject jsonObject = new JSONObject(bidDetails);
        Integer userId = Integer.parseInt(jsonObject.getString("userId"));
        // This returns a JSON with the users
        return bidService.findByuserId(userId);
    }

	
	
}

