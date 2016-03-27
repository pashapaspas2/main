package by.bsu.example.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsu.example.beans.User;
import by.bsu.example.dao.BookDAO;
import by.bsu.example.dao.UserDAO;
import by.bsu.example.resource.ConfigurationManager;
import by.bsu.example.resource.MessageManager;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "email";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		String page = null;
		BookDAO bookDAO = BookDAO.getInstance();
		UserDAO userDAO = UserDAO.getInstance();
		String login;
		String pass;

		login = request.getParameter(PARAM_NAME_LOGIN);
		pass = request.getParameter(PARAM_NAME_PASSWORD);

		User user = userDAO.getUser(login, pass);
		if (user != null) {
			// Определить идентификатор Java-сессии пользователя
			String sessionId = request.getSession().getId();

			user.setSessionId(sessionId);
			userDAO.updateUser(user);
			// Так как одновременно выполняются запросы от множества
			// пользователей
			// то необходима синхронизация на ресурсе

			// SessionRequestContent.getInstance().insertAttributes(request);
			request.getSession().setAttribute("books", bookDAO.getBooks());
			request.getSession().setAttribute("userbooks", userDAO.getBooksByUserId(user.getId()));
			request.getSession().setAttribute("user", user);

			page = ConfigurationManager.getProperty("path.page.user");
		} else {
			page = ConfigurationManager.getProperty("path.page.login");
			request.getSession().setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
		}
		return page;
	}
}
