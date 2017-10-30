package il.co.electriccollege.jersey;


import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("car")
public class CarRestService {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getCar(
			@QueryParam("model") String model,
			@QueryParam("year") String year
			) throws JSONException {
		
		if(model == null) {
			return Response.status(Status.BAD_REQUEST)
					.entity(new JSONObject("{\"error\":\"Car model is required\"}")).build();
		}

		Car c = new Car();
		c.setDescription(model);
		c.setPhone(year);
        return Response.ok().entity(c).build(); 	
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCar(
			@QueryParam("year") String year, 
			@QueryParam("model") String model,
			@QueryParam("price") @DefaultValue("1") int price,
			@HeaderParam("Accept") String contentAccept,
			@CookieParam("myCookie") String userId
			) {
		
		// insert car object into database
		return "insertion id = ?";
	}
	
	@POST
	@Path("cookies")
	public Response setCookies(@QueryParam("value") String cookieValue) {
		return Response.ok("Cookie set!")
	               .cookie(new NewCookie("myCookie", cookieValue))
	               .build();
	}
	
	@POST
	@Consumes({ "image/jpeg", "image/png" })
	@Path("{id}/pic")
	public String carPic(@PathParam("id") long id, byte[] imageBytes) {
		return "Pic size: "+ imageBytes.length;
	}
	
	@POST
	@Path("json")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertCar(Car car) {
		
		return "Car description: " + car.getDescription();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response updateCar(
			@PathParam("id") long id,
			@QueryParam("year") String year, 
			@QueryParam("model") String model,
			@QueryParam("price") int price,
			@Context HttpServletResponse response
			) throws Exception {
		
		// if id is invalid
		if(id < 1000) {
			response.setStatus(400);
			response.getWriter().append("<p>Invalid car id</p>");
			response.flushBuffer();
			return null;
		}
		
		// update car data
		return Response.ok("<p>Car " + id + " updated successfully</p>").build();
	}
	
	
}
