package Lab5.src.main.java.com.kayo.lab5.controllers;


import com.kayo.lab5.models.Measure;
import com.kayo.lab5.services.MeasureService;
import com.kayo.lab5.utilities.DateHelper;
import com.kayo.lab5.utilities.MeasureResponser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measures")
public class MeasureController {
    private final MeasureService measureService;

    public MeasureController(MeasureService measureService) {
        this.measureService = measureService;
    }

    @GetMapping("/listMeasures")
    public ResponseEntity<List<Measure>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(measureService.findAllMeasures());
    }

    @GetMapping("{id}")
    public Measure findMeasureById(@PathVariable Long id) {
        return measureService.getById(id);
    }

    @PostMapping("/addMeasure")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addMeasure(@RequestBody Measure m) {
        DateHelper date = m.getDateHelper();
        if(measureService.findMeasureByDate(date)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Measure with that date already exist");
        }
        else {
            measureService.addMeasure(m);
            return ResponseEntity.status(HttpStatus.OK).body("Measure added");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateMeasure(@PathVariable Long id, @RequestBody Measure m){
        Measure measure = measureService.getById(id);
        measure.setValue(m.getValue());
        return ResponseEntity.status(HttpStatus.OK).body("Measure updated");
    }

    @GetMapping("/consumption")
    public ResponseEntity<MeasureResponser> getConsumptionByYear(@RequestParam String year, @RequestParam(required = false) String month){
        var measureResponser = measureService.getConsumption(year,month);
        if(measureResponser.getDescription().equals("Invalid input")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(measureResponser);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(measureResponser);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteMeasure(@PathVariable Long id){
        measureService.deleteMeasure(id);
        return ResponseEntity.status(HttpStatus.OK).body("Measure deleted");
    }


}
