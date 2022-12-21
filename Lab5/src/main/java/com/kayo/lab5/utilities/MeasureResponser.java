package Lab5.src.main.java.com.kayo.lab5.utilities;

import com.kayo.lab5.models.Measure;
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
