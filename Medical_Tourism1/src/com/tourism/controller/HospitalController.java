package com.tourism.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism.service.DoctorService;
import com.tourism.service.DoctorServiceImpl;
import com.tourism.service.HospitalService;
import com.tourism.service.HospitalServiceImpl;

/**
 * Servlet implementation class HospitalController
 */
//@WebServlet("/HospitalController")
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private HospitalService hospitalService;
	private DoctorService doctorService;
	
	public void init() {
		hospitalService = new HospitalServiceImpl();
		doctorService = new DoctorServiceImpl();
	}
	
    public HospitalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		try{
			switch(url){
			case "/hospital" :
				hospitalService.hospitalPage(request,response);
				break;
			case "/hospital/add":
				doctorService.addDoctor(request,response);
				break;
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
