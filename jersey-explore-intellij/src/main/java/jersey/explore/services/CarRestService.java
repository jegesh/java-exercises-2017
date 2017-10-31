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
import javax.ws.rs.core.SecurityContext;
import java.io.*;

@Path("car")
public class CarRestService {
    private final static String UPLOAD_DIR = "/uploads/";

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
    public String uploadPicture(byte[] picData,
                                @Context ServletContext context) throws IOException {
        String appPath = context.getRealPath("");
        String appName = context.getContextPath();
        int files = new File(appPath + UPLOAD_DIR).listFiles().length;
        String filename = "uploaded" + files;
        File upload = new File(appPath + UPLOAD_DIR + filename);
        new FileOutputStream(upload).write(picData);
        // save to database
        return "File saved to " + UPLOAD_DIR + filename;
    }

    @POST
    @Consumes({"image/jpeg", "image/png"})
    public String uploadPicture(
            @QueryParam("description") String desc,
            @QueryParam("phone") String phone,
            byte[] picData,
            @Context ServletContext context
    ) throws IOException {
        String appPath = context.getRealPath("");
        String appName = context.getContextPath();
        Car car = new Car();
        int files = new File(appPath + UPLOAD_DIR).listFiles().length;
        String filename = "uploaded" + files;
        File upload = new File(appPath + UPLOAD_DIR + filename);
        new FileOutputStream(upload).write(picData);
        car.setPhone(phone);
        car.setDescription(desc);
        car.setPicture(appName + UPLOAD_DIR + filename);
        // TODO save to database
        return "File saved to " + UPLOAD_DIR + filename;
    }

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(
            @FormDataParam("file1") InputStream uploadedInputStream,
            @FormDataParam("file1") FormDataContentDisposition fileDetail,
            @FormDataParam("file2") InputStream uploadedInputStream1,
            @FormDataParam("file2") FormDataContentDisposition fileDetail1) {
        return "File name is " + fileDetail.getFileName();
    }

    @DELETE
    @Path("{id}")
    public String removeCar(
            @PathParam("id") long carId,
            @Context SecurityContext securityContext
            ){
        if(!securityContext.isUserInRole("admin")){
            throw new WebApplicationException(403);
        }

        return "Car " + carId + " has been removed";
    }
}
