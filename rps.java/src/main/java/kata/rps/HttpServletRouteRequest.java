package kata.rps;

import javax.servlet.http.HttpServletRequest;

import kata.express.RouteRequest;

public class HttpServletRouteRequest extends RouteRequest {

	HttpServletRequest request;
	
	public HttpServletRouteRequest(String path, HttpServletRequest request) {
		super(path);
		this.request = request;
	}

}
