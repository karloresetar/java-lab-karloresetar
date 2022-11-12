package com.kayo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.eclipse.paho.client.mqttv3.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @JsonIgnore
    private MqttClient publisher;
    private String topic;
    private String broker;
    private List<Sensor> sensors;
    private String path;

    public Device(String p){
        this.path = p;
    }

    Device(String s1, String s2) {
        broker = s1;
        topic = s2;
    }

    public Device(String topic,String broker,MqttClient p,List<Sensor> s){
        this.topic = topic;
        this.broker = broker;
        this.publisher = p;
        this.sensors = s;
    }

    public Device cfgFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(path),Device.class);
    }

    public void runDevice()  {
        try {
            publisher = new MqttClient(broker, topic);
        } catch(MqttException e) {
            e.printStackTrace();
        }

        MqttConnectOptions con = new MqttConnectOptions();
        con.setCleanSession(true);

        try {
            publisher.connect(con);
            for(Sensor sensor : sensors){
                sensor.generateRandomValue();
                String message=sensor.getSensorData();
                MqttMessage messageBytes = new MqttMessage(message.getBytes());
                publisher.publish(topic, messageBytes);

            }
            publisher.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
