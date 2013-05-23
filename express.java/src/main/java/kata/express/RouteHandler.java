package kata.express;

import kata.express.RouteRequest;
import kata.express.RouteResponse;

interface RouteHandler {
	
	public void handle(RouteRequest request, RouteResponse response);

}