package il.co.electriccollege.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("car")
public class CarRestService {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public String getCarList(
			@QueryParam("model") String name,
			@QueryParam("year") String year
			) {

		// retrieve list of cars based on query parameters
        return "[]"; 	
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCar(
			@QueryParam("year") String year, 
			@QueryParam("model") String model,
			@QueryParam("price") int price
			) {
		
		// insert car object into database
		return "insertion id = ?";
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response updateCar(
			@PathParam("id") String id,
			@QueryParam("year") String year, 
			@QueryParam("model") String model,
			@QueryParam("price") int price
			) {
		
		// if id doesn't exist
		if(id.equals("whatever"))
			return Response.status(Status.BAD_REQUEST).entity("<p>Unknown car id</p>").build();
		
		// update car data
		return Response.ok("<p>Car " + id + " updated successfully</p>").build();
	}
	
	
}
