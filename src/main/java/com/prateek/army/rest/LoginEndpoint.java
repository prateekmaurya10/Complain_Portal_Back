package com.prateek.army.rest;

import com.prateek.army.Service.LoginService;
import com.prateek.army.Service.LoginServiceImpl;
import com.prateek.army.Service.OwnersService;
import com.prateek.army.Service.OwnersServiceImpl;
import com.prateek.army.model.Login;
import com.prateek.army.model.Owners;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/login")
public class LoginEndpoint {

    private LoginService loginService = new LoginServiceImpl();

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public Response loginVerification(String emailAddress, String password) {
        Login loginObj = loginService.retrieveLoginObj(emailAddress,password);
        OwnersService ownersService = new OwnersServiceImpl();
        Owners owner;
        if (loginObj != null) {
            owner = ownersService.findOwnerById(loginObj.getOwnerId());
            return Response.ok().entity(owner).build();
        } else return Response.noContent().build();
    }
}
