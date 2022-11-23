package com.br.api.Controller;

import javax.swing.JOptionPane;

import com.br.api.DTO.ClientsDTO;
import com.br.api.Views.Main;
import com.br.model.Services.ClientsBO;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadClienteController {
	@FXML private TextField name;
	@FXML private TextField CPF;
	@FXML private TextField address;
	@FXML private Label msgCadastroIncompleto;
	@FXML private Label msgCadastroCompleto;
	
	ClientsBO ClientsBO = new ClientsBO();
	
	public void cadastrar(ActionEvent event) throws Exception{
		if(name.getText().isEmpty() || CPF.getText().isEmpty() || address.getText().isEmpty()) {
			msgCadastroIncompleto.setVisible(true);
		}
		else {	ClientsDTO client = new ClientsDTO();
			try {
				
				client.setName(name.getText());
				client.setCpf(CPF.getText());
				client.setAddress(address.getText());
				
				ClientsBO.registerClients(client);
				JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);			}
			
			ClientsBO.registerClients(client);
			msgCadastroCompleto.setVisible(true);
		}
	}
	
	public void close(ActionEvent event) throws Exception{
		Main.telaControleClientes();
	}

}
