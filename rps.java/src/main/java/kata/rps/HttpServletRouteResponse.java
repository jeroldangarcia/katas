package kata.rps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kata.express.RouteResponse;

public class HttpServletRouteResponse implements RouteResponse {

	private HttpServletResponse response;
	private HttpServletRequest request;

	public HttpServletRouteResponse(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	@Override
	public void send(String message) {
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println(message);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void redirect(String path) {
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void render(String view, Map context) {
		
		try {
			request.getServletContext().getRequestDispatcher(view).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
