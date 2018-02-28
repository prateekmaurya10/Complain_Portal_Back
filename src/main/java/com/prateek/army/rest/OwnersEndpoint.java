package com.prateek.army.rest;

import com.prateek.army.Repository.OwnersRepository;
import com.prateek.army.model.Owners;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/owners")
public class OwnersEndpoint {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON )
    public Response getOwners() {
        List<Owners> owners = ownersRepository.findAll();
        if(owners.size() != 0) {
            return Response.ok().entity(owners).build();
        }
        else return Response.noContent().build();
    }

    @GET
    @Path("/count")
    public Response countOwners() {
        Long noOfOwners = ownersRepository.countAll();
        if (noOfOwners == 0)
            return Response.noContent().build();
        return Response.ok(noOfOwners).build();
    }

    public Owners getOwner(Integer id) {
        return ownersRepository.find(id);
    }

    public Owners createOwner(Owners owner) {
        return ownersRepository.create(owner);
    }

    public void deleteOwner(Integer id) {
        ownersRepository.delete(id);
    }

    private OwnersRepository ownersRepository = new OwnersRepository();
}
