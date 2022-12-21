package Lab5.src.main.java.com.kayo.lab5.repositories;

import com.kayo.lab5.models.Address;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressRepository {
    private final List<Address> addressList=new ArrayList<>();

    public List<Address> getAll() {
        return addressList;
    }

    public void add(Address address) {
        addressList.add(address);
    }
    
}
