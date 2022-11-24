/**
 * Sample Skeleton for 'alugar.fxml' Controller Class
 */

package com.br.api.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.BookDTO;
import com.br.api.DTO.VinylRecordDTO;
import com.br.api.Views.Main;
import com.br.model.DAO.VinylRecordDAO;
import com.br.model.Services.BooksBO;
import com.br.model.Services.ClientsBO;
import com.br.model.entity.Books;
import com.br.model.entity.Clients;
import com.br.model.entity.Rents;
import com.br.model.entity.VinylRecord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class aluguelController implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="add"
    private Button add; // Value injected by FXMLLoader

    @FXML // fx:id="buscardisco"
    private Button buscardisco; // Value injected by FXMLLoader

    @FXML // fx:id="buscarlivro"
    private Button buscarlivro; // Value injected by FXMLLoader

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

    @FXML // fx:id="createRent"
    private Button createRent; // Value injected by FXMLLoader

    @FXML // fx:id="generateReport"
    private Button generateReport; // Value injected by FXMLLoader

    @FXML // fx:id="returnDate"
    private DatePicker returnDate; // Value injected by FXMLLoader

    @FXML // fx:id="search"
    private TextField search; // Value injected by FXMLLoader

    @FXML // fx:id="searchClient"
    private TextField searchClient; // Value injected by FXMLLoader

    @FXML // fx:id="searchbook"
    private TextField searchbook; // Value injected by FXMLLoader

    @FXML // fx:id="searchdisco"
    private TextField searchdisco; // Value injected by FXMLLoader
    	VinylRecordDAO vdao = new VinylRecordDAO();
    	BooksBO bbo = new BooksBO();
    	
    @FXML
    void addproduct(ActionEvent event) {
    	if(searchdisco.getText() != null) {
        	VinylRecordDTO temp = new VinylRecordDTO();
        	temp.setTitle(searchdisco.getText());
        	List<VinylRecord> a = vdao.findBySpecifiedField(temp,"title");
        	if(a.get(0) != null) {
        		search.setText(searchdisco.getText());
        		searchdisco.setText(null);
        	}else JOptionPane.showMessageDialog(null, "Nenhum produto para adicionar");
    	}
    	
    else if(searchbook.getText() != null) {
    	Books temp = new Books();
    	temp.setTitle(searchbook.getText());
    	List<Books> a = bbo.getByTitle(temp);
    	if(a.get(0) != null) {
    	search.setText(searchbook.getText());
    	searchbook.setText(null);
    	
    	}else JOptionPane.showMessageDialog(null, "Nenhum produto para adicionar");}
    else {JOptionPane.showMessageDialog(null, "Nenhum produto para adicionar");}
    }
    
    @FXML
    void alugar(ActionEvent event) {
    	ClientsBO bo = new ClientsBO();
    	Rents rent = new Rents();
    	 List<Clients> cl =  bo.searchcpf(searchClient.getText());
    	 rent.setClient(cl.get(0));
    	 
    	 
    }
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

    @FXML
    void telarelatorio(ActionEvent event) {
    	Main.telarelatorio();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'alugar.fxml'.";
        
        assert buttonbooks != null : "fx:id=\"buttonbooks\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonclients != null : "fx:id=\"buttonclients\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonlogout != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonrecords != null : "fx:id=\"buttonrecords\" was not injected: check your FXML file 'alugar.fxml'.";
        assert buttonrents != null : "fx:id=\"buttonrents\" was not injected: check your FXML file 'alugar.fxml'.";
        assert createRent != null : "fx:id=\"createRent\" was not injected: check your FXML file 'alugar.fxml'.";
        assert generateReport != null : "fx:id=\"generateReport\" was not injected: check your FXML file 'alugar.fxml'.";
        assert returnDate != null : "fx:id=\"returnDate\" was not injected: check your FXML file 'alugar.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'alugar.fxml'.";
        assert searchClient != null : "fx:id=\"searchClient\" was not injected: check your FXML file 'alugar.fxml'.";
        assert searchbook != null : "fx:id=\"searchbook\" was not injected: check your FXML file 'alugar.fxml'.";
        assert searchdisco != null : "fx:id=\"searchdisco\" was not injected: check your FXML file 'alugar.fxml'.";

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		search.setEditable(false);
		// TODO Auto-generated method stub
		
	}

}
