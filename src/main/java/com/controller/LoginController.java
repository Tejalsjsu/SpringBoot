package com.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.entity.LoginInResponse;
import com.entity.Response;
import com.entity.User;
import com.entity.tbllogin;
import com.service.LoginService;

@Controller // This means a class is controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/login") // URL from client react come here
public class LoginController {
	@Autowired
	private LoginService loginService;

	 @RequestMapping(path="/verifyLogin",method = RequestMethod.POST) // Map ONLY POST Requests
    public LoginInResponse login(@RequestBody tbllogin user, HttpSession session) {
	 JSONObject jsonObject = new JSONObject(user);
	 session.setAttribute("userId",jsonObject.getString("userId"));
	 return loginService.login(jsonObject.getString("username"),jsonObject.getString("password"));
    }
	 
	 @RequestMapping(path="/editProfile",method = RequestMethod.POST) // Map ONLY POST Requests
	    public Response editProfile(@RequestBody tbllogin user) {
		 JSONObject jsonObject = new JSONObject(user);
		 return loginService.editProfile(jsonObject);
	    }
	
    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<tbllogin> getAllUsers() {
        // This returns a JSON with the users
        return loginService.getAllUsers();
    }
    
    @PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody tbllogin user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
    	loginService.addUser(user);
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }
   
    @GetMapping(path="/userId",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<tbllogin> findByuserId(@RequestBody tbllogin user) {
        // This returns a JSON with the users
    	JSONObject jsonObject = new JSONObject(user);
   	 	Integer userId = Integer.parseInt(jsonObject.getString("userId"));
        return loginService.findByuserId(userId);
    }

    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("userId"));
        session.invalidate();
        return new ResponseEntity(HttpStatus.OK);
    }

	
}
