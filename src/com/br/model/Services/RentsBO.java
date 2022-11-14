package com.br.model.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import com.br.model.DAO.BaseInterDAO;
import com.br.model.entity.Rents;

public class RentsBO implements BaseInterDAO<Rents> {
	BaseInterDAO<Rents> rent = new RentsBO();


	public boolean add(Rents e) {
		// TODO Auto-generated method stub
		return false;
	}


	public Rents findById(Rents e) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultSet findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultSet findBySpecifiedField(Rents e, String field) {
		// TODO Auto-generated method stub
		return null;
	}


	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean del(Rents e) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean edit(Rents e) {
		// TODO Auto-generated method stub
		return false;
	}
}
