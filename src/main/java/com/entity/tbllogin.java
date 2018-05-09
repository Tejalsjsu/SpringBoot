package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // tells the spring to creat a table out of this
public class tbllogin {
	  	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer userId;
	    private String userName;
	    private String userEmail;
	    private String userPassword;
	    private String userPhone;
	    private String aboutUser;
	    private String profilePic;
	    private String professionalHeading;
	    private String skills;
	    
		public String getUserPhone() {
			return userPhone;
		}
		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}
		public String getAboutUser() {
			return aboutUser;
		}
		public void setAboutUser(String aboutUser) {
			this.aboutUser = aboutUser;
		}
		public String getProfilePic() {
			return profilePic;
		}
		public void setProfilePic(String profilePic) {
			this.profilePic = profilePic;
		}
		public String getProfessionalHeading() {
			return professionalHeading;
		}
		public void setProfessionalHeading(String professionalHeading) {
			this.professionalHeading = professionalHeading;
		}
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

}
