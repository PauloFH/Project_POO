package com.br.api.DTO;

//import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;

public class VinylRecordDTO extends ProductsDTO {
    private String bandsName;
    private String musicalStyle;
    private int id;
//    private CheckBox select;
//    private Button button;
//    

    public VinylRecordDTO(String title,String bandsName, String musicalStyle,Double rentPrice,int copies) {
		super.title = title;
		super.rentPrice = rentPrice;
		super.copiesAmount = copies;
		this.bandsName = bandsName;
		this.musicalStyle = musicalStyle;
//		this.select = select;
//		this.button = button;
	}

	public VinylRecordDTO() {
		// TODO Auto-generated constructor stub
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
