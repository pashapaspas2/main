package by.bsu.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Step2Command implements ActionCommand {
	private static final String PARAM_NAME_EMAIL = "email";
	private static final String PARAM_NAME_ADDR = "addr";
	private static final String PARAM_NAME_S1 = "s1";
	private static final String PARAM_NAME_S2 = "s2";
	private static final String PARAM_NAME_S3 = "s3";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String email = request.getParameter(PARAM_NAME_EMAIL);
		String addr = request.getParameter(PARAM_NAME_ADDR);
		String s1 = request.getParameter(PARAM_NAME_S1);
		String s2 = request.getParameter(PARAM_NAME_S2);
		String s3 = request.getParameter(PARAM_NAME_S3);

		// request.setAttribute("user", login);
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("addr", addr);
		session.setAttribute("s1", s1);
		session.setAttribute("s2", s2);
		session.setAttribute("s3", s3);

		page = ConfigurationManager.getProperty("path.page.res");

		return page;
		// request.getSession().invalidate();
	}
}