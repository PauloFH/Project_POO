package com.br.controllers;

import com.br.model.Services.ProductsBO;
import com.br.model.entity.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadBooksController {
	@FXML private TextField title;
	@FXML private TextField gender;
	@FXML private TextField releaseDate;
	@FXML private TextField author;
	@FXML private TextField pagesAmount;
	@FXML private TextField copiesAmount;
	@FXML private TextField rentPrice;
	@FXML private Label msgCadastroIncompleto; 
	
	ProductsBO<Books> BooksBO = new ProductsBO<Books>();
	
	public void cadastrar(ActionEvent event) throws Exception{
		if(title.getText().isEmpty() || gender.getText().isEmpty() || releaseDate.getText().isEmpty() || author.getText().isEmpty() || pagesAmount.getText().isEmpty() || copiesAmount.getText().isEmpty() || rentPrice.getText().isEmpty()) {
			msgCadastroIncompleto.setVisible(true);
		}
		else {
			Books book = new Books();
			book.setTitle(title.getText());
			book.setGender(gender.getText());
			book.setReleaseDate(releaseDate.getText());
			book.setAuthor(author.getText());
			int pages = Integer.parseInt(pagesAmount.getText());
			book.setPagesAmount(pages);
			int copies = Integer.parseInt(copiesAmount.getText());
			book.setCopiesAmount(copies);
			double price = Double.parseDouble(rentPrice.getText());
			book.setRentPrice(price);
			
			BooksBO.add(book);
		}
	}
}
