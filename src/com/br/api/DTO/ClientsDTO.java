package com.br.api.DTO;


import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ClientsDTO {
	private String name;
    private String address;
    private String cpf;
    private CheckBox select;
    private Button button;


    /*Métodos Set  e Get */
	public void setAddress(String address) {
	    if(address != null&& !address.isEmpty()){
	    this.address = address;
	    }
	}
	
	
	public void setCpf(String cpf) {
	    if(cpf != null && !cpf.isEmpty()){
	    this.cpf = cpf;
	    }
	}
	public void setName(String name) {
	    if(name != null && !name.isEmpty()){
	    this.name = name;
	    }
	}
	public String getAddress() {
        	return address;
    }
    public String getCpf() {
    	return cpf;
    }	
    public String getName() {
        return name;
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
