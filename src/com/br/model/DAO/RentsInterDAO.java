package com.br.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import com.br.exception.RegisterRentException;

public interface RentsInterDAO<entity> {
	public Connection getConnection();
	public boolean add (entity e) throws RegisterRentException;
	public boolean del(entity e);
	public boolean edit(entity e);
	public void registerDevolution(entity e);
	public ResultSet findRentDevolution(entity e);
}
