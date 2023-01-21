package com.kayo.lab6.services;


import com.kayo.lab6.models.Address;
import com.kayo.lab6.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAllAddress(){
        return addressRepository.getAll();
    }
    public void addAddress(Address address) {
        addressRepository.add(address);
    }
}
