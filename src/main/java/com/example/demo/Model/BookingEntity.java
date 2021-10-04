package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BookingTbl")
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;	

	@Column(name = "booking_name")
	public String bookingName;
	
	@Column(name = "status")
	public String status; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingName() {
		return bookingName;
	}

	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
