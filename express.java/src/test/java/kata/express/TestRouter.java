package kata.express;

import static org.junit.Assert.*;
import org.junit.*;

class TestRouter {

	Router app;

	@Before
	public void setup() {
		this.app = new Router();
	}

	@Test 
	public void shoulHandleRoute() {

		app.get("/", (req, res) -> res.send("hello world"));

		app.get("/login", (req, res) -> {

			ViewBean viewBean = new ViewBean();
			viewBean.param("user",    req.param("user"));
			viewBean.param("message", req.flash("error"));

			res.render('login', viewBean);
		});

		app.post("/login", 
			(req) -> authentication("local", req),
			(req, res) -> res.redirect("/")
		);

		app.get("/profiles/{userID}", 
			(req) -> authenticated(req),
			(req, res) -> res.send("hi "+req.param("userID"))
		);

	}

}