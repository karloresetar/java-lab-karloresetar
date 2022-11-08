package com.kayo;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {
    public static void main(String[] args) throws MqttException {
        Sensor sensor1=new Sensor(-3266.8,3266.8,10,"C","Temp Vode");
        Sensor sensor2=new Sensor(0,65.36,1000,"Bar","Tlak vode");
        Device dev=new Device("vjezba","tcp://localhost:1883");
        dev.addSensor(sensor1);
        dev.addSensor(sensor2);
        dev.runDevice();
        System.out.println("Hello world!");
    }
}