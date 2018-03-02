package com.prateek.army.rest;


import com.prateek.army.Service.QtrsService;
import com.prateek.army.Service.QtrsServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/Qtrs")
public class QtrsEndpoint {

    private QtrsService qtrsService = new QtrsServiceImpl();

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON )
    public Response getQtrNos(){
        List<Integer> qtrNos = qtrsService.getQtrs();
        if(qtrNos.size() != 0) {
            return Response.ok().entity(qtrNos).build();
        }
        else return Response.noContent().build();
    }
}
