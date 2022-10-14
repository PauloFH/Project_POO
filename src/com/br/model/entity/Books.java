package com.br.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Books extends Products{
    // implements Book
	private int id;
    private String gender;
    private String author;
    private Date releaseDate;
    private int pagesAmount;

    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	if (id < 0) {
    		throw new IllegalArgumentException("Id tem que ser positivo");
    	} else {
    		this.id = id;
    	}
    }
    
    public String getGender() {
    	return this.gender;
    }
    
    public void setGender(String gender) {
    	if (gender.isEmpty()) {
    		throw new IllegalArgumentException("Gender não pode ser vázio");
    	} else {
    		this.gender = gender;
    	}
    }
    
    public String getAuthor() {
    	return this.author;
    }
    
    public void setAuthor(String author) {
    	if (author.isEmpty()) {
    		throw new IllegalArgumentException("Author não ser vázio");
    	} else {
    		this.author = author;
    	}
    }
    
    public Date getReleaseDate() {
    	return this.releaseDate;
    }
  
    public void setReleaseDate(Date releaseDate) {
    	if (releaseDate == null) {
    		throw new IllegalArgumentException("releaseDate não pode ser vázia");
    	} else {
    		this.releaseDate = releaseDate;
    	}
    }
    
    public int getPagesAmount() {
    	return this.pagesAmount;
    }
    
    public void setPagesAmount(int pagesAmount) {
    	if (pagesAmount <= 0) {
    		throw new IllegalArgumentException("PagesAmount não pode ser 0 ou inferior");
    	} else {
    		this.pagesAmount = pagesAmount;
    	}
    }
}
