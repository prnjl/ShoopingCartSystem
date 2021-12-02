package com.casestudy.Profile.Service.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserProfile {
	 private String fullname;
	  private String profileId;
	  private String image;
	  private String email;
	  private Long mobileNumber;
	  private String about;
	  @JsonFormat(pattern="yyyy-MM-dd") 
	  private LocalDate dateOfBirth;
	  private String gender;
	  private Role role;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserProfile(String fullname, String profileId, String image, String email, Long mobileNumber, String about,
			LocalDate dateOfBirth, String gender, Role role) {
		super();
		this.fullname = fullname;
		this.profileId = profileId;
		this.image = image;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.about = about;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.role = role;
	}
	public UserProfile() {
		super();
	}
	@Override
	public String toString() {
		return "UserProfile [fullname=" + fullname + ", profileId=" + profileId + ", image=" + image + ", email="
				+ email + ", about=" + about + ", gender=" + gender + "]";
	}
	  
	  

}
