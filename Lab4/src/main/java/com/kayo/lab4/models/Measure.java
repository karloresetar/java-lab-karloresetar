package com.kayo.lab4.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measure {
    private Long measureId;
    private int value;
    private String unit;
    private Long device_id;
}
