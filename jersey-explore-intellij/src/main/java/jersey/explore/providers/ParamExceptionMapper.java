package jersey.explore.providers;

import com.sun.jersey.api.ParamException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ParamExceptionMapper implements ExceptionMapper<ParamException>{
    public Response toResponse(ParamException exception) {
        String msg = "Error: param %s is incorrect: %s";
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(String.format(msg, exception.getParameterName(), exception.getMessage()))
                .build();
    }
}
