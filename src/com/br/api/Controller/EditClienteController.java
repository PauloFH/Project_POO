package com.br.api.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.ClientsDTO;
import com.br.api.Views.Main;
import com.br.model.Services.ClientsBO;

public class EditClienteController implements Initializable{
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
			ClientesController.clientesEdit = null;			
			Main.telaControleClientes();
		}
	}
	
	public void close() {
		Main.telaControleClientes();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(ClientesController.clientesEdit !=null ) {
			
			name.setText(ClientesController.clientesEdit.getName());
			CPF.setText(ClientesController.clientesEdit.getCpf());
			address.setText(ClientesController.clientesEdit.getAddress());
			CPF.setEditable(false);
		}
		
	}
}
