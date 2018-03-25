package com.prateek.army.rest;


import com.prateek.army.Service.QtrsService;
import com.prateek.army.Service.QtrsServiceImpl;
import com.prateek.army.model.Qtrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        List<Qtrs> qtrNos = qtrsService.getQtrs();
        if(qtrNos.size() != 0) {
            return Response.ok().entity(qtrNos).build();
        }
        else return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getQtrNoByArea(@PathParam("id") int id) {
        List<Qtrs> qtrNos = qtrsService.getQtrsByArea(id);
        if(qtrNos.size() != 0) {
            return Response.ok().entity(qtrNos).build();
        }
        else return Response.noContent().build();
    }
}

