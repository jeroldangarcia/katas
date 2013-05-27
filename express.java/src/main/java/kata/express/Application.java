package kata.express;

import static kata.express.Express.HTTPMethod.*;

import kata.express.Express.HTTPMethod;

public class Application {

	public Routes routes = new Routes();

	public Application() {
	}

	public void get(String path, RouteHandler handler) {
		routes.add(GET, path, handler);
	}

	public void post(String path, RouteHandler handler) {
		routes.add(POST, path, handler);
	}

	public void put(String path, RouteHandler handler) {
		routes.add(PUT, path, handler);
	}

	public void delete(String path. RouteHandler handler) {
		routes.add(DELETE, path, handler);
	}

	public void process(HTTPMethod method, RouteRequest request) {
		Route route = routes.get(method, request.path);
		route.process(request);
	}
}