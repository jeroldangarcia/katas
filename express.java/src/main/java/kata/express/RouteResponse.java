package kata.express;

import java.util.Map;

public interface RouteResponse {

    /**
     * The Content-Type is set defaulted to "text/html"
     *
     * @param content
     */
	public void send(String content);

    /**
     * Will respond with the JSON representation
     * The Content-Type is set defaulted to "application/json"
     *
     * @param object
     */
    public void send(Object object);

    /**
     *
     * @param status
     */
    public void send(int status);

	public void redirect(String path);

	public void render(String view, Map context);

}