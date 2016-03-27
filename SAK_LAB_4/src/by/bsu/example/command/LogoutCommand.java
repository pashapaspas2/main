package by.bsu.example.command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {

	public LogoutCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().invalidate();
		return ConfigurationManager.getProperty("path.page.index");
	}

}
