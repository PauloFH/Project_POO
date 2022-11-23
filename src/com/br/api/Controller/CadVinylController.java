
package com.br.api.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.Views.Main;
import com.br.model.Services.VinylRecordBO;
import com.br.model.entity.VinylRecord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadVinylController {
	VinylRecordBO bo = new VinylRecordBO();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="bandsName"
    private TextField bandsName; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddLivro"
    private Button buttonAddLivro; // Value injected by FXMLLoader

    @FXML // fx:id="closeButton"
    private Button closeButton; // Value injected by FXMLLoader

    @FXML // fx:id="copiesAmount"
    private TextField copiesAmount; // Value injected by FXMLLoader

    @FXML // fx:id="msgCadastroIncompleto"
    private Label msgCadastroIncompleto; // Value injected by FXMLLoader

    @FXML // fx:id="musicalStyle"
    private TextField musicalStyle; // Value injected by FXMLLoader

    @FXML // fx:id="rentPrice"
    private TextField rentPrice; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private TextField title; // Value injected by FXMLLoader

    @FXML
    void cadastrar(ActionEvent event) {
    	if(title.getText().isEmpty() || bandsName.getText().isEmpty() || musicalStyle.getText().isEmpty() || copiesAmount.getText().isEmpty() || rentPrice.getText().isEmpty()) {
			msgCadastroIncompleto.setVisible(true);
		}
		else {
			try {
			VinylRecord vinylRecord = new VinylRecord();
			vinylRecord.setTitle(title.getText());
			vinylRecord.setBandsName(bandsName.getText());
			vinylRecord.setMusicalStyle(musicalStyle.getText());
			int copies = Integer.parseInt(copiesAmount.getText());
			vinylRecord.setCopiesAmount(copies);
			double price = Double.parseDouble(rentPrice.getText());
			vinylRecord.setRentPrice(price);
			
			bo.add(vinylRecord);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erro: " + e);
			}
		}
    }

    @FXML
    void close(ActionEvent event) {
    	Main.telaControleDiscos();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert bandsName != null : "fx:id=\"bandsName\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";
        assert buttonAddLivro != null : "fx:id=\"buttonAddLivro\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";
        assert copiesAmount != null : "fx:id=\"copiesAmount\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";
        assert msgCadastroIncompleto != null : "fx:id=\"msgCadastroIncompleto\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";
        assert musicalStyle != null : "fx:id=\"musicalStyle\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";
        assert rentPrice != null : "fx:id=\"rentPrice\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'cadastrarVinylTela.fxml'.";

    }

}
