package com.br.api.Controller;

import com.br.api.DTO.ProductsDTO;

import com.br.api.Views.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ImageView;
import javafx.scene.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
    void openrentsview(MoueEvent event) {
        Main.telaControleDevolucao();
    }

    public void initialize() {
        listEntries();
    }

    public void listEntries() {
        addDeleteButton();
    }

    public addDeleteButton() {
        TableColumn<ProductsDTO, Void> colBtn = new TableColumn("Deletar");
        Callback<TableColumn<ProductsDTO, Void>, TableCell<ProductsDTO, Void>> cellFactory = new Callback<TableColumn<ProductsDTO, Void>, TableCell<ProductsDTO, Void>>() {
            @Override
            public TableCell<ProductsDTO, Void> call(final TableColumn<ProductsDTO, Void> param) {
                final TableCell<ProductsDTO, Void> cell = new TableCell<ProductsDTO, Void>() {
                    private final Button btn = new Button("Deletar");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            ProductsDTO data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
    }
}
