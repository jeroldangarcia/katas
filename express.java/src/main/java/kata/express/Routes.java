package kata.express;

import static com.google.common.base.Preconditions.*;
import static kata.express.Express.HTTPMethod.*;

import kata.express.Express.HTTPMethod;

import java.util.Map;
import java.util.HashMap;

public class Routes {

	Map<String, Route> getRoutes    = new HashMap<>();
	Map<String, Route> postRoutes   = new HashMap<>();
	Map<String, Route> putRoutes    = new HashMap<>();
	Map<String, Route> deleteRoutes = new HashMap<>();

	public void add(HTTPMethod method, String path, RouteHandler handler) {

		checkArgument( method  != null, "method should not be null");
		checkArgument( path    != null, "path should not be null");
		checkArgument( !path.isEmpty(), "path should not be empty");
		checkArgument( handler != null, "handler should not be null");

		mapFor(method).put(path, new Route(method, path, handler));
	}

	public Route get(HTTPMethod method, String path) throws IllegalArgumentException {

		checkArgument( method  != null, "method should not be null");
		checkArgument( path    != null, "path should not be null");
		checkArgument( !path.isEmpty(), "path should not be empty");
		checkArgument( mapFor(method).containsKey(path), "path not found");

		return mapFor(method).get(path);
	}
	
	public int size() {
		return getRoutes.size() + postRoutes.size() + putRoutes.size() + deleteRoutes.size();
	}

	private Map<String, Route> mapFor(HTTPMethod method) throws IllegalArgumentException {
		switch (method) {
			case GET  : 
				return getRoutes; 
			case POST : 
				return postRoutes;
			case PUT  : 
				return putRoutes; 
			case DELETE : 
				return deleteRoutes;
			default :
				throw new IllegalArgumentException();
		}
	}
	
}