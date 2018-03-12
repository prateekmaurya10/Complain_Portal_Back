package com.prateek.army.rest;

import com.prateek.army.Service.AreaService;
import com.prateek.army.Service.AreaServiceImpl;
import com.prateek.army.model.Area;

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
        List<Area> areaList = areaService.getAreas();
        if(areaList.size() != 0) {
            return Response.ok().entity(areaList).build();
        }
        else return Response.noContent().build();
    }
}
