package com.kayo.lab6.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private Long userId;
    private Long deviceId;
    private Address address;
}
