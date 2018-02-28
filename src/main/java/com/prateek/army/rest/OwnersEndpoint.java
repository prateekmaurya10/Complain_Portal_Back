package com.prateek.army.rest;

import com.prateek.army.Repository.OwnersRepository;
import com.prateek.army.model.Owners;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/Owners")
public class OwnersEndpoint {

    @GET
    @Produces(APPLICATION_JSON)
    public Response getOwners() {
        List<Owners> owners = ownersRepository.findAll();

        if(owners.size() == 0)
            return Response.noContent().build();
        return Response.ok(owners).build();
    }

    public Long countOwners() {
        return ownersRepository.countAll();
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

    @Inject
    private OwnersRepository ownersRepository;
}
