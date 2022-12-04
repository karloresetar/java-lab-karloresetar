package com.kayo.lab4.controllers;

import com.kayo.lab4.models.Device;
import com.kayo.lab4.services.DeviceService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity<List<Device>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(deviceService.findAllDevices());
    }

    @GetMapping("{id}")
    public Device findDeviceById(@PathVariable Long id) {
        return deviceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addDevice(@RequestBody Device d) {
        if(d==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Device is null");
        }
        deviceService.addDevice(d);
        return ResponseEntity.status(HttpStatus.OK).body("Device is added");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteDevice(@PathVariable Long id){
        deviceService.deleteDevice(id);
        return ResponseEntity.status(HttpStatus.OK).body("Device deleted");
    }
}
