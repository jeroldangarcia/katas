package kata.express;

import java.util.Map;

public interface RouteResponse {

	public void send(String content);
	public void redirect(String path);
	public void render(String view, Map context);

}