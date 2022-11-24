package com.br.api.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.VinylRecordDTO;
import com.br.api.Views.Main;
import com.br.model.Services.VinylRecordBO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class EditVinylController implements Initializable {


    @FXML // fx:id="bandsName"
    private TextField bandsName; // Value injected by FXMLLoader

    @FXML // fx:id="copiesAmount"
    private TextField copiesAmount; // Value injected by FXMLLoader

    @FXML // fx:id="musicalStyle"
    private TextField musicalStyle; // Value injected by FXMLLoader

    @FXML // fx:id="rentPrice"
    private TextField rentPrice; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private TextField title; // Value injected by FXMLLoader

	VinylRecordBO discoBO = new VinylRecordBO();
	
	public void editar() {
		VinylRecordDTO discoDTO = new VinylRecordDTO();
		discoDTO.setId(DiscosController.discosEdit.getId());
		discoDTO.setBandsName(bandsName.getText());
		discoDTO.setCopiesAmount(Integer.parseInt(copiesAmount.getText()));
		discoDTO.setMusicalStyle(musicalStyle.getText());
		discoDTO.setRentPrice(Double.parseDouble(rentPrice.getText()));
		discoDTO.setTitle(title.getText());
		
		if (discoBO.edit(discoDTO)) {
			JOptionPane.showMessageDialog(null, "Disco Editado.");
			ClientesController.clientesEdit = null;
			Main.telaControleClientes();
		}else JOptionPane.showMessageDialog(null, "Disco não editado.");
	}
	
	public void close() {
		Main.telaControleDiscos();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		title.setText(DiscosController.discosEdit.getTitle());
		bandsName.setText(DiscosController.discosEdit.getBandsName());
		copiesAmount.setText(Integer.toString(DiscosController.discosEdit.getCopiesAmount()));
		musicalStyle.setText(DiscosController.discosEdit.getMusicalStyle());
		rentPrice.setText(Double.toString(DiscosController.discosEdit.getRentPrice()));
		
	}
}
