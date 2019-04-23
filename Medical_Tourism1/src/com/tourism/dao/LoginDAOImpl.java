package com.tourism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tourism.util.ConnectionManager;
import com.tourism.model.Login;

public class LoginDAOImpl implements LoginDAO {
	
	private ConnectionManager connectionManager;
	private Connection connection;
	public LoginDAOImpl(){
		connectionManager = new ConnectionManager();
	}
	
	public String validateUser(String email, String password) throws SQLException{
		String sql = "SELECT user_type FROM login WHERE email_id=? AND password=?";
		String type = null;
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				type = rs.getString("user_type");
			}
				
			stmt.close();
		}
		finally{
			connectionManager.disconnect();
		}
		
		return type;
	}

	@Override
	public int saveUser(Login login) throws SQLException {
		String sql = "INSERT INTO login (user_id, hospital_id, email_id, password, user_type)"
				+" VALUES (?,null,?,?,?)";
		int save = 0;
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, login.getUserid());
			stmt.setString(2, login.getEmail());
			stmt.setString(3, login.getPassword());
			stmt.setString(4, login.getUserType());
			save = stmt.executeUpdate();
		}
		finally{
			connectionManager.disconnect();
		}
		return save;
	}
	
	@Override
	public int saveHospital(Login login) throws SQLException {
		String sql = "INSERT INTO login (user_id, hospital_id, email_id, password, user_type)"
				+" VALUES (null,?,?,?,?)";
		int save = 0;
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, login.getHospitalid());
			stmt.setString(2, login.getEmail());
			stmt.setString(3, login.getPassword());
			stmt.setString(4, login.getUserType());
			save = stmt.executeUpdate();
		}
		finally{
			connectionManager.disconnect();
		}
		return save;
	}
	
	@Override
	public int getHospitalID(String username) throws SQLException {
		String sql = "SELECT hospital_id FROM login WHERE email_id=?";
		int id = 0 ;
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				id=rs.getInt(1);
			}
		}finally{
			connectionManager.disconnect();
		}
		return id;
	}
	
	@Override
	public int getUserID(String username) throws SQLException {
		String sql = "SELECT user_id FROM login WHERE email_id=?";
		int id = 0 ;
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				id=rs.getInt(1);
			}
		}finally{
			connectionManager.disconnect();
		}
		return id;
	}
}
