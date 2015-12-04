package kata.express;

import static org.junit.Assert.*;
import static kata.express.Express.*;
import static kata.express.Express.HTTPMethod.*;

import org.junit.*;

public class TestApplication {

	Application app;

	@Before
	public void setup() {
		app = express();
	}

	@Test 
	public void shouldAddRoute() {
		app.get   ("/world", (req, res) -> res.send("get world"));
		app.post  ("/world", (req, res) -> res.send("post world"));
		app.put   ("/world", (req, res) -> res.send("put world"));
		app.delete("/world", (req, res) -> res.send("delete world"));
		assertEquals(4, app.routes.size());
	}

	@Test(expected=IllegalArgumentException.class) 
	public void shouldNotProcessInvalidRequest() {
		app.process(GET, new RouteRequest("/invalid"), new RouteResponse() {
        });
	}

	@Test 
	public void shoulProcessRequest() {
		app.get("/", (req, res) -> res.send("hello world"));
		app.process(GET, new RouteRequest("/"));
		//TODO: response output assertions
	}

}
