package il.co.electriccollege.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldRestService {

	@GET
	@Path("")
    @Produces(MediaType.TEXT_PLAIN)
	public String getSomething(@QueryParam("name") String name ) {

        return "Hello " + name;	
	}

//	@POST
//	@Path("/<add method name here>")
//    @Produces(MediaType.TEXT_PLAIN)
//	public String postSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {
//
//		String response = null;
//
//        return response;	
//	}
//
//	@PUT
//	@Path("/<add method name here>")
//    @Produces(MediaType.TEXT_PLAIN)
//	public String putSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {
//		return "F";
//	}
//
//	@DELETE
//	@Path("/<add method name here>")
//	public void deleteSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {
//		
//		
//	}
}
