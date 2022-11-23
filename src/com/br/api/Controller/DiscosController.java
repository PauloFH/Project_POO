package com.br.api.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.VinylRecordDTO;
import com.br.api.Views.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DiscosController implements Initializable {
	@FXML
	private TableView<VinylRecordDTO> tabelaDiscos;
	@FXML
	private TableColumn<VinylRecordDTO, Void> columnSelecione;
	@FXML
	private TableColumn<VinylRecordDTO, String> columnTitulo;
	@FXML 
	private TableColumn<VinylRecordDTO, String> columnNome;
	@FXML
	private TableColumn<VinylRecordDTO, String> columnEstilo;
	@FXML
	private TableColumn<VinylRecordDTO, Integer> columnQtd;
	@FXML
	private TableColumn<VinylRecordDTO, Double> columnPreco;
	@FXML
	private TableColumn<VinylRecordDTO, Void> columnBotao;
	
	//private ObservableList<VinylRecordDTO> listaDeDiscos;
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		columnSelecione.setCellValueFactory(
                new PropertyValueFactory<>("select"));
		columnTitulo.setCellValueFactory(
                new PropertyValueFactory<>("title"));
		columnNome.setCellValueFactory(
                new PropertyValueFactory<>("bandsName"));
		columnEstilo.setCellValueFactory(
                new PropertyValueFactory<>("musicalStyle"));
		columnQtd.setCellValueFactory(
                new PropertyValueFactory<>("copiesAmount"));
		columnPreco.setCellValueFactory(
                new PropertyValueFactory<>("rentPrice"));
		columnBotao.setCellValueFactory(
                new PropertyValueFactory<>("button"));

		tabelaDiscos.setItems(listadeDiscos());
	} 
	
	private ObservableList<VinylRecordDTO> listadeDiscos() {
		
		Button button = new Button();
		button.setText("editar");
		 return FXCollections.observableArrayList(
				 new VinylRecordDTO("Seu ex é feio","Tony Canabrava","CarnavalTibau2019", 13.13, 22, new CheckBox(), button));
	}
	
	
	public void irParaControleLivros() {
		Main.telaControleLivro();
	}
	
	public void irParaControleClientes() {
		Main.telaControleClientes();
	}
	
	public void irParaHome() {
		Main.telamenu();
	}
	
	public void irParaAluguel() {
		
	}
	
	public void logout() {
		Main.telalogin();
	}
	
	public void irParaCadastroDiscos( ) {
		Main.telaCadastroVinyl();
	}
	
	public void deleteDiscos() {
		JOptionPane.showMessageDialog(null, "deletado com sucesso!");
	}
}
