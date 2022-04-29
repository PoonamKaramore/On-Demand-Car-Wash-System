package com.carwash.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("ratings")
public class RatingsAndReview {
	
	private String washerName;
	private int rating;
	private String comment;
	
	
	//default constructor
	public RatingsAndReview() {
		
	}

	//constructor
	public RatingsAndReview(String washerName, int rating, String comment) {
		super();
		this.washerName = washerName;
		this.rating = rating;
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	
	
}
	
	
	