package response;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;

import request.GETHttpRequest;
import request.HttpRequest;
//this is the response to GET request.
public class GETHttpResponse extends HttpResponse {
	
	@Override
	public void output(int statuscode, OutputStream out, HttpRequest request) {
		PrintWriter pw = new PrintWriter(out, true);
		File file=new File(((GETHttpRequest) request).getFilePath());
		try {
			pw.println("HTTP/1.0 "+statuscode+" "+HttpResponse.StatusCode.get(statuscode));
			pw.println("Content-type: "+Files.probeContentType(file.toPath()));
			pw.println();
			Files.copy(file.toPath(), out);
		} catch (IOException e) {
			
		}
		pw.flush();
		pw.close();
	}

}
