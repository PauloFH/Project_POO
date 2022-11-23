package com.br.api.Controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.BookDTO;
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


public class LivrosController implements Initializable {
	@FXML
	private TableView<BookDTO> tabelaLivros;
	@FXML
	private TableColumn<BookDTO, CheckBox> columnSelecione;
	@FXML
	private TableColumn<BookDTO, String> columnTitulo;
	@FXML 
	private TableColumn<BookDTO, String> columnGenero;
	@FXML
	private TableColumn<BookDTO, String> columnAutor;
	@FXML
	private TableColumn<BookDTO, Integer> columnAnoLancamento;
	@FXML
	private TableColumn<BookDTO, Double> columnQtdExemplares;
	@FXML
	private TableColumn<BookDTO, Double> columnPreco;
	@FXML
	private TableColumn<BookDTO, Button> columnBotao;
	
	private ObservableList<BookDTO> listaDeLivros;
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarLivros();
	} 
	
	public void listarLivros() {
		BookDTO book = new BookDTO();
		book.setAuthor("Neil Gaiman");
		book.setCopiesAmount(20);
		book.setGender("Ficção");
		book.setTitle("Sandman");
		book.setReleaseDate("10/05/1980");
		book.setRentPrice(45.5);
		book.setSelect(new CheckBox());
		Button botao = new Button();
		botao.setText("editar");
		book.setButton(botao);
	
		List<BookDTO> books = new ArrayList<BookDTO>();
		books.add(book);
		
		listaDeLivros = FXCollections.observableArrayList(books);
		columnSelecione.setCellValueFactory(new PropertyValueFactory<>("select"));
		columnGenero.setCellValueFactory(new PropertyValueFactory<>("gender"));
		columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
		columnAutor.setCellValueFactory(new PropertyValueFactory<>("author"));
		columnAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
		columnBotao.setCellValueFactory(new PropertyValueFactory<>("button"));
		columnQtdExemplares.setCellValueFactory(new PropertyValueFactory<>("copiesAmount"));
		tabelaLivros.setItems(listaDeLivros);
	}
	
	
	public void irParaTelaControleDiscos() {
		Main.telaControleDiscos();
	}
	
	public void irParaTelaControleClientes() {
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
	
	public void irTelaCadastroLivros( ) {
		Main.telaCadastroBooks();
	}
	
	public void deleteLivros() {
		JOptionPane.showMessageDialog(null, "deletado com sucesso");
	}
}


