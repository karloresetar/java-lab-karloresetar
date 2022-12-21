package Lab5.src.main.java.com.kayo.lab5.services;


import com.kayo.lab5.models.Measure;
import Lab5.src.main.java.com.kayo.lab5.repositories.MeasureRepository;
import Lab5.src.main.java.com.kayo.lab5.utilities.Checker;
import Lab5.src.main.java.com.kayo.lab5.utilities.DateHelper;
import Lab5.src.main.java.com.kayo.lab5.utilities.MeasureResponser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasureService {

    private final MeasureRepository measureRepository;
   /* @Autowired
    public MeasureService(MeasureRepository m) {
        measureRepository=m;
    }*/
    public List<Measure> findAllMeasures(){
        return measureRepository.getAll();
    }
    public Measure getById(Long id) {
        return measureRepository.getById(id);
    }
    public void deleteMeasure(Long id) {
        measureRepository.deleteById(id);
    }
    public void addMeasure(Measure m) {
        measureRepository.add(m);
    }

    public boolean findMeasureByDate(DateHelper date){
        return measureRepository.findByDate(date);
    }

    public int getConsumptionByYear(int year){
        return measureRepository.getConsumptionByYear(year);
    }

    public List<Measure> getAllMeasuresByYear(int year) {
        return measureRepository.getAllByYear(year);
    }

    public Measure getMeasureByMonthAndYear(int month, int year){
        return measureRepository.getByYearUndMonth(month,year);
    }


    public MeasureResponser getConsumption(String year, String month) {
        int yr;

        if (Checker.isNumeric(year) && Integer.parseInt(year) > 0) {
            yr = Integer.parseInt(year);
        } else {
            return new MeasureResponser(0, "Invalid input", null);
        }

        if (month == null) {
            return new MeasureResponser(this.getConsumptionByYear(yr), "Consumption for " + yr + " year", null);
        } else if (month.equals("all")) {
            List<Measure> measureList = this.getAllMeasuresByYear(yr);
            if (measureList == null) {
                return new MeasureResponser(0, "No recordinks found for " + yr + " year", null);
            } else {
                return new MeasureResponser(0, "All measures for " + yr + " year", measureList);
            }
        } else if (Checker.isNumeric(month) && Integer.parseInt(month) > 0 && Integer.parseInt(month) <= 12) {
            var measure = this.getMeasureByMonthAndYear(Integer.parseInt(month), yr);
            List<Measure> measureList = new ArrayList<>();
            measureList.add(measure);

            String[] months = {"january", "february", "march", "april","may","june","july",
                    "august","september","october","november","december"};
            int monthIndex = Integer.parseInt(month);
            var monthOutput = months[monthIndex - 1];

            if (measure == null) {
                return new MeasureResponser(0, "No recordinks for " + yr + " year and month " + monthOutput, measureList);
            } else {
                return new MeasureResponser(0, "Recordinks for " + yr + " year and month " + monthOutput, measureList);
            }
        } else {
            return new MeasureResponser(0, "Invalid input", null);
        }
    }


}
