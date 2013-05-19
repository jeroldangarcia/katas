package kata.express;

interface RouteHandler {
	
	public void handle(RouterRequest request, RouterResponse response);

}