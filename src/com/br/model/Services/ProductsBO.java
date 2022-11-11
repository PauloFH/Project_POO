package com.br.model.Services;

import java.util.List;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import com.br.model.DAO.BaseInterDAO;
import com.br.model.DAO.BooksDAO;
import com.br.model.DAO.VinylRecordDAO;
import com.br.model.entity.Books;
import com.br.model.entity.VinylRecord;

public class ProductsBO<E> {
	  
	public void add(E e) throws Exception {
	if(e instanceof Books) {
		BooksDAO dao = new BooksDAO();
		List<E> searchedBook = searchProducts(e);
		if(searchedBook.isEmpty()) {
			dao.add((Books) e);
		}else throw new Exception("book already exist");
		
	}
	else{
		VinylRecordDAO dao = new VinylRecordDAO();
		List<E> searchedVinylRecord = searchProducts(e);
		if(searchedVinylRecord.isEmpty()) {
			dao.add((VinylRecord) e);
		}else throw new Exception("book already exist");
		}
	}
	

	private List<E> searchProducts(E e) {
		// TODO Auto-generated method stub
		return null;
	}
}
