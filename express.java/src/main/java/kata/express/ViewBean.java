package kata.express;

import java.util.HashMap;
import java.util.Map;

public class ViewBean {

	private Map<String, String> params = new HashMap<>();

	public ViewBean() {
	}

	public String param(String name) {
		return params.get(name);
	}

	public void param(String name, String value) {
		params.put(name, value);
	}
} 