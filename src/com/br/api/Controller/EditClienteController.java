package com.br.api.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import com.br.api.DTO.ClientsDTO;
import com.br.api.Views.Main;
import com.br.model.Services.ClientsBO;

public class EditClienteController {
	@FXML private TextField name;
	@FXML private TextField CPF;
	@FXML private TextField address;
	
	ClientsBO clientBO = new ClientsBO();
	
	public void editar() {
		ClientsDTO clientDTO = new ClientsDTO();
		clientDTO.setName(name.getText());
		clientDTO.setCpf(ClientesController.clientesEdit.getCpf());
		clientDTO.setAddress(address.getText());
		
		if (clientBO.editClients(clientDTO)) {
			JOptionPane.showMessageDialog(null, "Cliente Editado.");
			Main.telaControleClientes();
		}
	}
	
	public void close() {
		Main.telaControleClientes();
	}
}
