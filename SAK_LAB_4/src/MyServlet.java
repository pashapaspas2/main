import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsu.example.command.ActionCommand;
import by.bsu.example.command.factory.ActionFactory;

@WebServlet("/MyServletURL")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		// определение команды, пришедшей из JSP
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);

		/*
		 * вызов реализованного метода execute() и передача параметров
		 * классу-обработчику конкретной команды
		 */
		page = command.execute(request);
		// метод возвращает страницу ответа

		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			// вызов страницы ответа на запрос
			dispatcher.forward(request, response);
		} else {
			System.out.println("ERER");
		}

	}

}
