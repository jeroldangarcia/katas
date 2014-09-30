package kata.express;

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

	public void delete(String path, RouteHandler handler) {
		routes.add(DELETE, path, handler);
	}

	public void process(HTTPMethod method, RouteRequest request, RouteResponse response) {
		Route route = routes.get(method, request.path);
		route.process(request, response);
	}
}