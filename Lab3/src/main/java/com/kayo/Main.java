package com.kayo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Device leSensor =new Device("Lab3/src/main/resources/package.json");
        try {
            leSensor=leSensor.cfgFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        leSensor.runDevice();
    }
}