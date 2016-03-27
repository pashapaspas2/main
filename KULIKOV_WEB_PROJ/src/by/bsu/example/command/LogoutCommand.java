package by.bsu.example.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsu.example.beans.User;
import by.bsu.example.dao.UserDAO;
import by.bsu.example.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		String page = ConfigurationManager.getProperty("path.page.index");
		UserDAO userDAO = UserDAO.getInstance();
		// уничтожение сессии
		User user = (User) request.getSession().getAttribute("user");
		user.setSessionId(null);
		userDAO.updateUser(user);
		request.getSession().invalidate();

		return page;
	}
}