package com.kayo.lab6frontend.utilities;

import com.kayo.lab6frontend.models.Measure;
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
