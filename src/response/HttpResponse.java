package response;

import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import request.HttpRequest;
//This is the abstract class for future request, IE: Head, post
public abstract class HttpResponse {
	//this setup the key words that are found in the first line in a response
	protected static final Map<Integer, String> StatusCode;
	static {
        Map<Integer, String> tempmap = new HashMap<Integer, String>();
        tempmap.put(200, "OK");
        tempmap.put(404, "NOT FOUND");
        StatusCode = Collections.unmodifiableMap(tempmap);
    }
	//this is the method that outputs the response to the browser
	public abstract void output(int statuscode, OutputStream out, HttpRequest request);
}