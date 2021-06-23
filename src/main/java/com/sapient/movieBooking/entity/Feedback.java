package com.sapient.movieBooking.entity;

public class Feedback {
	private int fId; 
	private String type; 
	private String comment; 
	private String status; 
	
	public Feedback() {
	}

	public Feedback(int fId, String type, String comment, String status) {
		super();
		this.fId = fId;
		this.type = type;
		this.comment = comment;
		this.status = status;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Feedback [fId=" + fId + ", type=" + type + ", comment=" + comment + ", status=" + status + "]";
	}
	
	
}
