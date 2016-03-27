package by.bsu.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Step1Command implements ActionCommand {
	private static final String PARAM_NAME_NAME = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из запроса логина и пароля
		String name = request.getParameter(PARAM_NAME_NAME);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		HttpSession session = request.getSession(true);
		session.setAttribute("username", name);
		session.setAttribute("password", pass);

		System.out.println(name + pass);
		// проверка логина и пароля

		// request.setAttribute("user", login);

		// определение пути к main.jsp
		page = ConfigurationManager.getProperty("path.page.info");

		return page;
	}
}
