package com.br.model.entity;

import java.sql.Date;

public class VinylRecord extends Products {
    private String bandsName;
    private String musicalStyle;

   

    public String getBandsName() {
        return bandsName;
    }

    public void setBandsName(String bandsName) {
            if(!bandsName.isEmpty()) this.bandsName = bandsName;
            else throw new IllegalArgumentException("Band's name must not be empty");
    }

    public String getMusicalStyle() {
        return musicalStyle;
    }

    public void setMusicalStyle(String musicalStyle) {
            if(!musicalStyle.isEmpty()) this.musicalStyle = musicalStyle;
            else throw new IllegalArgumentException(" Musical style must not be empty");
    }

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGender(String gender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getReleaseDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReleaseDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAuthor(String author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPagesAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPagesAmount(int pagesAmount) {
		// TODO Auto-generated method stub
		
	}


   

}