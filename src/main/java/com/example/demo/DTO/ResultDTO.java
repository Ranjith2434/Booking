package com.example.demo.DTO;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class ResultDTO {

	public Boolean status;	
	
	public String message;	

	public Boolean getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "ResultDTO [status=" + status + ", message=" + message + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultDTO other = (ResultDTO) obj;
		return Objects.equals(message, other.message) && Objects.equals(status, other.status);
	}
	
	
	
}
