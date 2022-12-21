package Lab5.src.main.java.com.kayo.lab5.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private Long userId;
    private Long deviceId;
    private Address address;
}
