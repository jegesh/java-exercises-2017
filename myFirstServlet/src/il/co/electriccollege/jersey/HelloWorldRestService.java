package il.co.electriccollege.jersey;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldRestService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloQueryParam(
			@QueryParam("name") 
			@DefaultValue("yaakov") 
			String name 
	) {
		
		return "Hello " + name;
	}
	
	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPathParam(
			@PathParam("name") 
			String name 
	) {
		
		return "Hello " + name;
	}
}
