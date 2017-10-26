package jersey.explore.services;

import jersey.explore.dal.Car;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("car")
public class CarRestService {

    @POST
    public String insertCar(
            @QueryParam("name") String name,
            @QueryParam("phone") String phone,
            @QueryParam("price") int price
    ){
        return "price is " + price;
    }

    @GET
    public Response getCar(
            @Context ServletContext context
            ){


        Response.ResponseBuilder builder = Response.ok();
        builder.entity("I am a car");
        return builder.build();
    }

    @POST
    @Path("entity")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(
            @QueryParam("description") String desc,
            @QueryParam("phone") String phone
    ){
        Car c = new Car();
        c.setDescription(desc);
        c.setPhone(phone);
        return c;
    }
}
