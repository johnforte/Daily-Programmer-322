package request;


//This is the abstract class for future request, IE: Head, post
public abstract class HttpRequest{
	//Defines the method parse for how the request should be parsed
	public abstract void parse(String input);
	//Defines the http method IE: GET, POST, HEAD
	public abstract String getHttpMethod();
}
