/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author khali
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Long id;
    private int quantity;
    private Date orderDate;
    private Tickets ticket;
    private User users;
}
