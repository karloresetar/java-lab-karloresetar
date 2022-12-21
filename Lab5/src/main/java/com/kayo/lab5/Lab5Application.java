package Lab5.src.main.java.com.kayo.lab5;

import com.kayo.lab5.models.Measure;
import com.kayo.lab5.repositories.MeasureRepository;
import com.kayo.lab5.utilities.DateHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.kayo.lab5"})
public class Lab5Application implements CommandLineRunner {

    public Lab5Application(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }

    private final MeasureRepository measureRepository;

    @Override
    public void run(String... args) {
        var rand=new Random();
        var dateJanuary=new DateHelper(1,1,2020);
        var dateFebruary=new DateHelper(1,2,2020);
        var dateMarch=new DateHelper(1,3,2020);
        var measure1=new Measure(rand.nextLong(),15,"C",new Random().nextLong(),dateJanuary);
        var measure2=new Measure(rand.nextLong(),15,"C",new Random().nextLong(),dateFebruary);
        var measure3=new Measure(rand.nextLong(),15,"C",new Random().nextLong(),dateMarch);
        measureRepository.add(measure1);
        measureRepository.add(measure2);
        measureRepository.add(measure3);

    }
}
