package com.example.demo.Model;

import javax.persistence.Entity;


public class ResultEntity {


	public String message;
	
	public Boolean status; 
	
	public ResultEntity(String message, Boolean status) {
		this.message = message;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ResultEntity [message=" + message + ", status=" + status + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

		
}
