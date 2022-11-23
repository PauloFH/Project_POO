package com.br.model.Services;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.br.model.DAO.BooksDAO;

import java.sql.SQLException;

import com.br.model.DAO.VinylRecordDAO;
import com.br.model.entity.Books;
import com.br.model.entity.Products;
import com.br.model.entity.VinylRecord;

public class ProductsBO<E> {

	public void add(E e) throws Exception {
		if (e instanceof Books) {
			BooksDAO dao = new BooksDAO();
			List<E> searchedBook = searchProducts(e);
			if (searchedBook.isEmpty()) {
				dao.add((Books) e);
			} else
				throw new Exception("book already exist");

		} else {
			VinylRecordDAO dao = new VinylRecordDAO();
			List<E> searchedVinylRecord = searchProducts(e);
			if (searchedVinylRecord.isEmpty()) {
				dao.add((VinylRecord) e);
			} else
				throw new Exception("book already exist");
		}
	}

	public void del(Products e) {
		if (e instanceof Books) {
			BooksDAO dao = new BooksDAO();
			dao.del((Books) e);
		} else {
			VinylRecordDAO dao = new VinylRecordDAO();
			dao.del((VinylRecord) e);
		}
	}

	public void edit(Products e) {
		if (e instanceof Books) {
			BooksDAO dao = new BooksDAO();
			dao.edit((Books) e);
		} else {
			VinylRecordDAO dao = new VinylRecordDAO();
			dao.edit((VinylRecord) e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> searchProducts(E entity) {
		// TODO Auto-generated method stub
		if (entity.getClass().getSimpleName().equals(Books.class.getSimpleName())) {
			BooksDAO dao = new BooksDAO();
			ResultSet rs = dao.findAll((Books) entity);


			List<Books> books = new ArrayList<Books>();

			try {
				while (rs.next()) {
					Books bk = new Books();
					bk.setId(rs.getInt("id_books"));
					bk.setTitle(rs.getString("title"));
					bk.setGender(rs.getString("gender"));
					bk.setReleaseDate(rs.getString("release date"));
					bk.setCopiesAmount(rs.getInt("copiesAmount"));
					bk.setPagesAmount(rs.getInt("pagesAmount"));
					bk.setRentPrice(rs.getInt("setRentPrice"));

					books.add(bk);
					;

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return (List<E>) books;
		}

		if (entity.getClass().getSimpleName().equals(VinylRecord.class.getSimpleName())) {
			VinylRecordDAO dao = new VinylRecordDAO();
			ResultSet rs = dao.findAll((VinylRecord) entity);

			List<VinylRecord> vinylRecords = new ArrayList<VinylRecord>();

			try {
				while (rs.next()) {
					VinylRecord vinylRecord = new VinylRecord();
					vinylRecord.setId(rs.getInt("id_vinylRecord"));
					vinylRecord.setTitle(rs.getString("title"));
					vinylRecord.setBandsName(rs.getString("bandsName"));
					vinylRecord.setMusicalStyle(rs.getString("musical style"));
					vinylRecord.setCopiesAmount(rs.getInt("copiesAmount"));
					vinylRecord.setRentPrice(rs.getInt("setRentPrice"));

					vinylRecords.add(vinylRecord);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return (List<E>) vinylRecords;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<E> listProducts(E entity) {
	// TODO Auto-generated method stub
	if(entity.getClass().getSimpleName().equals(Books.class.getSimpleName())) {
		BooksDAO dao = new BooksDAO();
		ResultSet rs = dao.findAll((Books)entity);
		
		List<Books> books = new ArrayList<Books>();
		
		
		
		try {
			while(rs.next()) {
				Books book = new Books();
				book.setId(rs.getInt("id_book"));
				book.setTitle(rs.getString("title"));
				book.setGender(rs.getString("gender"));
				book.setReleaseDate(rs.getString("release date"));
				book.setCopiesAmount(rs.getInt("copiesAmount"));
				book.setPagesAmount(rs.getInt("pagesAmount"));
				book.setRentPrice(rs.getInt("setRentPrice"));
				
				books.add(book);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (List<E>)books;
	}

	if(entity.getClass().getSimpleName().equals(VinylRecord.class.getSimpleName()))

	{
		VinylRecordDAO dao = new VinylRecordDAO();
		ResultSet rs = dao.findAll((VinylRecord) entity);

		List<VinylRecord> vinylRecords = new ArrayList<VinylRecord>();

		try {
			while (rs.next()) {
				VinylRecord vinylRecord = new VinylRecord();
				vinylRecord.setId(rs.getInt("id_vinylRecord"));
				vinylRecord.setTitle(rs.getString("title"));
				vinylRecord.setBandsName(rs.getString("bandsName"));
				vinylRecord.setMusicalStyle(rs.getString("musical style"));
				vinylRecord.setCopiesAmount(rs.getInt("copiesAmount"));
				vinylRecord.setRentPrice(rs.getInt("setRentPrice"));

				vinylRecords.add(vinylRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List<E>) vinylRecords;
	}

	return null;
	}


}
