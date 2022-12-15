package pkg1;
import static spark.Spark.*;
public class apiSpark {
	
	
	

	 
	    public static void main(String[] args) {
	        get("/hello", (req, res) -> "Hello World");
	    }
	 

}
