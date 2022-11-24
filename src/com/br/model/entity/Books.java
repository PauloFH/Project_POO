package com.br.model.entity;



import java.sql.Date;

import com.br.api.DTO.BookDTO;

public class Books extends Products{
    // implements Book
    private String gender;
    private String author;
    private String releaseDate;
    private int pagesAmount;
    
    public String getGender() {
    	return this.gender;
    }
    
    public void setGender(String gender) {
    	if (gender.isEmpty()) {
    		throw new IllegalArgumentException("Gender não pode ser vazio");
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
    
    public String getReleaseDate() {
    	return this.releaseDate;
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
    public static Books converter(BookDTO dto) {
    	Books book =  new Books();
    	book.setTitle(dto.getTitle());
    	book.setAuthor(dto.getAuthor());
    	book.setCopiesAmount(dto.getCopiesAmount());
    	book.setPagesAmount(dto.getPagesAmount());
    	book.setGender(dto.getGender());
    	book.setReleaseDate(dto.getReleaseDate());
    	return book;
    }

    
    //Ignorar metodos de discos
	@Override
	public String getBandsName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBandsName(String bandsName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMusicalStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMusicalStyle(String musicalStyle) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setReleaseDate(String date) {
    	if (date == null) {
    		throw new IllegalArgumentException("releaseString não pode ser vázia");
    	} else {
    		this.releaseDate = date;
		
	}

	}

  
}
