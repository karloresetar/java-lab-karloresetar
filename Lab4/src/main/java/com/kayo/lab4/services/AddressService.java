package com.kayo.lab4.services;


import com.kayo.lab4.models.Address;
import com.kayo.lab4.models.Device;
import com.kayo.lab4.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
