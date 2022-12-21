package Lab5.src.main.java.com.kayo.lab5.models;

import Lab5.src.main.java.com.kayo.lab5.utilities.DateHelper;
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
