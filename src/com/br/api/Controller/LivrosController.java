package com.br.api.Controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.BookDTO;
import com.br.api.Views.Main;
import com.br.model.Services.BooksBO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class LivrosController implements Initializable {
	@FXML
	private TableView<BookDTO> tabelaLivros;
//	@FXML
//	private TableColumn<BookDTO, CheckBox> columnSelecione;
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
	private TableColumn<BookDTO, Integer> columnId;
//	@FXML
//	private TableColumn<BookDTO, Button> columnBotao;
	@FXML private TableColumn<BookDTO,Void> edit = new TableColumn<BookDTO, Void>("editar");
	@FXML private TableColumn<BookDTO,Void> del = new TableColumn<BookDTO, Void>("deletar");
	
	private ObservableList<BookDTO> listaDeLivros;
	
	protected static BookDTO livrosEdit;
	 
	private BooksBO bo = new BooksBO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarLivros();
	} 
	
	public void listarLivros() {
		List<BookDTO> books = new ArrayList<BookDTO>();
		listaDeLivros = FXCollections.observableArrayList(books);
		columnGenero.setCellValueFactory(new PropertyValueFactory<>("gender"));
		columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
		columnAutor.setCellValueFactory(new PropertyValueFactory<>("author"));
		columnAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnQtdExemplares.setCellValueFactory(new PropertyValueFactory<>("copiesAmount"));
		tabelaLivros.setItems(listaDeLivros);
		columnId.setVisible(false);
		addButtonEdit();
		addButtonDel();
	}
	
	public void addButtonEdit() {
		Callback<TableColumn<BookDTO, Void>, TableCell<BookDTO, Void>> cellFactory = new Callback<TableColumn<BookDTO, Void>, TableCell<BookDTO, Void>>(){

			@Override
			public TableCell<BookDTO, Void> call(TableColumn<BookDTO, Void> arg0) {
				
				final TableCell<BookDTO,Void> cell = new TableCell<BookDTO,Void>(){
					
					private final Button btn = new Button("editar");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							livrosEdit = getTableView().getItems().get(getIndex());
							Main.telaEditarLivro();
						});
					}
					
					@Override
					public void updateItem(Void item, boolean empty) {
						if(empty) {
							setGraphic(null);
						}
						else {
							setGraphic(btn);
						}
					}
				};
				
				return cell;
			}
		};
		
		edit.setCellFactory(cellFactory);
		tabelaLivros.getColumns().add(edit);
	}
	
	public void addButtonDel() {
		Callback<TableColumn<BookDTO, Void>, TableCell<BookDTO, Void>> cellFactory = new Callback<TableColumn<BookDTO, Void>, TableCell<BookDTO, Void>>(){

			@Override
			public TableCell<BookDTO, Void> call(TableColumn<BookDTO, Void> arg0) {
				
				final TableCell<BookDTO,Void> cell = new TableCell<BookDTO,Void>(){
					
					private final Button btn = new Button("apagar");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							livrosEdit = getTableView().getItems().get(getIndex());
							
							BookDTO book = new BookDTO();
							book.setAuthor(livrosEdit.getAuthor());
							book.setCopiesAmount(livrosEdit.getCopiesAmount());
							book.setGender(livrosEdit.getGender());
							book.setId(livrosEdit.getId());
							book.setPagesAmount(livrosEdit.getPagesAmount());
							book.setReleaseDate(livrosEdit.getReleaseDate());
							book.setRentPrice(livrosEdit.getRentPrice());
							book.setTitle(livrosEdit.getTitle());
							
							if (bo.deleteBooks(book)) {
								JOptionPane.showMessageDialog(null, "Livro deletado.");
							}
							
							Main.telaControleClientes();
						});
					}
					
					@Override
					public void updateItem(Void item, boolean empty) {
						if(empty) {
							setGraphic(null);
						}
						else {
							setGraphic(btn);
						}
					}
				};
				
				return cell;
			}
		};
		
		del.setCellFactory(cellFactory);
		tabelaLivros.getColumns().add(del);
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


