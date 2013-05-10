package com.ijoshluisaac.models;

public class ResumeModel {
	 
	String name;
	String email;
	String about;
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getAbout() {
		return about;
	}
 
	public void setAbout(String about) {
		this.about = about;
	}
 
	@Override
	public String toString() {
		return "Message [name=" + name + ", email=" + email + ",about=" + about + "]";
	}
 
}
