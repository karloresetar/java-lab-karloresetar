package com.kayo;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Device {
    private MqttClient client;
    private List<Sensor> sensors;
    private String topic;
    private String address;
    public Device(String topic, String address) throws MqttException {
        this.topic=topic;
        this.address=address;
        sensors=new ArrayList<>();
        client=new MqttClient(address,topic);
    }
    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }
    public void runDevice() throws MqttException {
        MqttConnectOptions con = new MqttConnectOptions();
        client.connect(con);
        int i=0;
        while(i < 5){
            for(Sensor sensor :sensors){
                String message=sensor.getSensorData();
                MqttMessage messageBytes = new MqttMessage(message.getBytes());
                client.publish(topic, messageBytes);
            }
            i++;
        }
        client.disconnect();
    }

}
