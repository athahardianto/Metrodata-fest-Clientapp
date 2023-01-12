/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.Tickets;
import com.mii.sibkm.frontend.service.TicketsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author khali
 */
@Controller
@AllArgsConstructor
public class TicketsController {
        private TicketsService ticketsService;

    @GetMapping("/tickets")
    public String index(Model model) {              //tampilan tiket yang available     //user&admin
        model.addAttribute("ticketss", ticketsService.getAll());
        return "tickets/index";
    }
    
    @GetMapping("tickets/createOrder")                          //membuat tiker     //admin
    public String createView(Tickets tickets) {
        return "tickets/create-ticket";
    }
    
    @PostMapping                                    //buat tiket  //admin
    public String create(Tickets tickets){
        ticketsService.create(tickets);
        return "redirect:/tickets";
    }
    
    @DeleteMapping("/{id}")                         //hapus tiket //admin only
    public String delete(@PathVariable Long id){
        ticketsService.delete(id);
        return "redirect:/tickets";
    }
    
    @GetMapping("/update/{id}")                     //update tiket //admin only
    public String updateForm(Tickets tickets){
        return "tickets/update-ticket";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Tickets tickets){   //selesai update tiket //admin only
        ticketsService.update(id, tickets);
        return "redirect:/tickets";
    }
    
    @GetMapping("/info/{id}")                                       //akses tiket by id
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("ticketss", ticketsService.getById(id));
        return "tickets/tickets-detail";
    }
}
