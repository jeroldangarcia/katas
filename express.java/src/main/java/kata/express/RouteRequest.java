package kata.express;

public interface RouteRequest {

    String param(String name);

    String header(String field);

}