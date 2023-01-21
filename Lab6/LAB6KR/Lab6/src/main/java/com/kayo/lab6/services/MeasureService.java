package com.kayo.lab6.services;


import com.kayo.lab6.models.Measure;
import com.kayo.lab6.repositories.MeasureRepository;
import com.kayo.lab6.utilities.Checker;
import com.kayo.lab6.utilities.DateHelper;
import com.kayo.lab6.utilities.MeasureResponser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasureService {

    private final MeasureRepository measureRepository;

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

    public Page<Measure> getMeasures(Pageable pageable) {
        List<Measure> measures = measureRepository.getAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Measure> list;

        if (measures.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, measures.size());
            list = measures.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, pageable, measures.size());
    }




}
