
import com.kayo.Device;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MqttTest {
    @Test
    public void mqttTest(){
        Device leSensor = new Device("src/main/resources/package.json");
        try{
            leSensor=leSensor.cfgFile();
            MqttClient client = new MqttClient(leSensor.getBroker(),leSensor.getTopic());
            client.connect();
            assertTrue(client.isConnected());
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
