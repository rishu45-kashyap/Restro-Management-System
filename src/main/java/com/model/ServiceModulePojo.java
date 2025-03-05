package com.model;

public class ServiceModulePojo {
	private int Sn;
	private String  iconname;
	private String  title;
	private  String description;
	private String datetime;
	public ServiceModulePojo(int sn, String iconname, String title, String description, String datetime) {
		super();
		Sn = sn;
		this.iconname = iconname;
		this.title = title;
		this.description = description;
		this.datetime = datetime;
	}
	public int getSn() {
		return Sn;
	}
	public void setSn(int sn) {
		Sn = sn;
	}
	public String getIconname() {
		return iconname;
	}
	public void setIconname(String iconname) {
		this.iconname = iconname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "ServiceModulePojo [Sn=" + Sn + ", iconname=" + iconname + ", title=" + title + ", description="
				+ description + ", datetime=" + datetime + "]";
	}
	

}
