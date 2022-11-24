package com.br.api.Controller;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.br.api.DTO.BookDTO;
import com.br.api.Views.Main;
import com.br.model.Services.BooksBO;
import com.br.model.Services.ProductsBO;
import com.br.model.entity.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadBooksController {
	BooksBO bo = new BooksBO();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="author"
    private TextField author; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddLivro"
    private Button buttonAddLivro; // Value injected by FXMLLoader

    @FXML // fx:id="closeButton"
    private Button closeButton; // Value injected by FXMLLoader

    @FXML // fx:id="copiesAmount"
    private TextField copiesAmount; // Value injected by FXMLLoader

    @FXML // fx:id="gender"
    private TextField gender; // Value injected by FXMLLoader

    @FXML // fx:id="msgCadastroIncompleto"
    private Label msgCadastroIncompleto; // Value injected by FXMLLoader

    @FXML // fx:id="pagesAmount"
    private TextField pagesAmount; // Value injected by FXMLLoader

    @FXML // fx:id="releaseDate"
    private TextField releaseDate; // Value injected by FXMLLoader

    @FXML // fx:id="rentPrice"
    private TextField rentPrice; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private TextField title; // Value injected by FXMLLoader

    @FXML
    void cadastrar(ActionEvent event) throws ParseException {
		if(title.getText().isEmpty() || gender.getText().isEmpty() || releaseDate.getText().isEmpty() || author.getText().isEmpty() || pagesAmount.getText().isEmpty() || copiesAmount.getText().isEmpty() || rentPrice.getText().isEmpty()) {
			msgCadastroIncompleto.setVisible(true);
		}
		else {
			BookDTO book = new BookDTO();
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
			
			try {
				bo.registerBooks(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
    }

    @FXML
    void close(ActionEvent event) {
		Main.telaControleLivro();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert buttonAddLivro != null : "fx:id=\"buttonAddLivro\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert copiesAmount != null : "fx:id=\"copiesAmount\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert msgCadastroIncompleto != null : "fx:id=\"msgCadastroIncompleto\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert pagesAmount != null : "fx:id=\"pagesAmount\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert releaseDate != null : "fx:id=\"releaseDate\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert rentPrice != null : "fx:id=\"rentPrice\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'cadastrarBooksTela.fxml'.";

    }
}

