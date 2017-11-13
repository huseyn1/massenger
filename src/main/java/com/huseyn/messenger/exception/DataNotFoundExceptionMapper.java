/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huseyn.messenger.exception;

import com.huseyn.messenger.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage=new ErrorMessage(e.getMessage(), 404, "http://www.stackoverflow.com");
       return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }
    
}
