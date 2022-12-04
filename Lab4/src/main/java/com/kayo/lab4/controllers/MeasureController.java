package com.kayo.lab4.controllers;


import com.kayo.lab4.models.Measure;
import com.kayo.lab4.services.MeasureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/measures")
public class MeasureController {
    private final MeasureService measureService;

    public MeasureController(MeasureService measureService) {
        this.measureService = measureService;
    }

    @GetMapping
    public ResponseEntity<List<Measure>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(measureService.findAllMeasures());
    }

    @GetMapping("{id}")
    public Measure findMeasureById(@PathVariable Long id) {
        return measureService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addMeasure(@RequestBody Measure m) {
        if(m==null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Measure is null");
        }
        measureService.addMeasure(m);
        return ResponseEntity.status(HttpStatus.OK).body("Measure added successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteMeasure(@PathVariable Long id){
        measureService.deleteMeasure(id);
        return ResponseEntity.status(HttpStatus.OK).body("Measure deleted");
    }
}
