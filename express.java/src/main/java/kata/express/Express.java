package kata.express;

public class Express {

	public enum HTTPMethod { GET, POST }

	public static Application express() {
		return new Application();
	}

}