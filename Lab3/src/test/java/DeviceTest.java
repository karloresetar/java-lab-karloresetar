import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kayo.Device;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeviceTest {
    @Test
    public void deviceTest() {
        Device leSensor =new Device("src/main/resources/package.json");
        try {
            leSensor=leSensor.cfgFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(leSensor);
        assertNotNull(leSensor.getSensors());
        assertNotNull(leSensor.getBroker());
        assertNotNull(leSensor.getTopic());
    }
}
