package com.br.model.DAO;


import java.sql.Connection;
import java.sql.ResultSet;

public interface BaseInterDAO<entity> {
		public Connection getConnection();
		public boolean add (entity e);
		public boolean del(entity e);
		public boolean edit(entity e);
		public entity findById(entity e);
		public ResultSet findAll();
		public ResultSet findBySpecifiedField(entity e, String field);
	}

