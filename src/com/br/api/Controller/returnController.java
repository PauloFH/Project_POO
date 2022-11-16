/**
 * Sample Skeleton for 'alugar.fxml' Controller Class
 */

package com.br.api.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.br.api.Views.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class returnController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="backButton"
    private ImageView backButton; // Value injected by FXMLLoader

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

    @FXML // fx:id="getDate"
    private DatePicker getDate; // Value injected by FXMLLoader

    @FXML // fx:id="returnTitle"
    private Button returnTitle; // Value injected by FXMLLoader

    @FXML // fx:id="searchTitle"
    private TextField searchTitle; // Value injected by FXMLLoader

    @FXML
    void logout(MouseEvent event) {
        Main.telalogin();
    }

    @FXML
    void onGoBack(MouseEvent event) {

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
        Main.telaControleDevolucao();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonbooks != null : "fx:id=\"buttonbooks\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonclients != null : "fx:id=\"buttonclients\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonlogout != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonrecords != null : "fx:id=\"buttonrecords\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonrents != null : "fx:id=\"buttonrents\" was not injected: check your FXML file 'alugar.fxml'.";
        assert getDate != null : "fx:id=\"getDate\" was not injected: check your FXML file 'alugar.fxml'.";
        assert returnTitle != null : "fx:id=\"returnTitle\" was not injected: check your FXML file 'alugar.fxml'.";
        assert searchTitle != null : "fx:id=\"searchTitle\" was not injected: check your FXML file 'alugar.fxml'.";

    }

}
