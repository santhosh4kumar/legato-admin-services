package com.legato.admin.services.view.response;

import java.util.Date;

public class SimpleResponseEntity {
	private Date date;
	private int statusCode;
	private String statusMessage;
	private Object data;

	public SimpleResponseEntity() {
		this.date = new Date();
		this.statusCode = 200;
		this.statusMessage = "Success";
	}

	public SimpleResponseEntity(int statusCode, String statusMessage, Object data) {
		this();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.data = data;
	}
	
	public SimpleResponseEntity(Object data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}