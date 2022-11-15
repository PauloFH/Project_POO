/**
 * Sample Skeleton for 'telabase.fxml' Controller Class
 */

package com.br.api.Controller;

import java.net.URL;
import java.util.ResourceBundle;
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
    void closeflag1(MouseEvent event) {

    }

    @FXML
    void closeflag2(MouseEvent event) {

    }

    @FXML
    void closeflag3(MouseEvent event) {

    }

    @FXML
    void closeflag4(MouseEvent event) {

    }

    @FXML
    void closeflag5(MouseEvent event) {

    }

    @FXML
    void logout(MouseEvent event) {

    }

    @FXML
    void openbooksview(MouseEvent event) {

    }

    @FXML
    void openclientsview(MouseEvent event) {

    }

    @FXML
    void openrecordsview(MouseEvent event) {

    }

    @FXML
    void openrentsview(MouseEvent event) {

    }

    @FXML
    void showflag1(MouseEvent event) {

    }

    @FXML
    void showflag2(MouseEvent event) {

    }

    @FXML
    void showflag3(MouseEvent event) {

    }

    @FXML
    void showflag4(MouseEvent event) {

    }

    @FXML
    void showflag5(MouseEvent event) {

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
