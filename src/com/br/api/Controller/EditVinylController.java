package com.br.api.Controller;

import javax.swing.JOptionPane;

import com.br.api.DTO.VinylRecordDTO;
import com.br.api.Views.Main;
import com.br.model.Services.VinylRecordBO;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditVinylController {


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
			Main.telaControleClientes();
		}
	}
	
	public void close() {
		Main.telaControleClientes();
	}
}
