package by.bsu.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.bsu.example.beans.Book;
import by.bsu.example.beans.User;

public class UserDAO extends DAO {

	private static UserDAO instance;

	private final String COLUMN_NAME_UID = "idusers";
	private final String COLUMN_NAME_NAME = "u_name";
	private final String COLUMN_NAME_SURNAME = "u_surname";
	private final String COLUMN_NAME_EMAIL = "u_email";
	private final String COLUMN_NAME_PASSWORD = "u_pass";
	private final String COLUMN_NAME_SESSIONID = "u_sessionId";
	private final String COLUMN_NAME_ACESS = "u_acess";

	private UserDAO() {
		super();
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public User getUser(String login, String pass) throws SQLException {

		String query = "SELECT * FROM users WHERE u_email = ? and u_pass = ?";
		User user = null;
		PreparedStatement ps = null;
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.setString(1, login);
		ps.setString(2, pass);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			user = new User();
			user.setId(res.getInt(COLUMN_NAME_UID));
			user.setName(res.getString(COLUMN_NAME_NAME));
			user.setEmail(res.getString(COLUMN_NAME_EMAIL));
			user.setPassword(res.getString(COLUMN_NAME_PASSWORD));
			user.setAcessLevel(res.getInt(COLUMN_NAME_ACESS));
			user.setSessionId(res.getString(COLUMN_NAME_SESSIONID));
		}
		return user;
	}

	public List<Book> getBooksByUserId(int id) throws SQLException {
		String query = "SELECT * FROM user_has_book WHERE iduser = ?";
		ArrayList<Book> books = new ArrayList<>();
		PreparedStatement ps = null;
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			books.add(BookDAO.getInstance().getBookByID(res.getInt("idbook")));
		}
		System.out.println(books);
		return books;
	}

	public User getUserBySession(String sId) throws SQLException {
		String query = "SELECT * FROM users WHERE u_sessionId = ?";
		User user = null;
		PreparedStatement ps = null;
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.setString(1, sId);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			user = new User();
			user.setId(res.getInt(COLUMN_NAME_UID));
			user.setName(res.getString(COLUMN_NAME_NAME));
			user.setEmail(res.getString(COLUMN_NAME_EMAIL));
			user.setPassword(res.getString(COLUMN_NAME_PASSWORD));
			user.setAcessLevel(res.getInt(COLUMN_NAME_ACESS));
			user.setSessionId(res.getString(COLUMN_NAME_SESSIONID));
		}
		return user;

	}

	public void updateUser(User user) throws SQLException {
		String query = "UPDATE users SET u_sessionId = ? WHERE idusers = ?";
		PreparedStatement ps = null;
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.setString(1, user.getSessionId());
		ps.setInt(2, user.getId());
		ps.executeUpdate();

	}

}
