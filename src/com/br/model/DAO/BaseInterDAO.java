package com.br.model.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.br.model.entity.Books;

import com.br.model.entity.Books;
import com.br.model.entity.VinylRecord;

public interface BaseInterDAO<entity> {
		public Connection getConnection();
		public boolean add (entity e);
		public boolean del(entity e);
		public boolean edit(entity e);
		public entity findById(entity e);
		public ResultSet findAll(Books book);
		public ResultSet findAll(VinylRecord vinyl);
		public ResultSet findBySpecifiedField(entity e, String field);
		public ResultSet findAll();
	}

