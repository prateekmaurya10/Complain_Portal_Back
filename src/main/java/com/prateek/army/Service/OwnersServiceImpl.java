package com.prateek.army.Service;

import com.prateek.army.Repository.OwnersRepository;
import com.prateek.army.model.Owners;

import java.util.List;

public class OwnersServiceImpl implements OwnersService {

    private OwnersRepository ownersRepository = new OwnersRepository();

    @Override
    public void addOwner(Owners owner) {
        ownersRepository.create(owner);
    }

    @Override
    public List<Owners> findOwners() {
        return ownersRepository.findAll();
    }

    // Retrieve Owner Id.
    public int getOwnerId(Owners owner){
        List<Owners> allOwners = ownersRepository.findAll();
        int ownerId = 0;
        for(Owners owner1 : allOwners){
            if(owner1 == owner)
                ownerId = owner1.getId();
        }
        return ownerId;
    }

    @Override
    public Owners findOwnerById(int id) {
        return ownersRepository.find(id);
    }
}
