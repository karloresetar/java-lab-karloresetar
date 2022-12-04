package com.kayo.lab4.controllers;

import com.kayo.lab4.models.Address;
import com.kayo.lab4.models.Device;
import com.kayo.lab4.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAllAddress());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addAddress(@RequestBody Address address) {
        if(address==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address is null");
        }
        addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.OK).body("Address is added");
    }
}
