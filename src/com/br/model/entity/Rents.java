package com.br.model.entity;

import java.util.List;

public class Rents extends Products {
  private Long id;
  private Clients client;
  private List<Products> products;
  private String date;

  public Long getId() {
    return this.id;
  }
 
  public void setId(Long id) {
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

  public List<Products> getProducts() {
    return this.products;
  }

  public void setProducts(Products product) {
    if (product == null) {
      System.out.println("Por favor, coloque um produto");
    } else {
      this.products.add(product);
    }
  }

  public String getDate() {
	return date;
  }

  public void setDate(String date) {
	this.date = date;
  }
}
