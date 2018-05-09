package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.LoginInResponse;
import com.entity.Response;
import com.entity.tbllogin;
import com.repository.tblloginRepository;

@Service
public class LoginService {
	@Autowired 
	private tblloginRepository tblloginRepository;
	
    public Iterable<tbllogin> getAllUsers(){
        return tblloginRepository.findAll();
    }

    public Iterable<tbllogin> findByuserId(Integer userId){
        return tblloginRepository.findByuserId(userId);
    }

    
    public LoginInResponse addUser(tbllogin user){
    	tblloginRepository.save(user);
		return signInResponse;
    }
    
    Response response = new Response();
    LoginInResponse signInResponse = new LoginInResponse();

    public LoginInResponse login(String userEmail,String userPassword){
        try{
        	HttpSession session = null;
            tbllogin user =  tblloginRepository.findUsersByUserEmailAndUserPassword(userEmail,userPassword);
            if(user==null){

                response.setStatus("error");
                response.setMsg("Email / Password may wrong.");
                signInResponse.setUsers(null);
                signInResponse.setResponse(response);
                return signInResponse;
            }
            else{
                response.setStatus("success");
                response.setMsg("Successfully Logged In with "+user.getUserEmail());
				session.setAttribute("userId",user.getUserId());
                signInResponse.setUsers(user);
                signInResponse.setResponse(response);
                return signInResponse;
            }
        }
        catch(Exception e){
            response.setStatus("error");
            response.setMsg("Something went wrong, Try Again.");
            signInResponse.setResponse(response);
            return signInResponse;
        }
    }
    
    public Response editProfile(JSONObject userData) {
    	try {
    		int userId = Integer.parseInt(userData.getString("userId"));
    		tbllogin user = tblloginRepository.findOne(userId);
    		user.setAboutUser(userData.getString("aboutUser"));
    		user.setProfessionalHeading(userData.getString("professionalHeading"));
    		user.setSkills(userData.getString("skills"));
    		user.setProfilePic(userData.getString("profilePic"));
    		user.setUserPhone(userData.getString("userPhone"));
    		tblloginRepository.save(user);
    		response.setStatus("Success");
            response.setMsg("User Profile updated");
    	}
    	catch(Exception e){
            response.setStatus("error");
            response.setMsg("Something went wrong, Try Again.");
            signInResponse.setResponse(response);
        }
		return response;
    }
    
}
