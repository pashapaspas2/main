package by.bsu.example.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsu.example.beans.User;
import by.bsu.example.dao.BookDAO;
import by.bsu.example.dao.UserDAO;

public class SessionRequestContent {

	private static SessionRequestContent instance;

	private SessionRequestContent() {

	}

	public static SessionRequestContent getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return new SessionRequestContent();
		}
	}

	// метод добавления в запрос данных для передачи в jsp
	public synchronized void insertAttributes(HttpServletRequest request) throws SQLException {
		String sessionId = request.getSession().getId();
		BookDAO bookDAO = BookDAO.getInstance();
		UserDAO userDAO = UserDAO.getInstance();
		User user = userDAO.getUserBySession(sessionId);
		request.getSession().setAttribute("books", bookDAO.getBooks());
		request.getSession().setAttribute("userbooks", userDAO.getBooksByUserId(user.getId()));
		request.getSession().setAttribute("user", user);

	}
	// some methods
}