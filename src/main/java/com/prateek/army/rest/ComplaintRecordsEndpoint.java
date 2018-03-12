package com.prateek.army.rest;

import com.prateek.army.Service.ComplaintRecordsSevice;
import com.prateek.army.Service.ComplaintRecordsSeviceImpl;
import com.prateek.army.model.Complaintrecords;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/complaintrecords")
public class ComplaintRecordsEndpoint {


    private ComplaintRecordsSevice complaintRecordsSevice = new ComplaintRecordsSeviceImpl();

    @GET
    @Path("/complaintId")
    @Produces(APPLICATION_JSON)
    public Response getComplaintIDs() {
        List<Integer> complaintId = complaintRecordsSevice.getComplaintId();
        if (complaintId.size() != 0) {
            return Response.ok().entity(complaintId).build();
        } else return Response.noContent().build();
    }

    @GET
    @Path("/summary")
    @Produces(APPLICATION_JSON)
    public Response getComplaintSummary() {

        List<String> complainSummary = complaintRecordsSevice.getSummary();
        if (complainSummary.size() != 0) {
            return Response.ok().entity(complainSummary).build();
        } else return Response.noContent().build();
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response addNewComplaint(Complaintrecords complaintrecords) {
        return Response.ok().entity(complaintRecordsSevice.addComplaint(complaintrecords)).build();
    }

}
