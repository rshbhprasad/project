package com.tourism.model;

public class Appointment {
	
	private int user_id;
	private int hospital_id;
	private String timeSlot;
	private String dateOfAppointment;
	
	
	public Appointment(int user_id, int hospital_id, String timeSlot, String dateOfAppointment) {
		this.user_id = user_id;
		this.hospital_id = hospital_id;
		this.timeSlot = timeSlot;
		this.dateOfAppointment = dateOfAppointment;
	}
	public Appointment() {

	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	
	
}
