
package com.huseyn.messenger.exception;

import com.huseyn.messenger.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 500, "http://www.google.com");
               return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();

    }
    
}
