package com.learn.postgresql;

import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public void createAddress(AddressEntity entity){
        addressRepo.save(entity);
    }

}
