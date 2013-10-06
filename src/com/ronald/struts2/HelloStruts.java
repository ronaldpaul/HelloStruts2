package com.ronald.struts2;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.crypto.provider.DESParameters;

import org.apache.commons.io.FileUtils;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;

public class HelloStruts extends ActionSupport {

	private String message;
	
	private File file;
	private String myFileContentType;
	private String myFileName;
	private String destPath;
	
	public String execute() throws Exception {
		
		destPath = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/HelloStruts2/WEB-INF";
		
		try {
			
			System.out.println("Source file name is : " + file);
			System.out.println("Destination file name is : " + myFileName);
			System.out.println("File type is : " + myFileContentType);
			
			File destFile = new File(destPath, myFileName);
			FileUtils.copyFile(file, destFile);
			
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, String> context = new HashMap<String, String>();
		context.put("keys1", new String("This is key 1"));
		context.put("keys2", new String("This is key 2"));
		stack.push(context);
		
		System.out.println("Size of the stack : " + stack.size());
		
		return SUCCESS;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @return the myFileContentType
	 */
	public String getMyFileContentType() {
		return myFileContentType;
	}

	/**
	 * @return the myFileName
	 */
	public String getMyFileName() {
		return myFileName;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @param myFileContentType the myFileContentType to set
	 */
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	/**
	 * @param myFileName the myFileName to set
	 */
	public void setMyFileName(String myFileName) {
		this.myFileName = myFileName;
	}

}