/**
 * Sample Skeleton for 'cadadmin.fxml' Controller Class
 */

package com.br.api.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.AdministratorsDTO;
import com.br.api.Views.Main;
import com.br.model.Services.AdministratorsBO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class cadadmincontroller {
	AdministratorsBO bo = new AdministratorsBO();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttoncad"
    private Button buttoncad; // Value injected by FXMLLoader

    @FXML // fx:id="codass"
    private TextField codass; // Value injected by FXMLLoader

    @FXML // fx:id="movetologin"
    private Button movetologin; // Value injected by FXMLLoader

    @FXML // fx:id="namecomp"
    private TextField namecomp; // Value injected by FXMLLoader

    @FXML // fx:id="passwd"
    private PasswordField passwd; // Value injected by FXMLLoader

    @FXML // fx:id="user"
    private TextField user; // Value injected by FXMLLoader

    @FXML
    void cadastrar(ActionEvent event) {
		  AdministratorsDTO dto = new AdministratorsDTO();
		  dto.setName(namecomp.getText());
		  dto.setPasswd(passwd.getText());
		  dto.setUser(user.getText());
		  dto.setAcsscode(codass.getText());
		  try {
			  	if(bo.registerAdministrator(dto)) {
			  		JOptionPane.showMessageDialog(null,"cadastrado com sucesso");
			  		Main.telalogin();}
			  	else {
			  		JOptionPane.showMessageDialog(null,"Erro ao se cadastrar, verifique se o código está correto");
			  	}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro no cadastrar Administrators: "+e);
		}
    }

    @FXML
    void viewlogin(ActionEvent event) {
    			Main.telalogin();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttoncad != null : "fx:id=\"buttoncad\" was not injected: check your FXML file 'cadadmin.fxml'.";
        assert codass != null : "fx:id=\"codass\" was not injected: check your FXML file 'cadadmin.fxml'.";
        assert movetologin != null : "fx:id=\"movetologin\" was not injected: check your FXML file 'cadadmin.fxml'.";
        assert namecomp != null : "fx:id=\"namecomp\" was not injected: check your FXML file 'cadadmin.fxml'.";
        assert passwd != null : "fx:id=\"passwd\" was not injected: check your FXML file 'cadadmin.fxml'.";
        assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'cadadmin.fxml'.";

    }

}
