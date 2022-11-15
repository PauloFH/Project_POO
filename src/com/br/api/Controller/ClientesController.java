package com.br.api.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.br.api.DTO.ClientsDTO;
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

public class ClientesController implements Initializable {
	@FXML
	private TableView<ClientsDTO> tabelaClientes;
	@FXML
	private TableColumn<ClientsDTO, CheckBox> columnSelecione;
	@FXML
	private TableColumn<ClientsDTO, String> columnNome;
	@FXML 
	private TableColumn<ClientsDTO, String> columnEndereco;
	@FXML
	private TableColumn<ClientsDTO, String> columnCpf;
	@FXML
	private TableColumn<ClientsDTO, Button> columnBotao;
	
	private ObservableList<ClientsDTO> listaDeClientes;
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarClientes();
	} 
	
	public void listarClientes() {
		ClientsDTO client = new ClientsDTO();
		client.setName("Ramos Carlos");
		client.setAddress("Rua napoleão");
		client.setCpf("454-545-454-14");
		client.setSelect(new CheckBox());
		Button botao = new Button();
		botao.setText("editar");
		client.setButton(botao);
		List<ClientsDTO> clientes = new ArrayList<ClientsDTO>();
		clientes.add(client);
		
		listaDeClientes = FXCollections.observableArrayList(clientes);
		columnSelecione.setCellValueFactory(new PropertyValueFactory<>("select"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("address"));
		columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		columnBotao.setCellValueFactory(new PropertyValueFactory<>("button"));
		tabelaClientes.setItems(listaDeClientes);
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
		
	}
}
