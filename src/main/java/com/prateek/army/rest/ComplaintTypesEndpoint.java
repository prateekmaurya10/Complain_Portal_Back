package com.prateek.army.rest;

import com.prateek.army.Service.ComplaintTypeService;
import com.prateek.army.Service.ComplaintTypeServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/complaintTypes")
public class ComplaintTypesEndpoint {

    private ComplaintTypeService complaintTypeService = new ComplaintTypeServiceImpl();

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON )
    public Response getComplaintType(){
            List<String> complaintTypes = complaintTypeService.getComplaintTypes();
            if(complaintTypes.size() != 0) {
                return Response.ok().entity(complaintTypes).build();
            }
            else return Response.noContent().build();
    }
}
