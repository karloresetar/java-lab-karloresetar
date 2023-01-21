package com.kayo.lab6.utilities;

import com.kayo.lab6.models.Measure;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MeasureResponser {
    private int consumption;
    private String description;
    private List<Measure> measures;
}
