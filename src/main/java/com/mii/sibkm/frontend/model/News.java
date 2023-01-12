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
public class News {
    private Long id;
    private String title;
    private String content;
    private Date createAt;
    private String image;
}
