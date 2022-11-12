package com.kayo;

import lombok.*;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    private double rasp1;
    private double rasp2;
    private double value;
    private int factor;
    private String unit;
    private String name;

    public Sensor(double rasp1, double rasp2, int factor, String unit, String name)
    {
        this.rasp1 = rasp1;
        this.rasp2 = rasp2;
        this.factor = factor;
        this.unit = unit;
        this.name = name;
    }

    public void generateRandomValue(){
        Random rndValue = new Random();
        this.value = rndValue.nextInt((int)(rasp2-rasp1) + (int)rasp1);
    }

    public String getSensorData(){
        return "Name: "+name+" value: "+value+" factor: "+factor+" unit: "+unit;
    }


}
