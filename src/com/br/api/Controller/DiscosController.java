package com.br.api.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.VinylRecordDTO;
import com.br.api.Views.Main;
import com.br.model.Services.VinylRecordBO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class DiscosController implements Initializable {
	@FXML
	private TableView<VinylRecordDTO> tabelaDiscos;
//	@FXML
//	private TableColumn<VinylRecordDTO, Void> columnSelecione;
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
	private TableColumn<VinylRecordDTO, Integer> columnId;
//	@FXML
//	private TableColumn<VinylRecordDTO, Void> columnBotao;
	
	@FXML private TableColumn<VinylRecordDTO,Void> edit = new TableColumn<VinylRecordDTO, Void>("editar");
	@FXML private TableColumn<VinylRecordDTO,Void> del = new TableColumn<VinylRecordDTO, Void>("deletar");
	
	private VinylRecordBO bo = new VinylRecordBO();
	
	private ObservableList<VinylRecordDTO> listaDeDiscos;
	
	protected static VinylRecordDTO discosEdit;
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listadeDiscos();
	} 
	
	private ObservableList<VinylRecordDTO> listadeDiscos() {
		
		List<VinylRecordDTO> discos = bo.listAll();
		listaDeDiscos = FXCollections.observableArrayList(discos);
//		columnSelecione.setCellValueFactory(new PropertyValueFactory<>("select"));
		columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("bandsName"));
		columnEstilo.setCellValueFactory(new PropertyValueFactory<>("musicalStyle"));
		columnQtd.setCellValueFactory(new PropertyValueFactory<>("copiesAmount"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
//		columnBotao.setCellValueFactory(new PropertyValueFactory<>("button"));
		tabelaDiscos.setItems(listaDeDiscos);
		columnId.setVisible(false);
		addButtonEdit();
		addButtonDel();
	}
	
	public void addButtonEdit() {
		Callback<TableColumn<VinylRecordDTO, Void>, TableCell<VinylRecordDTO, Void>> cellFactory = new Callback<TableColumn<VinylRecordDTO, Void>, TableCell<VinylRecordDTO, Void>>(){

			@Override
			public TableCell<VinylRecordDTO, Void> call(TableColumn<VinylRecordDTO, Void> arg0) {
				
				final TableCell<VinylRecordDTO,Void> cell = new TableCell<VinylRecordDTO,Void>(){
					
					private final Button btn = new Button("editar");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							discosEdit = getTableView().getItems().get(getIndex());
							Main.telaEditarDisco();
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
		tabelaDiscos.getColumns().add(edit);
	}
	
	public void addButtonDel() {
		Callback<TableColumn<VinylRecordDTO, Void>, TableCell<VinylRecordDTO, Void>> cellFactory = new Callback<TableColumn<VinylRecordDTO, Void>, TableCell<VinylRecordDTO, Void>>(){

			@Override
			public TableCell<VinylRecordDTO, Void> call(TableColumn<VinylRecordDTO, Void> arg0) {
				
				final TableCell<VinylRecordDTO,Void> cell = new TableCell<VinylRecordDTO,Void>(){
					
					private final Button btn = new Button("apagar");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							discosEdit = getTableView().getItems().get(getIndex());
							
							VinylRecordDTO disco = new VinylRecordDTO();
							disco.setBandsName(discosEdit.getBandsName());
							disco.setCopiesAmount(discosEdit.getCopiesAmount());
							disco.setMusicalStyle(discosEdit.getMusicalStyle());
							disco.setRentPrice(discosEdit.getRentPrice());
							disco.setId(discosEdit.getId());
							disco.setTitle(discosEdit.getTitle());
							if (bo.del(disco)) {
								JOptionPane.showMessageDialog(null, "Disco deletado.");
							}
							
							Main.telaControleDiscos();
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
		tabelaDiscos.getColumns().add(del);
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
	
//	public void deleteDiscos() {
//		JOptionPane.showMessageDialog(null, "deletado com sucesso!");
//	}
}
