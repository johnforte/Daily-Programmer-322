package response;

//This response factory returns the correct HttpResponse object and holds the document root to load html files from.
//TODO: add unknown httpresponse 
public class HttpResponseFactory {
	public static HttpResponse getHttpResponse(String httpcode){
		if(httpcode.equalsIgnoreCase("GET")){
			GETHttpResponse response=new GETHttpResponse();
			return response;
		}
		return null;
	}
	public static String getDocumentRoot(){
		return "/var";
	}
}
