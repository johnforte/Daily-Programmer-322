package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import request.HttpRequest;
import request.HttpRequestFactory;
import response.HttpResponse;
import response.HttpResponseFactory;

public class WebServer {
	//The main class starts the server, and creates the listeners as well as the parses the input
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(8080);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    HttpRequest request=null;
                    while (true) {
                        String input = in.readLine();
                        request=HttpRequestFactory.getHttpRequest(input.split(" ")[0], input);
                        if (input == null || input=="" || request!=null) {
                            break;
                        }
                    }
                    if(request.getHttpMethod().equals("GET")){
                    	HttpResponse response=HttpResponseFactory.getHttpResponse(request.getHttpMethod());
                    	response.output(200, socket.getOutputStream(), request);
                    }
                } finally {
                    socket.close();
                }
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
            listener.close();
        }
	}

}
