package com.model;

public class ContactPojo {
	private int sn;
	private String name;
	private String email;
	private String Subject;
	private String message;
	private String datetime;
	public ContactPojo(int sn, String name, String email, String subject, String message, String datetime) {
		super();
		this.sn = sn;
		this.name = name;
		this.email = email;
		Subject = subject;
		this.message = message;
		this.datetime = datetime;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
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
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "ContactPojo [sn=" + sn + ", name=" + name + ", email=" + email + ", Subject=" + Subject + ", message="
				+ message + ", datetime=" + datetime + "]";
	}
	
	
}
