package Lab5.src.main.java.com.kayo.lab5.services;

import com.kayo.lab5.models.Device;
import Lab5.src.main.java.com.kayo.lab5.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository r) {
        deviceRepository=r;
    }
    public List<Device> findAllDevices(){
        return deviceRepository.getAll();
    }
    public Device getById(Long id) {
        return deviceRepository.getById(id);
    }
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
    public void addDevice(Device d) {
        deviceRepository.add(d);
    }
}
