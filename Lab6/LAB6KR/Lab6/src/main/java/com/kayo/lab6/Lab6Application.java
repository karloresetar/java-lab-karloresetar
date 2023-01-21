package com.kayo.lab6;

import com.kayo.lab6.models.Measure;
import com.kayo.lab6.repositories.MeasureRepository;
import com.kayo.lab6.utilities.DateHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.kayo.lab6"})
public class Lab6Application implements CommandLineRunner {

    public Lab6Application(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }

    private final MeasureRepository measureRepository;

    @Override
    public void run(String... args) {
        var rand=new Random();
        var dateJanuary=new DateHelper(1,1,2020);
        var dateFebruary=new DateHelper(1,2,2020);
        var dateMarch=new DateHelper(1,3,2020);
        var dateApril=new DateHelper(1,4,2020);
        var dateMay=new DateHelper(1,5,2020);
        var dateJune=new DateHelper(1,6,2020);
        var dateJuly=new DateHelper(1,7,2020);
        var dateAugust=new DateHelper(1,8,2020);
        var dateSeptember=new DateHelper(1,9,2020);
        var measure1=new Measure(rand.nextLong(),15,"C",new Random().nextLong(),dateJanuary);
        var measure2=new Measure(rand.nextLong(),20,"C",new Random().nextLong(),dateFebruary);
        var measure3=new Measure(rand.nextLong(),13,"C",new Random().nextLong(),dateMarch);
        var measure4=new Measure(rand.nextLong(),11,"C",new Random().nextLong(),dateApril);
        var measure5=new Measure(rand.nextLong(),22,"C",new Random().nextLong(),dateMay);
        var measure6=new Measure(rand.nextLong(),45,"C",new Random().nextLong(),dateJune);
        var measure7=new Measure(rand.nextLong(),50,"C",new Random().nextLong(),dateJuly);
        var measure8=new Measure(rand.nextLong(),23,"C",new Random().nextLong(),dateAugust);
        var measure9=new Measure(rand.nextLong(),80,"C",new Random().nextLong(),dateSeptember);
        measureRepository.add(measure1);
        measureRepository.add(measure2);
        measureRepository.add(measure3);
        measureRepository.add(measure4);
        measureRepository.add(measure5);
        measureRepository.add(measure6);
        measureRepository.add(measure7);
        measureRepository.add(measure8);
        measureRepository.add(measure9);

    }
}
