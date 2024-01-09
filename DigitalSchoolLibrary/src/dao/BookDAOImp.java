package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Books;

public class BookDAOImp implements BookDAO{
	
	
	Connection conn = null;


	@Override
	public void save(Books book) {
		conn = DatabaseConnection.ConnectDB();
		String query = "INSERT INTO books (isbn, name, author, price) VALUES (?,?,?,?);";
		
		
		try {	
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setInt(1, book.getIsbn());
			preparedStmt.setString(2, book.getName());
			preparedStmt.setString(3, book.getAuthor());
			preparedStmt.setDouble(4, book.getPrice());
			
			preparedStmt.execute();
			
		
	
		}catch(Exception ex) {
		ex.printStackTrace();
		}
		
	}
	
	
	public ObservableList<Books> getBooks(){
		ObservableList<Books> listOfBooks = FXCollections.observableArrayList();
		conn = DatabaseConnection.ConnectDB();	
		String query = "SELECT * FROM books";
		Statement statement;
		ResultSet queryResult;
		
		try {
			statement = conn.createStatement();
			queryResult = statement.executeQuery(query);
			Books books;
			while(queryResult.next()) {
				books = new Books(queryResult.getInt("id"), queryResult.getInt("isbn"),
						          queryResult.getString("name"),queryResult.getString("author"),
						          queryResult.getDouble("price"));
					
				listOfBooks.add(books);
			}	
		}catch(Exception ex) {
		ex.printStackTrace();
		}
		
		return listOfBooks;
	}
	
	

	@Override
	public void update(Books book) {
		conn = DatabaseConnection.ConnectDB();
		String query = "UPDATE books SET isbn = ?, name = ?, author = ?, price = ? WHERE id = ?";
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			
			preparedStmt.setInt(1, book.getIsbn());
			preparedStmt.setString(2, book.getName());
			preparedStmt.setString(3, book.getAuthor());
			preparedStmt.setDouble(4, book.getPrice());
			preparedStmt.setInt(5, book.getId());
			
			preparedStmt.executeUpdate();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
		
	}

	@Override
	public void delete(Books book) {
		conn = DatabaseConnection.ConnectDB();
		
		String query = "DELETE FROM books where id = ?";
		
		try {	
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setInt(1, book.getId());
			
			preparedStmt.execute();
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
