package com.kayo.lab6.repositories;

import com.kayo.lab6.models.Measure;
import com.kayo.lab6.utilities.DateHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MeasureRepository implements PrimaryRepository<Measure>{
    private List<Measure> measures;

    public MeasureRepository() {
        measures=new ArrayList<>();
    }


    public List<Measure> getAll(){
        return measures;
    }

    public Measure getById(Long id){
        return measures.stream().filter(measure -> measure.getMeasureId().equals(id)).findFirst().get();
    }

    public void add(Measure measure) {
        measures.add(measure);
    }

    public void deleteById(Long id) {
        measures = measures.stream().
                filter(measure -> !Objects.equals(measure.getMeasureId(), id)).collect(Collectors.toList());
    }

    public boolean findByDate(DateHelper dateHelper){
        return measures.stream().anyMatch(measure -> measure.getDateHelper().equals(dateHelper));
    }

    public int getConsumptionByYear(int year){
        return measures.stream()
                .filter(measure -> measure.getDateHelper().getYear() == year)
                .mapToInt(measure -> measure.getValue()).sum();
    }
    public List<Measure> getAllByYear(int year){
        return measures.stream()
                .filter(measure -> measure.getDateHelper().getYear() == year)
                .collect(Collectors.toList());
    }

    public Measure getByYearUndMonth(int month, int year){
        return measures.stream()
                .filter(measure -> measure.getDateHelper().getYear() == year && measure.getDateHelper().getMonth() == month)
                .findAny().orElse(null);
    }

}
