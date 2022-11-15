package com.br.api.DTO;

public abstract class ProductsDTO {
	protected String title;
	private double rentPrice;
	private int copiesAmount;
	
	public String getTitle() {
	       return title;
	   }

	   public void setTitle(String title) {
	           if(!title.isEmpty()) this.title = title;
	           else throw new IllegalArgumentException("Title cannot be empty");
	   }

	   public int getCopiesAmount(){
	    	
	       return copiesAmount;
	   }

	   public void setCopiesAmount(int copiesAmount) {
	           if(copiesAmount > 0) this.copiesAmount = copiesAmount;
	           else throw new IllegalArgumentException("Total records must be greater than 0");
	   }

	   public double getRentPrice() {
	       return rentPrice;
	    }
	   public void setRentPrice(double rentPrice) {
	           if(rentPrice > 0) this.rentPrice = rentPrice;
	           else throw new IllegalArgumentException("rent price must be greater than 0");
	   }
}
