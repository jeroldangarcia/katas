package kata.express;

import kata.express.Express.HTTPMethod;

public class Route {
		
	public final String path;
	public final HTTPMethod method;
	public final RouteHandler handler;

	public Route(final HTTPMethod method, final String path, final RouteHandler handler) {
		this.path = path;
		this.method = method;
		this.handler = handler;
	}

	public void process(RouteRequest request, RouteResponse response) {
		handler.handle(request, response);
	}
}