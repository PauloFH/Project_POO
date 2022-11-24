package com.br.api.Controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.br.api.DTO.BookDTO;
import com.br.api.Views.Main;
import com.br.model.Services.BooksBO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class EditBooksController implements Initializable{
	
	    @FXML // fx:id="author"
	    private TextField author; // Value injected by FXMLLoader

	    @FXML // fx:id="copiesAmount"
	    private TextField copiesAmount; // Value injected by FXMLLoader

	    @FXML // fx:id="gender"
	    private TextField gender; // Value injected by FXMLLoader


	    @FXML // fx:id="pagesAmount"
	    private TextField pagesAmount; // Value injected by FXMLLoader

	    @FXML // fx:id="releaseDate"
	    private TextField releaseDate; // Value injected by FXMLLoader

	    @FXML // fx:id="rentPrice"
	    private TextField rentPrice; // Value injected by FXMLLoader

	    @FXML // fx:id="title"
	    private TextField title; // Value injected by FXMLLoader
	    
	    BooksBO livroBO = new BooksBO();
		
		public void editar() {
			BookDTO book = new BookDTO();
			book.setAuthor(author.getText());
			book.setCopiesAmount(Integer.parseInt(copiesAmount.getText()));
			book.setGender(gender.getText());
			book.setId(LivrosController.livrosEdit.getId());
			book.setTitle(LivrosController.livrosEdit.getTitle());
			book.setPagesAmount(Integer.parseInt(pagesAmount.getText()));
			book.setRentPrice(Double.parseDouble(rentPrice.getText()));
			book.setReleaseDate(releaseDate.getText());
			
			if (livroBO.editBooks(book)) {
				JOptionPane.showMessageDialog(null, "Livro Editado.");
				Main.telaControleLivro();
			}
		}
	    
	    public void close() {
	    	Main.telaControleLivro();
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
}
