package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Books;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import dao.BookDAOImp;
import database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class DashboardController implements Initializable{
	@FXML
	private TextField isbnInput;
	@FXML
	private TextField nameInput;
	@FXML
	private TextField authorInput;
	@FXML
	private TextField priceInput;
	@FXML
	private Button insertButton;
	@FXML
	private Button updateButton;
	@FXML
	private Button deleteButton;
	@FXML
	private TableView<Books> BooksTable;
	@FXML
	private TableColumn<Books,Integer> isbnColumn;
	@FXML
	private TableColumn<Books,String> nameColumn;
	@FXML
	private TableColumn<Books,String> authorColumn;
	@FXML
	private TableColumn<Books,Double> priceColumn;
	
	Connection conn = null;

	// Event Listener on Button[#insertButton].onAction
	@FXML
	public void insertButtonAction(ActionEvent event) {
		Books book = new Books();
		
		int isbn = Integer. parseInt(isbnInput.getText());
		String name = nameInput.getText();
		String author = authorInput.getText();
		Double price = Double.parseDouble(priceInput.getText());
		
		book.setIsbn(isbn); 
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		
		BookDAOImp dao = new BookDAOImp();
		dao.save(book);
		
		showBooks();
	}
	
	// Event Listener on Button[#deleteButton].onAction
	@FXML
	public void deleteButtonAction(ActionEvent event) {
		
		Books selectedBook = BooksTable.getSelectionModel().getSelectedItem();
		
		BookDAOImp dao = new BookDAOImp();
		dao.delete(selectedBook);
		
		showBooks();
	}
	
	
	// Event Listener on Button[#updateButton].onAction
	@FXML
	public void updateButtonAction(ActionEvent event) {
				
		Books selectedBook = new Books();
		selectedBook = BooksTable.getSelectionModel().getSelectedItem();
				
		int isbnUpdated = Integer. parseInt(isbnInput.getText());
		Double priceUpdated = Double.parseDouble(priceInput.getText());
				
		selectedBook.setIsbn(isbnUpdated);
		selectedBook.setName(nameInput.getText());
		selectedBook.setAuthor(authorInput.getText());
		selectedBook.setPrice(priceUpdated);
				
				
		BookDAOImp dao = new BookDAOImp();
		dao.update(selectedBook);
				
		showBooks();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showBooks();
		
		BooksTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	Books selectedBook = BooksTable.getSelectionModel().getSelectedItem();
		    	
		    	Integer isbnSelected = selectedBook.getIsbn();
		    	Double priceSelected = selectedBook.getPrice();
		    	
		    	isbnInput.setText(isbnSelected.toString());
		    	nameInput.setText(selectedBook.getName());
		    	authorInput.setText(selectedBook.getAuthor());
		    	priceInput.setText(priceSelected.toString());
		    	
		    

		    }
		});
	}	
	
	
	
	public void showBooks() {
		BookDAOImp dao = new BookDAOImp();
		ObservableList<Books> books = dao.getBooks();;
		
		isbnColumn.setCellValueFactory(new PropertyValueFactory<Books, Integer>("isbn"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("name"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<Books, Double>("price"));
		
		BooksTable.setItems(books);

	}
	


	
}












