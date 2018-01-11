package prs.domain;

import java.time.LocalDate;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;


@Entity
public class PurchaseRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userID;
	private String description;
	private String justification;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp dateNeeded;
	private String deliveryMode;
	private int statusID;
	private double total;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp submittedDate;
	
	public PurchaseRequest(int id, int userID, String description, String justification, Timestamp dateNeeded, String deliveryMode,
			int statusID, double total, Timestamp submittedDate) {
		super();
		this.id = id;
		this.userID = userID;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.statusID = statusID;
		this.total = total;
		this.submittedDate = submittedDate;
	}
	
	public PurchaseRequest() {
		id = 0;
		userID=0;
		description = "";
		justification = "";
		dateNeeded = new Timestamp(System.currentTimeMillis());
		deliveryMode = "";
		statusID = 0;
		total = 0.0;
		submittedDate = new Timestamp(System.currentTimeMillis());
	}

	public Timestamp getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(Timestamp dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public Timestamp getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "PurchaseRequest [id=" + id + ", userID=" + userID + ", "
				+ "description=" + description + ", justification="
				+ justification + ", dateNeeded=" + dateNeeded + ", deliveryMode=" + deliveryMode + ", statusID=" + statusID
				+ ", total=" +total + ", submittedDate=" + submittedDate + 
				"]\n";
		
		//@Override
		//public String toString() {
		//	return "PurchaseRequest [id=" + id + ", user=" + user + ", description=" + description + ", justification="
		//			+ justification + ", dateNeeded=" + dateNeeded + ", deliveryMode=" + deliveryMode + ", status=" + status
		//			+ ", total=" +total + ", submittedDate=" + submittedDate +"]\n";
	}



}	
	