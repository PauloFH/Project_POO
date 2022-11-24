package com.br.model.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.br.api.DTO.BookDTO;
import com.br.api.DTO.VinylRecordDTO;
import com.br.model.DAO.BaseInterDAO;
import com.br.model.DAO.BooksDAO;
import com.br.model.DAO.RentsDAO;
import com.br.model.DAO.RentsInterDAO;
import com.br.model.DAO.VinylRecordDAO;
import com.br.model.entity.Books;
import com.br.model.entity.Clients;
import com.br.model.entity.Rents;
import com.br.model.entity.VinylRecord;

public class RentsBO implements RentsInterDAO<Rents>, BaseInterDAO<Rents> {
	BaseInterDAO<Rents> rent = new RentsBO();


	public boolean add(Rents rent) {
		BooksBO bo = new BooksBO();
		RentsDAO dao = new RentsDAO();
		if(rent.getClient().getCpf() != null && rent.getTitle() != null && rent.getGetTotalRents() > 0 && rent.getRentDate() != null && rent.getPrice() > 0) {
			VinylRecordDTO vinyl = new VinylRecordDTO();
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
			List<Books> listBooks = bo.getByTitle(book);
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
						}else {
							
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
						
					}
					
				}
			}
		return false;

		}

	public void registerDevolution(Rents rent) {
		RentsDAO dao = new RentsDAO();
		if(rent.getClient().getCpf() != null && rent.getTitle() != null && rent.getDevolutionDate() != null) {
			dao.registerDevolution(rent);
			
			Books book = new Books();
			VinylRecord vinyl = new VinylRecord();
			book.setTitle(rent.getTitle());
			vinyl.setTitle(rent.getTitle());
			
			ProductsBO<Books> bookBO = new ProductsBO<Books>();
			ProductsBO<VinylRecord> vinylBO = new ProductsBO<VinylRecord>();
			List<Books> listBooks = bookBO.searchProducts(book);
			List<VinylRecord> listVinyl = vinylBO.searchProducts(vinyl);
			
			ResultSet rentDevolution = findRentDevolution(rent);
			
			if(!listBooks.isEmpty()) {
				listBooks.get(0).setCopiesAmount(listBooks.get(0).getCopiesAmount() + rentDevolution.get(0).getGetTotalRents());
				bookBO.edit(listBooks.get(0));
			}else if(!listVinyl.isEmpty()) {
				listVinyl.get(0).setCopiesAmount(listVinyl.get(0).getCopiesAmount() + rentDevolution.get(0).getGetTotalRents());
				vinylBO.edit(listVinyl.get(0));
			}
			
		}
	}
	public List<Rents> findRent(Calendar initialDate, Calendar finalDate){
	    RentsDAO dao = new RentsDAO();
	    ResultSet rs = dao.findRent(initialDate, finalDate);

	    List<Rents> rents = new ArrayList<Rents>();
	    try{
	        while(rs.next()){
	            Calendar date1 = Calendar.getInstance();
	            Calendar date2 = Calendar.getInstance();
	            Rents rent = new Rents();
	            Clients client = new Clients();
	            client.setCpf(rs.getString("Cpf_cliente"));
	            rent.setClient(client);
	            rent.setTitle(rs.getString("title"));
	            rent.setCopiesAmount(rs.getInt("copiesAmount"));
	            date1.setTime(rs.getDate("initialDate"));
	            rent.setRentDate(date1);
	            date2.setTime(rs.getDate("finalDate"));
	            rent.setDevolutionDate(date2);
	            rent.setPrice(rs.getDouble("price"));
	            rents.add(rent);

	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return rents;
	}
	
	@Override
	public List<Rents> findRentClient(Rents rent, Calendar initialDate, Calendar finalDate){
	    RentsDAO dao = new RentsDAO();
	    ResultSet rs = dao.findRentClient(rent, initialDate, finalDate);

	    List<Rents> rents = new ArrayList<Rents>();
	    try{
	        while(rs.next()){
	            Calendar date1 = Calendar.getInstance();
	            Calendar date2 = Calendar.getInstance();
	            Rents rent1 = new Rents();
	            Clients client = new Clients();
	            client.setCpf(rs.getString("Cpf_cliente"));
	            rent.setClient(client);
	            rent.setTitle(rs.getString("title"));
	            rent.setCopiesAmount(rs.getInt("copiesAmount"));
	            date1.setTime(rs.getDate("initialDate"));
	            rent.setRentDate(date1);
	            date2.setTime(rs.getDate("finalDate"));
	            rent.setRentDate(date2);
	            rent.setPrice(rs.getDouble("price"));
	            System.out.println(date1.getTime());
	            System.out.println(date2.getTime());
	            rents.add(rent1);

	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return rents;
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
	public Rents findById(Rents e) {
		// TODO Auto-generated method stub
		return null;
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


	@Override
	public ResultSet findBySpecifiedField(Rents e, String field) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultSet findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Rents> findRent() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultSet findRentDevolution(Rents e) {
		// TODO Auto-generated method stub
		return null;
	}



}
