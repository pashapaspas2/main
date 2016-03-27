package by.bsu.example.command;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import by.bsu.example.beans.User;
import by.bsu.example.dao.UserDAO;
import by.bsu.example.resource.ConfigurationManager;
import by.bsu.example.servlet.SessionRequestContent;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		UserDAO userDAO = UserDAO.getInstance();
		/*
		 * в случае ошибки или прямого обращения к контроллеру переадресация на
		 * страницу ввода логина
		 */
		String page = null;
		// восстановить его через cookie
		String previousSessionId = null;
		// Определить идентификатор Java-сессии пользователя
		String sessionId = request.getSession().getId();

		// Найти cookie с именем sessionId
		if (request.getCookies() != null) {
			for (Cookie aCookie : request.getCookies()) {
				if (aCookie.getName().equals("sessionId")) {
					// Запомнить значение этого cookie - это старый
					// идентификатор сессии
					previousSessionId = aCookie.getValue();
					break;
				}
			}
		}
		if (previousSessionId != null) {
			// Мы нашли session cookie
			// Найти пользователя, у которого sessionId = найденному

			User user = userDAO.getUserBySession(previousSessionId);
			if (user != null) {
				user.setSessionId(sessionId);
				userDAO.updateUser(user);
				SessionRequestContent.getInstance().insertAttributes(request);
				page = ConfigurationManager.getProperty("path.page.user");
			} else
				page = ConfigurationManager.getProperty("path.page.login");

		}
		if (page == null) {
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}