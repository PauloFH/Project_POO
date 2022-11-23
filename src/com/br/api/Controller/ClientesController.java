package com.br.api.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.ClienteDTO;
import com.br.api.DTO.ClientsDTO;
import com.br.api.Views.Main;
import com.br.model.Services.ClientsBO;

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

public class ClientesController implements Initializable {
	@FXML
	private TableView<ClientsDTO> tabelaClientes;
//	@FXML
//	private TableColumn<ClientsDTO, CheckBox> columnSelecione;
	@FXML
	private TableColumn<ClientsDTO, String> columnNome;
	@FXML 
	private TableColumn<ClientsDTO, String> columnEndereco;
	@FXML
	private TableColumn<ClientsDTO, String> columnCpf;
//	@FXML
//	private TableColumn<ClientsDTO, Button> columnBotao;
	@FXML private TableColumn<ClientsDTO,Void> edit = new TableColumn<ClientsDTO, Void>("açoes");
	
	 		private ClientsBO bo = new ClientsBO();
	private ObservableList<ClientsDTO> listaDeClientes;
	 
	protected static ClientsDTO clientesEdit;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarClientes();
	} 
	
	public void listarClientes() {
		List<ClientsDTO> clientes = bo.listAll();
		listaDeClientes = FXCollections.observableArrayList(clientes);
//		columnSelecione.setCellValueFactory(new PropertyValueFactory<>("select"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("address"));
		columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
//		columnBotao.setCellValueFactory(new PropertyValueFactory<>("button"));
		tabelaClientes.setItems(listaDeClientes);
		addButtonEdit();
	}
	
	public void addButtonEdit() {
		Callback<TableColumn<ClientsDTO, Void>, TableCell<ClientsDTO, Void>> cellFactory = new Callback<TableColumn<ClientsDTO, Void>, TableCell<ClientsDTO, Void>>(){

			@Override
			public TableCell<ClientsDTO, Void> call(TableColumn<ClientsDTO, Void> arg0) {
				
				final TableCell<ClientsDTO,Void> cell = new TableCell<ClientsDTO,Void>(){
					
					private final Button btn = new Button("editar");
					
					{
						btn.setOnAction((ActionEvent event) -> {
							clientesEdit = getTableView().getItems().get(getIndex());
							Main.telaEditarCliente();
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
		tabelaClientes.getColumns().add(edit);
	}
	
	public void irParaControleLivros() {
		Main.telaControleLivro();
	}
	
	public void irParaControleDiscos() {
		Main.telaControleDiscos();
	}
	
	public void irParaHome() {
		Main.telamenu();
	}
	
	public void irParaAluguel() {
		
	}
	
	public void logout() {
		Main.telalogin();
	}
	
	public void irParaCadastroClientes( ) {
		
	}
	
	public void deleteClientes() {
		JOptionPane.showMessageDialog(null, "deletado com sucesso");
	}
	
    @FXML
    void telamenu(ActionEvent event) {
    	Main.telamenu();
    	
    }
}
