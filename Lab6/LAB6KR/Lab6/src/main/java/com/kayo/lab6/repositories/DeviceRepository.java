package com.kayo.lab6.repositories;

import com.kayo.lab6.models.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class DeviceRepository implements PrimaryRepository<Device>{
    private List<Device> deviceList=new ArrayList<>();

    public List<Device> getAll() {
        return deviceList;
    }

    public Device getById(Long id) {
        return deviceList.stream().filter(device->device.getId().equals(id)).findFirst().get();
    }

    public void add(Device device) {
        deviceList.add(device);
    }

    public void deleteById(Long id) {
        deviceList = deviceList.stream().
                filter(device -> !Objects.equals(device.getId(), id)).collect(Collectors.toList());
    }
}
