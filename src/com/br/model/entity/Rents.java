package com.br.model.entity;


import java.util.Calendar;

public class Rents {
  private int id;
  private String name;
  private String name_2;
  private Clients client;
  private Books book;
  private VinylRecord vinyl;
  private Calendar rentDate;
  private Calendar devolutionDate;
  private Double price;
  private int qtE;
  private int qtA;
  private boolean devolution;
  private int getTotalRents;
  
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

public int getGetTotalRents() {
	return getTotalRents;
}

public void setGetTotalRents(int getTotalRents) {
	if (id < 0) {
	      System.out.println("totalRents tem que ser positivo");
	    } else {
	    	this.getTotalRents = getTotalRents;
	    }
	  }

}
