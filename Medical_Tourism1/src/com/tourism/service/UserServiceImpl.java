package com.tourism.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism.dao.UserDAO;
import com.tourism.dao.UserDAOImpl;
import com.tourism.model.User;
import com.tourism.model.Appointment;
import com.tourism.model.Doctor;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	private String day[] = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
	
	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addUser1.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	public int saveUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		int zip = Integer.parseInt(request.getParameter("zip"));
		User user = new User(firstname,lastname,age,gender,contact,address,city,zip);
		int id = userDAO.save(user);
		return id;
	}

	@Override
	public void userPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/appointment.jsp");
		requestDispatcher.forward(request, response);		
	}

	@Override
	public void appointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException {
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int odd = c.get(Calendar.DAY_OF_WEEK);
		List<Doctor> list = userDAO.getDoctorList(day[odd-1]);
		request.setAttribute("time", time);
		request.setAttribute("list", list);
		request.setAttribute("date", date);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/appoint.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int hospital_id = Integer.parseInt(request.getParameter("id"));
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		int user_id = (int) request.getSession().getAttribute("id");
		Appointment appointment = new Appointment(user_id, hospital_id, time, date);
		try{
			int save = userDAO.saveAppointment(appointment);
			if(save==1){
				response.sendRedirect("/Medical_Tourism1/user?added=Appointment booked");
			}
			else{
				response.sendRedirect("/Medical_Tourism1/user?alert=Doctor not available for current date and time");
			}
		}
		catch(SQLException e){
			response.sendRedirect("/Medical_Tourism1/user?alert=Doctor not available for current date and time");
		}
	}
}
