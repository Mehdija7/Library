package dao;

import javafx.collections.ObservableList;
import models.Books;

public interface BookDAO {
	
	
	public void save(Books book);
	public void update(Books book);
	public void delete(Books book);
	public ObservableList<Books> getBooks();

}
