package com.br.model.entity;

import java.util.List;

public class Devolution {
  private int id;
  private Clients client;
  private List<Products> products;
  private String returnDate;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    if (id < 0) {
      System.out.println("Por favor, digite um id válido");
    } else {
      this.id = id;
    }
  }

  public List<Products> getProducts() {
    return this.products;
  }

  public void setProduct(Products product) {
    if (product == null) {
      System.out.println("Por favor, coloque um produto válido");
    } else {
      this.products.add(product);
    }
  }

  public String getReturnDate() {
    return this.returnDate;
  }

  public void setReturnDate(String date) {
    if (date.isEmpty()) {
      System.out.println("Por favor, data de devolução não pode ser vázia");
    } else {
      this.returnDate = date;
    }
  }

}
