package com.br.model.Services;


import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
=======
import java.util.List;
>>>>>>> d73ba0341846460032aa3e27a8e90ef9ea7224ba
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import com.br.model.DAO.BaseInterDAO;
import com.br.model.DAO.BooksDAO;
import com.br.model.DAO.VinylRecordDAO;
import com.br.model.entity.Books;
<<<<<<< HEAD
import com.br.model.entity.Products;
=======
>>>>>>> d73ba0341846460032aa3e27a8e90ef9ea7224ba
import com.br.model.entity.VinylRecord;

public class ProductsBO<E> {
	  
	public void add(E e) {
	if(e instanceof Books) {
		BooksDAO dao = new BooksDAO();
		List<E> searchedBook = searchProducts1(e);
		if(searchedBook.isEmpty()) {
			dao.add((Books) e);
		}else throw new Exception("book already exist");
		
	}
	else{
		VinylRecordDAO dao = new VinylRecordDAO();
		List<E> searchedVinylRecord = searchProducts1(e);
		if(searchedVinylRecord.isEmpty()) {
			dao.add((VinylRecord) e);
		}else throw new Exception("book already exist");
		}
	}
	
	public void del(Products e) {
		if(e instanceof Books) {
			BooksDAO dao = new BooksDAO();
			dao.del((Books)e);
		}
		else
		{
			VinylRecordDAO dao = new VinylRecordDAO();
			dao.del((VinylRecord)e);
		}
	}
	
	public void edit(Products e) {
		if(e instanceof Books) {
			BooksDAO dao = new BooksDAO();
			dao.edit((Books)e);
		}
		else {
			VinylRecordDAO dao = new VinylRecordDAO();
			dao.edit((VinylRecord)e);
		}
	}
	

	@SuppressWarnings("unchecked")
	private List<E> searchProducts1(E e) {
		// TODO Auto-generated method stub
		if(e.getClass().getSimpleName().equals(Books.class.getSimpleName()))
			BooksDAO dao = new BooksDAO();
			ResultSet rs = dao.findAll((Books)e);
			
			List<Books> books = new ArrayList<Books>();
			
			
			
			try {
				while(rs.next()) {
					Books books = new Books();
					books.setId(rs.getInt("id_books"));
					books.setTitle(rs.getString("title"));
					books.setBooksByGender(rs.getString("gender"));
					books.setBooksByReleaseDate(rs.getString("release date"));
					books.setCopiesAmount(rs.getInt("copiesAmount"));
					books.setPagesAmount(rs.getInt("pagesAmount"));
					books.setRentPrice(rs.getInt("setRentPrice"));
					
					books.add(books);
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return (List<E>)books;
		}
			
			
		if(e.getClass().getSimpleName().equals(VinylRecord.class.getSimpleName())) {
			VinylRecordDAO dao = new VinylRecordDAO();
			ResultSet rs = dao.findAll((VinylRecord)e);
				
			List<VinylRecord> vinylRecord = new ArrayList<VinylRecord>();
				    
				
				
			try {
				while(rs.next()) {
					VinylRecord vinylRecords = new VinylRecord();
					vinylRecords.setId(rs.getInt("id_vinylRecord"));
					vinylRecords.setTitle(rs.getString("title"));
					vinylRecords.setBandsName(rs.getString("bandsName"));
					vinylRecords.setMusicalStyle(rs.getString("musical style"));
					vinylRecords.setCopiesAmount(rs.getInt("copiesAmount"));
					vinylRecords.setRentPrice(rs.getInt("setRentPrice"));
						
					vinylRecords.add(vinylRecords);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return (List<E>)vinylRecords;
				}

				return null;
			}
	
@SuppressWarnings("unchecked")
private List<E> listProducts(E e) {
	// TODO Auto-generated method stub
	if(e.getClass().getSimpleName().equals(Books.class.getSimpleName()))
		BooksDAO dao = new BooksDAO();
		ResultSet rs = dao.findAll((Books)e);
		
		List<Books> books = new ArrayList<Books>();
		
		
		
		try {
			while(rs.next()) {
				Books books = new Books();
				books.setId(rs.getInt("id_books"));
				books.setTitle(rs.getString("title"));
				books.setBooksByGender(rs.getString("gender"));
				books.setBooksByReleaseDate(rs.getString("release date"));
				books.setCopiesAmount(rs.getInt("copiesAmount"));
				books.setPagesAmount(rs.getInt("pagesAmount"));
				books.setRentPrice(rs.getInt("setRentPrice"));
				
				books.add(books);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (List<E>)books;
	}
		
		
	if(e.getClass().getSimpleName().equals(VinylRecord.class.getSimpleName())) {
		VinylRecordDAO dao = new VinylRecordDAO();
		ResultSet rs = dao.findAll((VinylRecord)e);
			
		List<VinylRecord> vinylRecord = new ArrayList<VinylRecord>();
			    
			
			
		try {
			while(rs.next()) {
				VinylRecord vinylRecords = new VinylRecord();
				vinylRecords.setId(rs.getInt("id_vinylRecord"));
				vinylRecords.setTitle(rs.getString("title"));
				vinylRecords.setBandsName(rs.getString("bandsName"));
				vinylRecords.setMusicalStyle(rs.getString("musical style"));
				vinylRecords.setCopiesAmount(rs.getInt("copiesAmount"));
				vinylRecords.setRentPrice(rs.getInt("setRentPrice"));
					
				vinylRecords.add(vinylRecords);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return (List<E>)vinylRecords;
			}

			return null;
		}	
	


	private List<E> searchProducts(E e) {
		// TODO Auto-generated method stub
		return null;
	}

}
