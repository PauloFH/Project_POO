package com.br.api.Controler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.br.api.DTO.ClienteDTO;
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
	private TableView<ClienteDTO> tabelaClientes;
	@FXML
	private TableColumn<ClienteDTO, CheckBox> columnSelecione;
	@FXML
	private TableColumn<ClienteDTO, String> columnNome;
	@FXML 
	private TableColumn<ClienteDTO, String> columnEndereco;
	@FXML
	private TableColumn<ClienteDTO, String> columnCpf;
	@FXML
	private TableColumn<ClienteDTO, Button> columnBotao;
	
	private ObservableList<ClienteDTO> listaDeClientes;
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarClientes();
	} 
	
	public void listarClientes() {
		ClienteDTO client = new ClienteDTO();
		client.setName("Ramos Carlos");
		client.setAddress("Rua napoleão");
		client.setCpf("454-545-454-14");
		client.setSelect(new CheckBox());
		Button botao = new Button();
		botao.setText("editar");
		client.setButton(botao);
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
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
		
	}
	
	public void irParaAluguel() {
		
	}
	
	public void logout() {
		
	}
	
	public void irParaCadastroClientes( ) {
		
	}
	
	public void deleteClientes() {
		
	}
}
