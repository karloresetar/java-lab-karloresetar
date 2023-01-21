package com.kayo.lab6frontend.models;

import com.kayo.lab6frontend.utilities.DateHelper;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measure {
    private Long measureId;
    private int value;
    private String unit;
    private Long device_id;
    DateHelper dateHelper;
}
