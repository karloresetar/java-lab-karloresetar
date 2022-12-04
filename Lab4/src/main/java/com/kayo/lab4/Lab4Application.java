package com.kayo.lab4;

import com.kayo.lab4.models.Measure;
import com.kayo.lab4.repositories.MeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.kayo.lab4"})
public class Lab4Application implements CommandLineRunner {

    private final MeasureRepository measureRepository;

    public Lab4Application(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        var random=new Random();
        Measure measure = new Measure(random.nextLong(),15, "Celsius", 1L);
        measureRepository.add(measure);
    }
}
