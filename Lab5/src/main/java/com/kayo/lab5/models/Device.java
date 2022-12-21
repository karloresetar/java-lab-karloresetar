package Lab5.src.main.java.com.kayo.lab5.models;

import java.util.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device{
    private Long id;
    private Set<Measure> measures;
}