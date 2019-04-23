package com.tourism.model;

public class Doctor {
	
	private int doctorID;
	private int hospitalID;
	private String availability;
	private String specialization;
	private String name;

	public Doctor() {

	}

	public Doctor(int hospitalID, String availability, String specialization) {
		this.hospitalID = hospitalID;
		this.availability = availability;
		this.specialization = specialization;
	}

	public Doctor(int doctorID, String name, String availability, String specialization) {
		this.doctorID = doctorID;
		this.name = name;
		this.availability = availability;
		this.specialization = specialization;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Doctor [hospitalID=" + hospitalID + ", availability=" + availability + ", specialization="
				+ specialization + ", name=" + name + "]";
	}
}
