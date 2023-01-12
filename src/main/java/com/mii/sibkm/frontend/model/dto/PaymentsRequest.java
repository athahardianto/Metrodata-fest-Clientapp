package com.mii.sibkm.frontend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsRequest {
    
    private String method;
    
    private int quantity;
    
    private String orderDate;
    
    private String username;
    
    private Long idTicket;
}