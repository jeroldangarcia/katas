package kata.express;

import java.util.Map;
import java.util.HashMap;

class Router {
	
	String title;

	Map<String, RouteHandler> getHandlers = new HashMap<>();
	Map<String, RouteHandler> postHandlers = new HashMap<>();

	public void get(String route, RouteHandler handler) {
		getHandlers.put(route, handler);
	}

	public void post(String urlPattern, RouteHandler handler) {
		postHandlers.put(urlPattern, handler);
	}
	
	public void handle(HTTPMethod method, String urlPattern) {
		RouterRequest request = null;
		RouterResponse response = null;
		getHandlers.get(urlPattern).handle(request, response);
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}