package com.br.api.Controler;

import java.net.URL;
import java.util.ResourceBundle;

import com.br.api.Views.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonLogin"
    private Button buttonLogin; // Value injected by FXMLLoader

    @FXML // fx:id="buttonout"
    private Button buttonout; // Value injected by FXMLLoader

    @FXML // fx:id="gotocadastro"
    private Button gotocadastro; // Value injected by FXMLLoader

    @FXML // fx:id="passwdlogin"
    private PasswordField passwdlogin; // Value injected by FXMLLoader

    @FXML // fx:id="user"
    private TextField user; // Value injected by FXMLLoader

    @FXML
    void closeview(ActionEvent event) {
    	Main.getStage().close();
    }

    @FXML
    void gotocadastro(ActionEvent event) {
    	Main.telacadastroadmin();
    }

    @FXML
    void login(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'login.fxml'.";
        assert buttonout != null : "fx:id=\"buttonout\" was not injected: check your FXML file 'login.fxml'.";
        assert gotocadastro != null : "fx:id=\"gotocadastro\" was not injected: check your FXML file 'login.fxml'.";
        assert passwdlogin != null : "fx:id=\"passwdlogin\" was not injected: check your FXML file 'login.fxml'.";
        assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'login.fxml'.";

    }

}
