package jersey.explore.services;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import jersey.explore.dal.Car;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

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

    @POST
    @Path("json")
    @Consumes(MediaType.APPLICATION_JSON)
    public String carFromJson(Car car){
        return "Car description: " + car.getDescription();
    }

    @POST
    @Path("pic")
    @Consumes({"image/jpeg", "image/png"})
    public String uploadPicture(byte[] picData){
        return "Pic size: " + picData.length;
    }

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(
            @FormDataParam("file1") InputStream uploadedInputStream,
            @FormDataParam("file1") FormDataContentDisposition fileDetail,
            @FormDataParam("file2") InputStream uploadedInputStream1,
            @FormDataParam("file2") FormDataContentDisposition fileDetail1) {
        String fileType = fileDetail.getType();
        return "File name is " + fileDetail.getName();
    }
}
