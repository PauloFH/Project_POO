package com.br.api.DTO;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class VinylRecordDTO extends ProductsDTO {
    private String bandsName;
    private String musicalStyle;
    private CheckBox select;
    private Button button;
    

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
