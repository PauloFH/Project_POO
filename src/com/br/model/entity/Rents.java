package com.br.model.entity;

import java.sql.Date;

public class Rents {
  private int id;
  private String name;
  private String name_2;
  private Clients client;
  private Books book;
  private VinylRecord vinyl;
  private Date rentDate;
  private Date devolutionDate;
  private Double price;
  private int qtE;
  private int qtA;
  private boolean devolution;
  
  public int getQtA() {
	return qtA;
}

public void setQtA(int qtA) {
	this.qtA = qtA;
}

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


  public Date getDate() {
	return rentDate;
  }

  public void setDate( Date rentDate) {
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

public Date getRentDate() {
	return rentDate;
}

public void setRentDate(Date rentDate) {
	this.rentDate = rentDate;
}

public Date getDevolutionDate() {
	return devolutionDate;
}

public void setDevolutionDate(Date devolutionDate) {
	this.devolutionDate = devolutionDate;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getQtE() {
	return qtE;
}

public void setQtE(int qtE) {
	this.qtE = qtE;
}

public String getName_2() {
	return name_2;
}

public void setName_2(String name_2) {
	this.name_2 = name_2;
}




}
