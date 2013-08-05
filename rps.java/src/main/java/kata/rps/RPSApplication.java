package kata.rps;

import javax.inject.Named;

import kata.express.Application;
import kata.express.RouteHandler;
import kata.express.RouteRequest;
import kata.express.RouteResponse;

@Named
public class RPSApplication extends Application {

	public RPSApplication() {
		super();
		init();
	}
	
	private void init() {
		
		get("/menu", new RouteHandler() {
			@Override
			public void handle(RouteRequest request, RouteResponse response) {
				response.redirect("http://localhost:8080/rps.java/menu.html");
			}
		});
	}
}
