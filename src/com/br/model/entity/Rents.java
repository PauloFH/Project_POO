package com.br.model.entity;

import java.sql.Date;
import java.util.Calendar;

public class Rents extends Products {
  private int id;
  private Clients client;
  private Books book;
  private Products product;
  private VinylRecord vinyl;
  private Calendar rentDate;
  private Calendar devolutionDate;
  private Double price;
  private boolean devolution;
  
  public int getId() {
    return this.id;
  }
 
  public void setId(int id) {
    if (id < 0) {
      System.out.println("Id tem que ser positivo");
    } else {
      this.id = id;
    }
  }

  public Clients getClient() {
    return this.client;
  }

  public void setClient(Clients client) {
    if (client == null) {
      System.out.println("Por favor, digite o nome do cliente");
    } else {
      this.client = client;
    }
  }


  public Calendar getDate() {
	return rentDate;
  }

  public void setDate( Calendar rentDate) {
	this.rentDate = rentDate;
  }

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	if (price > 0) {
	this.price = price;
	}
}

public boolean isDevolution() {
	return devolution;
}

public void setDevolution(boolean devolution) {
	this.devolution = devolution;
}

public VinylRecord getVinyl() {
	return vinyl;
}

public void setVinyl(VinylRecord vinyl) {
	this.vinyl = vinyl;
}

public Books getBook() {
	return book;
}

public void setBook(Books book) {
	this.book = book;
}

public Calendar getRentDate() {
	return rentDate;
}

public void setRentDate(Calendar rentDate) {
	this.rentDate = rentDate;
}

public Calendar getDevolutionDate() {
	return devolutionDate;
}

public void setDevolutionDate(Calendar devolutionDate) {
	this.devolutionDate = devolutionDate;
}

public Products getProduct() {
	return product;
}

public void setProduct(Products product) {
	this.product = product;
}




}
