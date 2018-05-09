package com.entity;


public class LoginInResponse {
	 static Response response;
	    tbllogin users;

	    public Response getResponse() {
	        return response;
	    }

	    public void setResponse(Response response) {
	        LoginInResponse.response = response;
	    }

	    public tbllogin getUsers() {
	        return users;
	    }

	    public void setUsers(tbllogin users) {
	        this.users = users;
	    }
}
