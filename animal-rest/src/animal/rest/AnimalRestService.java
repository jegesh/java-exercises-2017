package animal.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.google.gson.Gson;

import animal.dal.Animal;
import animal.dal.AnimalDal;
import animal.dal.DbConnector;

@Path("animal")
public class AnimalRestService {


	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public String getAllAnimals() throws SQLException {
		
        return new Gson().toJson(new AnimalDal(DbConnector.DB_PRODUCTION).getAnimals()).toString();	
	}

	@POST
    @Produces(MediaType.TEXT_PLAIN)
	public String add(
				@QueryParam("species") String species,
				@QueryParam("name") String name,
				@QueryParam("age") int age
			) throws SQLException {
		Animal anim = new Animal();
		anim.setAge(age);
		anim.setName(name);
		anim.setSpecies(species);
        return new AnimalDal(DbConnector.DB_PRODUCTION).addAnimal(anim) ? "success" : "failed";
	}
	
	@DELETE
	@Path("{id}")
	public String deleteSomething(
			@PathParam("id") long id,
			@Context SecurityContext context
			) {
		if(!context.isUserInRole("admin"))
			throw new WebApplicationException(403);
		return new AnimalDal(DbConnector.DB_PRODUCTION).delete(id) ? "success" : "failed";
	}
	
	@PUT
	@Path("{id}/{key}/{value}")
	public String update(
			@PathParam("id") long id,
			@PathParam("key") String key,
			@PathParam("value") String value
			) {
		
		
		return new AnimalDal(DbConnector.DB_PRODUCTION).delete(id) ? "success" : "failed";
	}
}
