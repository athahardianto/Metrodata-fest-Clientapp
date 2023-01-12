/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.TicketStock;
import com.mii.sibkm.frontend.service.TicketStockService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author khali
 */
@Controller
@AllArgsConstructor
@RequestMapping("/ticketstock")
public class TicketStockController {            //ADMIN ONLY
    private TicketStockService ticketstockService;

    @GetMapping
    public String index(Model model) {                                      //lihat semua stock tiket per kategori
        model.addAttribute("ticketstocks", ticketstockService.getAll());
        return "ticketstock/index";
    }

    @GetMapping("/create")                                                  //buat stock untuk kategori ticket
    public String createView(TicketStock ticketstock) {
        return "ticketstock/create-stock";
    }
    
    @PostMapping                                                            //abis buat stock, redirect
    public String create(TicketStock ticketstock){
        ticketstockService.create(ticketstock);
        return "redirect:/ticketstock";
    }

    @DeleteMapping("/{id}")                                                 //hapus stock buat kategori ticket
    public String delete(@PathVariable Long id){
        ticketstockService.delete(id);
        return "redirect:/ticketstock";
    }
    
    @GetMapping("/update/{id}")                                             //update stock buat kategori tiket
    public String updateForm(TicketStock ticketstock){
        return "ticketstock/update-stock";
    }
    
    @PostMapping("/update/{id}")                                            //setelah update, redirect
    public String update(@PathVariable Long id, TicketStock ticketstock){
        ticketstockService.update(id, ticketstock);
        return "redirect:/ticketstock";
    }
    
    @GetMapping("/info/{id}")                                               //info tiket
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("ticketstocks", ticketstockService.getById(id));
        return "ticketstock/ticketstock-detail";
    }
    
    
}
