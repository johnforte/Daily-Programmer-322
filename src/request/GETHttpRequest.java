package request;

//This class extends HttpRequest and defines how a Get Request should be parsed
public class GETHttpRequest extends HttpRequest {
	private String filepath="";
	private String DocumentRoot="/var/www";
	@Override
	public void parse(String input) {
		String[] parts=input.split(" ");
		if(parts[0].trim().equalsIgnoreCase("GET")){
			this.filepath=parts[1].trim();
			if(this.filepath.equals("/")){
				this.filepath="/index.html";
			}
		}
	}
	//this method returns the full URI to the file the get request is looking for.
	public String getFilePath(){
		return DocumentRoot+this.filepath;
	}
	@Override
	public String getHttpMethod() {
		return "GET";
	}
}
