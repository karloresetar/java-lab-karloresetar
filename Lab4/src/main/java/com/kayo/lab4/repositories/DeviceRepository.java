package com.kayo.lab4.repositories;

import com.kayo.lab4.models.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class DeviceRepository {
    private List<Device> deviceList=new ArrayList<>();

    public List<Device> getAll() {
        return deviceList;
    }

    public Device getById(Long id) {
        Device device = new Device();
        for (Device dev : deviceList) {
            if (Objects.equals(dev.getId(), id)) {
                device=dev;
                break;
            }
        }
        return device;
    }

    public void add(Device device) {
        deviceList.add(device);
    }

    public void deleteById(Long id) {
        for (Device dev : deviceList) {
            if (Objects.equals(dev.getId(), id)) {
                deviceList.remove(dev);
            }
        }
    }
}
