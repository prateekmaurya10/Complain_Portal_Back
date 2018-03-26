package com.prateek.army.rest;

import com.prateek.army.Service.LoginService;
import com.prateek.army.Service.LoginServiceImpl;
import com.prateek.army.Service.OwnersService;
import com.prateek.army.Service.OwnersServiceImpl;
import com.prateek.army.model.Login;
import com.prateek.army.model.Owners;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/login")
public class LoginEndpoint {

    private LoginService loginService = new LoginServiceImpl();

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response loginVerification(LoginForm loginForm) {
        Login loginObj = loginService.retrieveLoginObj(loginForm.getEmailAddress(),loginForm.getPassword());
        OwnersService ownersService = new OwnersServiceImpl();
        Owners owner;
        if (loginObj != null) {
            owner = ownersService.findOwnerById(loginObj.getOwnerId());
            return Response.ok().entity(owner).build();
        } else return Response.status(Response.Status.UNAUTHORIZED).entity(new String("Invalid Email ID or Password.")).build();
    }
}

class LoginForm {
    private String emailAddress;
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String username) {
        this.emailAddress = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
