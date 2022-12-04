package com.kayo.lab4.repositories;

import com.kayo.lab4.models.Measure;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MeasureRepository {
    private List<Measure> measures;
    public MeasureRepository() {
        measures=new ArrayList<>();
    }
    public List<Measure> getAll(){
        return measures;
    }
    public Measure getById(Long id){
        Measure measure=new Measure();
        for (Measure mes :measures) {
            if(Objects.equals(mes.getMeasureId(), id)) {
                measure=mes;
                break;
            }
        }
        return measure;
    }
    public void add(Measure measure) {
        measures.add(measure);
    }
    public void deleteById(Long id) {
        for (Measure measure : measures) {
            if (Objects.equals(measure.getDevice_id(), id)) {
                measures.remove(measure);
                break;
            }
        }
    }
}
