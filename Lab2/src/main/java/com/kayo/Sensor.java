package com.kayo;


import lombok.*;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
    private double value;
    private int factor;
    private String unit;
    private String name;

    public Sensor(double rasp1, double rasp2, int factor, String unit, String name){
        Random rnd = new Random();
        this.value=rnd.nextInt((int) (rasp2-rasp1)) + (int) rasp1;
        this.factor=factor;
        this.unit=unit;
        this.name = name;
    }
    public String getSensorData(){
        return "Device: "+name+" value: "+value+" factor: "+factor+" unit: "+unit;
    }
}
