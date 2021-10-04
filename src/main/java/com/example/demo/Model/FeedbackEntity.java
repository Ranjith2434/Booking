package com.example.demo.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FeedbackTbl")
public class FeedbackEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;
	
	@Column(name = "user_id")
	public Long userId;
	
	@Column(name = "booking_id")
	public Long bookingId;
	
	@Column(name = "rating")
	public String rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		rating = rating;
	}

	@Override
	public String toString() {
		return "FeedbackEntity [id=" + id + ", userId=" + userId + ", bookingId=" + bookingId + ", Rating=" + rating
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(rating, bookingId, id, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackEntity other = (FeedbackEntity) obj;
		return Objects.equals(rating, other.rating) && Objects.equals(bookingId, other.bookingId)
				&& Objects.equals(id, other.id) && Objects.equals(userId, other.userId);
	}

}
