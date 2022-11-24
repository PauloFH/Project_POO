package com.br.api.Controller;

import com.br.api.Views.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class generateReportController {

    @FXML
    private TableColumn<?, ?> ammount;

    @FXML
    private ImageView buttonbooks;

    @FXML
    private ImageView buttonclients;

    @FXML
    private ImageView buttonlogout;

    @FXML
    private ImageView buttonrecords;

    @FXML
    private ImageView buttonrents;

    @FXML
    private TableColumn<?, ?> clientName;

    @FXML
    private TableColumn<?, ?> delete;

    @FXML
    private Button generateReport;

    @FXML
    private DatePicker getDate;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> productName;

    @FXML
    private TableColumn<?, ?> returnment;

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
        Main.telaControleDevolucao();
    }

}
