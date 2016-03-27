package by.bsu.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.bsu.example.beans.Book;

public class BookDAO extends DAO {

	private static BookDAO instance;

	private final String COLUMN_NAME_BID = "idbooks";
	private final String COLUMN_NAME_NAME = "b_name";
	private final String COLUMN_NAME_AUTHOR = "b_author";
	private final String COLUMN_NAME_PRICE = "b_price";

	private BookDAO() {
		super();
	}

	public static BookDAO getInstance() {
		if (instance == null) {
			instance = new BookDAO();
		}
		return instance;
	}

	public ArrayList<Book> getBooks() throws SQLException {

		String query = "SELECT * FROM books";
		ArrayList<Book> books = new ArrayList<>();
		PreparedStatement ps = null;
		ps = poolInstance.getConnection().prepareStatement(query);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			Book book = new Book();
			book.setId(res.getInt(COLUMN_NAME_BID));
			book.setName(res.getString(COLUMN_NAME_NAME));
			book.setAuthor(res.getString(COLUMN_NAME_AUTHOR));
			book.setPrice(res.getInt(COLUMN_NAME_PRICE));
			books.add(book);
		}
		return books;
	}

	public void addBook(Book book) throws SQLException {
		String query = "INSERTN INTO books (b_name, b_author, b_price) VALUES (?, ?, ?)";
		PreparedStatement ps = null;
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.executeQuery();
	}

	public Book getBookByID(int id) throws SQLException {
		Book book = null;
		String query = "SELECT * FROM books WHERE idbooks = ?";
		PreparedStatement ps = null;
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			book = new Book();
			book.setId(res.getInt(COLUMN_NAME_BID));
			book.setName(res.getString(COLUMN_NAME_NAME));
			book.setAuthor(res.getString(COLUMN_NAME_AUTHOR));
			book.setPrice(res.getInt(COLUMN_NAME_PRICE));
		}
		System.out.println(book);
		return book;
	}
}
