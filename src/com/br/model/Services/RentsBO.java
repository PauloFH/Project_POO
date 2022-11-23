package com.br.model.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import com.br.model.DAO.BaseInterDAO;
import com.br.model.DAO.RentsDAO;
import com.br.model.entity.Books;
import com.br.model.entity.Products;
import com.br.model.entity.Rents;
import com.br.model.entity.VinylRecord;

public class RentsBO implements BaseInterDAO<Rents> {
	BaseInterDAO<Rents> rent = new RentsBO();


	public boolean add(Rents e) {
		RentsDAO dao = new RentsDAO(); 
		if(e.getClient().getCpf() != null && e.getName() != null && e.getQtA() > 0 && e.getRentDate() != null) {
			Books book = new Books();
			book.setTitle(e.getName());
			VinylRecord disc = new VinylRecord();
			disc.setTitle(e.getName());
			ProductsBO<Books> BooksBO = new ProductsBO<Books>();
			ProductsBO<VinylRecord> vinProductsBO = new ProductsBO<VinylRecord>();
			List<Books> lsbooks = BooksBO.
			
			
		}
		
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
