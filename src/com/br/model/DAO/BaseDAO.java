package com.br.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.model.DAO.Inter_Client.BaseInterDAO;

public class BaseDAO<entity> implements BaseInterDAO<entity> {
	private Connection con;
	
	synchronized public Connection getConnection() {
		if(con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/","sql10526105","QA8b6k86SJ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
			
		}else return con;

	}
	@Override
	public boolean add(entity e) {
		return false;
	}
	@Override
	public boolean del(entity e) {
		return false;
	}
	@Override
	public boolean edit(entity e) {
		return false;
	}
	@Override
	public entity findById(entity e) {
		return null;
	}
	@Override
	public ResultSet findAll() {
		
		return null;
	}
	@Override
	public ResultSet findBySpecifiedField(entity e, String field) {

		return null;
	}

	
	
	
}