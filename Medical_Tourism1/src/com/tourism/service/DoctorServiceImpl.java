package com.tourism.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism.dao.DoctorDAO;
import com.tourism.dao.DoctorDAOImpl;
import com.tourism.model.Doctor;

public class DoctorServiceImpl implements DoctorService {
	
	private DoctorDAO doctorDAO;
	
	public DoctorServiceImpl(){
		doctorDAO = new DoctorDAOImpl();
	}

	@Override
	public void addDoctor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String specialization = request.getParameter("sp");
		String availability = request.getParameter("day");
		int hospitalID = (int) request.getSession().getAttribute("id");
		Doctor doctor = new Doctor(hospitalID,availability,specialization);
		int save = doctorDAO.save(doctor);
		if(save==1){
			response.sendRedirect("/Medical_Tourism1/hospital?added=Doctor added successfully");
		}
	}
}
