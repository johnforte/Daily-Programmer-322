package request;

//This factory returns the right Request, and starts the parse method
//TODO: it shouldn't return null, it should return an unknown request class
public class HttpRequestFactory {
	public static HttpRequest getHttpRequest(String httpcode, String input){
		if(httpcode.equalsIgnoreCase("GET")){
			GETHttpRequest request=new GETHttpRequest();
			request.parse(input);
			return request;
		}
		return null;
		
	}
}
