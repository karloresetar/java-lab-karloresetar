package com.kayo.lab4.services;


import com.kayo.lab4.models.Measure;
import com.kayo.lab4.repositories.MeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
