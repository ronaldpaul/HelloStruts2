package com.ronald.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class Hello extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	public String execute()  {
		return SUCCESS;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public void validate(){
		if (name == null || name.trim().equals("")) {
			addFieldError("name", "Name is required");
		}
	}
	
}