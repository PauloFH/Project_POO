package com.br.model.Services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.br.exception.RegisterRentException;
import com.br.model.DAO.BaseInterDAO;
import com.br.model.DAO.BooksDAO;
import com.br.model.DAO.RentsDAO;
import com.br.model.DAO.VinylRecordDAO;
import com.br.model.entity.Books;
import com.br.model.entity.Clients;
import com.br.model.entity.Rents;
import com.br.model.entity.VinylRecord;

public class RentsBO implements BaseInterDAO<Rents> {
	BaseInterDAO<Rents> rent = new RentsBO();


	public boolean add(Rents rent) {

		RentsDAO dao = new RentsDAO();
		if(rent.getClient().getCpf() != null && rent.getTitle() != null && rent.getGetTotalRents() > 0 && rent.getRentDate() != null && rent.getPrice() > 0) {
			VinylRecord vinyl = new VinylRecord();
			Books book = new Books();
			vinyl.setTitle(rent.getTitle());
			book.setTitle(rent.getTitle());

			ClientsBO client = new ClientsBO();
			BooksDAO books = new BooksDAO();
			VinylRecordDAO vinylDAO = new VinylRecordDAO();

			List<Clients> rslist = new ArrayList<Clients>();
			List<Clients> clientList = client.searchname(rent.getClient());
			ProductsBO<Books> bookBO = new ProductsBO<Books>();
			ProductsBO<VinylRecord> vinylBO = new ProductsBO<VinylRecord>();
			List<Books> listBooks = books.findBySpecifiedField(book, "title");
			List<VinylRecord> listVinyl = vinylDAO.findBySpecifiedField(vinyl, "title");

			if(!clientList.isEmpty()) {
				if(clientList.get(0).getCpf().equals(rent.getClient().getCpf())) {
					if(!listBooks.isEmpty()) {
						rent.setBook(listBooks.get(0));
						if(rent.getBook().getCopiesAmount() - rent.getGetTotalRents() >= 0) {
							dao.add(rent);
							rent.getBook().setCopiesAmount(rent.getBook().getCopiesAmount() - rent.getGetTotalRents());
							bookBO.edit(rent.getBook());

							//aq vai gerar o pdf
						}
						
					}}
				}
				else if(!listVinyl.isEmpty()) {
					rent.setVinyl(listVinyl.get(0));
					if(rent.getVinyl().getCopiesAmount() - rent.getGetTotalRents() >= 0) {
						dao.add(rent);
						rent.getVinyl().setCopiesAmount(rent.getVinyl().getCopiesAmount() - rent.getGetTotalRents());
						vinylBO.edit(rent.getVinyl());
						
						//pdf aluguel
					}else {
						throw new RegisterRentException();
					}
					
				}
			}

		}

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
		RentsDAO rentsDAO = new RentsDAO();
		
		return rentsDAO.del(e);
	}


	public boolean edit(Rents e) {
		// TODO Auto-generated method stub
		RentsDAO dao = new RentsDAO();
		return dao.edit(e);
	}


	@Override
	public ResultSet findAll(Books book) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultSet findAll(VinylRecord vinyl) {
		// TODO Auto-generated method stub
		return null;
	}
}
