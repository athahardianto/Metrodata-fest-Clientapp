/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.model;

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
public class TicketStock {
    private Long id;
    private int stock;
    private int isAvailable;
}
