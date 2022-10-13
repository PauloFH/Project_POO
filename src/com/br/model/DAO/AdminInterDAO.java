package com.br.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import com.br.model.entity.Administrators;

public interface AdminInterDAO {
	public Connection getConnection();
	public boolean add (Administrators e);
	public boolean del(Administrators e);
	public boolean edit(Administrators e);
	public Administrators findById(Administrators e);
	public ResultSet findAll();
	public ResultSet findBySpecifiedField(Administrators e, String field);
	public ResultSet findByUserAndPassword(String user, String password);
}
