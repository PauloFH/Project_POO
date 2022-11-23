package com.br.model.entity;

import java.sql.Date;

public abstract class Products{
	
  protected String title;
  private double rentPrice;
  private int copiesAmount;
  private int id;


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

   public int getId() {
       return id;
   }

   public void setId(int id) {
           if(id >= 0) this.id = id;
           else throw new IllegalArgumentException("Invalid id");
   }
   public abstract String getGender();
   public abstract void setGender(String gender);
   public abstract Date getReleaseDate();
   public abstract void setReleaseDate(Date year);
   public abstract String getAuthor();
   public abstract void setAuthor(String author);
   public abstract int getPagesAmount();
   public abstract void setPagesAmount(int pagesAmount);
   
   public abstract String getBandsName();
   public abstract void setBandsName(String bandsName);
   public abstract String getMusicalStyle();
   public abstract void setMusicalStyle(String musicalStyle);
   
}