package com.br.model.entity;


public class RentsProducts {
	private int id;
	private Rents rent;
	private Products product;
	private int qt;
	private double rent_Price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Rents getRent() {
		return rent;
	}
	public void setRent(Rents rent) {
		if(rent != null)
		this.rent = rent;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	
	public double getRent_Price() {
		return rent_Price;
	}
	
	public void setRent_Price(double rent_Price) {
		if(rent_Price > 0)
		this.rent_Price = rent_Price;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	

	
}
