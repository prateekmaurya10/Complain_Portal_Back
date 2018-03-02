package com.prateek.army.rest;

import com.prateek.army.Service.AreaService;
import com.prateek.army.Service.AreaServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/areas")
public class AreasEndpoint {

    private AreaService areaService = new AreaServiceImpl();

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON )
    public Response getAreaNames(){
        List<String> areaNames = areaService.getAreas();
        if(areaNames.size() != 0) {
            return Response.ok().entity(areaNames).build();
        }
        else return Response.noContent().build();
    }
}
