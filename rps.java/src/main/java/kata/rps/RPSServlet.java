package kata.rps;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kata.express.Application;
import kata.express.Express.HTTPMethod;

@WebServlet("/rps/*")
public class RPSServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	Application application;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getPathInfo();
		System.out.println(path);
		application.process(
				HTTPMethod.GET, 
				new HttpServletRouteRequest(path, request), 
				new HttpServletRouteResponse(request, response));
	}

}