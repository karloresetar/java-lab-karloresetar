package com.kayo.lab6frontend.models;

import java.util.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device{
    private Long id;
    private Set<Measure> measures;
}