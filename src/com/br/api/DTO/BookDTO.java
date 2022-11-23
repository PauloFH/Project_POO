package com.br.api.DTO;



import java.sql.Date;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class BookDTO extends ProductsDTO {
	private String gender;
	private String author;
    private String releaseDate;
    private int pagesAmount;
    private CheckBox select;
    private Button button;
    
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
    
    public String getReleaseDate() {
    	return this.releaseDate;
    }
  
    public void setReleaseDate(String s) {
    	if (s == null) {
    		throw new IllegalArgumentException("releaseDate não pode ser vázia");
    	} else {
    		this.releaseDate = s;
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

	public CheckBox getSelect() {
		return select;
	}

	public void setSelect(CheckBox select) {
		this.select = select;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

}
