package com.br.api.Controller;

import com.br.api.Views.Main;
import com.br.model.Services.ProductsBO;
import com.br.model.entity.VinylRecord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadVinylController {
	@FXML private TextField title;
	@FXML private TextField bandsName;
	@FXML private TextField musicalStyle;
	@FXML private TextField copiesAmount;
	@FXML private TextField rentPrice;
	@FXML private Label msgCadastroIncompleto;
	@FXML private Label msgCadastroCompleto;
	
	ProductsBO<VinylRecord> VinylRecordBO = new ProductsBO<VinylRecord>();
	
	public void cadastrar(ActionEvent event) throws Exception{
		if(title.getText().isEmpty() || bandsName.getText().isEmpty() || musicalStyle.getText().isEmpty() || copiesAmount.getText().isEmpty() || rentPrice.getText().isEmpty()) {
			msgCadastroIncompleto.setVisible(true);
		}
		else {
			VinylRecord vinylRecord = new VinylRecord();
			vinylRecord.setTitle(title.getText());
			vinylRecord.setBandsName(bandsName.getText());
			vinylRecord.setMusicalStyle(musicalStyle.getText());
			int copies = Integer.parseInt(copiesAmount.getText());
			vinylRecord.setCopiesAmount(copies);
			double price = Double.parseDouble(rentPrice.getText());
			vinylRecord.setRentPrice(price);
			
			VinylRecordBO.add(vinylRecord);
			msgCadastroCompleto.setVisible(true);
		}
	}
	
	public void close(ActionEvent event) throws Exception{
		Main.telaControleDiscos();
	}

}
