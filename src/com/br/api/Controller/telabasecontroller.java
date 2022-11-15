/**
 * Sample Skeleton for 'telabase.fxml' Controller Class
 */

package com.br.api.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.br.api.Views.Main;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class telabasecontroller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonbooks"
    private ImageView buttonbooks; // Value injected by FXMLLoader

    @FXML // fx:id="buttonclients"
    private ImageView buttonclients; // Value injected by FXMLLoader

    @FXML // fx:id="buttonlogout"
    private ImageView buttonlogout; // Value injected by FXMLLoader

    @FXML // fx:id="buttonrecords"
    private ImageView buttonrecords; // Value injected by FXMLLoader

    @FXML // fx:id="buttonrents"
    private ImageView buttonrents; // Value injected by FXMLLoader

  
    @FXML
    void logout(MouseEvent event) {
    	Main.telalogin();
    }

    @FXML
    void openbooksview(MouseEvent event) {
    	Main.telaControleLivro();
    }

    @FXML
    void openclientsview(MouseEvent event) {
    	Main.telaControleClientes();
    }

    @FXML
    void openrecordsview(MouseEvent event) {
    	Main.telaControleDiscos();
    }

    @FXML
    void openrentsview(MouseEvent event) {
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttonbooks != null : "fx:id=\"buttonbooks\" was not injected: check your FXML file 'telabase.fxml'.";
        assert buttonclients != null : "fx:id=\"buttonclients\" was not injected: check your FXML file 'telabase.fxml'.";
        assert buttonlogout != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'telabase.fxml'.";
        assert buttonrecords != null : "fx:id=\"buttonrecords\" was not injected: check your FXML file 'telabase.fxml'.";
        assert buttonrents != null : "fx:id=\"buttonrents\" was not injected: check your FXML file 'telabase.fxml'.";

    }

}
