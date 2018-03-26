package com.prateek.army.Service;

import com.prateek.army.model.Owners;

import java.util.List;

public interface OwnersService {

    void addOwner(Owners owner);

    List<Owners> findOwners();

    int getOwnerId(Owners owner);

    Owners findOwnerById(int id);
}
