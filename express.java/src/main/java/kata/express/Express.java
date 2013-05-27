package kata.express;

public class Express {

	public enum HTTPMethod { GET, POST, PUT, DELETE }

	public static Application express() {
		return new Application();
	}

}