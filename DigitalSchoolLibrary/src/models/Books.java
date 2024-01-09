package models;

public class Books {
	
	
	private int id;
	private int isbn;
	private String name;
	private String author;
	private double price;
	
	public Books() {
		
	}
	
	public Books(int id, int isbn, String name, String author, double price) {
	super();
	this.id = id;
	this.isbn = isbn;
	this.name = name;
	this.author = author;
	this.price = price;
	
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}


