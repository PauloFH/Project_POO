package com.br.controllers;

import com.br.model.Services.ClientsBO;
import com.br.model.entity.Clients;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadClienteController {
	@FXML private TextField name;
	@FXML private TextField CPF;
	@FXML private TextField address;
	@FXML private Label msgCadastroIncompleto;
	
	ClientsBO ClientsBO = new ClientsBO();
	
	public void cadastrar(ActionEvent event) throws Exception{
		if(name.getText().isEmpty() || CPF.getText().isEmpty() || address.getText().isEmpty()) {
			msgCadastroIncompleto.setVisible(true);
		}
		else {
			ClientsDTO client = new ClientsDTO();
			client.setName(name.getText());
			client.setCpf(CPF.getText());
			client.setAddress(address.getText());
			
			ClientsBO.registerClients(client);
		}
	}
}
