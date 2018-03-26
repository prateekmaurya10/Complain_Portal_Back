package com.prateek.army.rest;

import com.prateek.army.Service.SignUpService;
import com.prateek.army.Service.SignUpServiceImpl;
import com.prateek.army.Utility.LoginUtility;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/signup")
public class SignUpEndpoint {

    SignUpService signUpService = new SignUpServiceImpl();

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response signUp(LoginUtility loginUtility) {
        return Response.ok().entity(signUpService.loginInsert(loginUtility)).build();
    }
}
