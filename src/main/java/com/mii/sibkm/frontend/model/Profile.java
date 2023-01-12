package com.mii.sibkm.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    
    private Long id;
    private String fullname;
    private int phone;
    private User user;
}
