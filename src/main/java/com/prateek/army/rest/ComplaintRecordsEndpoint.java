package com.prateek.army.rest;

import com.prateek.army.Service.ComplaintRecordsSevice;
import com.prateek.army.Service.ComplaintRecordsSeviceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/complaintrecords")
public class ComplaintRecordsEndpoint {


    private ComplaintRecordsSevice complaintRecordsSevice = new ComplaintRecordsSeviceImpl();

    @GET
    @Path("/complaintId")
    @Produces(APPLICATION_JSON )
    public Response getComplaintIDs(){
        List<Integer> complaintId = complaintRecordsSevice.getComplaintId();
        if(complaintId.size() != 0) {
            return Response.ok().entity(complaintId).build();
        }
        else return Response.noContent().build();
    }

    @GET
    @Path("/summary")
    @Produces(APPLICATION_JSON )
    public Response getComplaintSummary(){

        List<String> complainSummary = complaintRecordsSevice.getSummary();
        if(complainSummary.size() != 0) {
            return Response.ok().entity(complainSummary).build();
        }
        else return Response.noContent().build();
    }
}
