package kata.express;

import kata.express.RouteRequest;
import kata.express.RouteResponse;

public interface RouteHandler {
	
	public void handle(RouteRequest request, RouteResponse response);

}