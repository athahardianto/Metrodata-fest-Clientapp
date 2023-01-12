/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.Orders;
import com.mii.sibkm.frontend.service.OrdersService;
import com.mii.sibkm.frontend.service.PaymentsService;
import com.mii.sibkm.frontend.service.TicketsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author khali
 */

@Controller
@AllArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private OrdersService ordersService;
    private TicketsService ticketsService;
    private PaymentsService paymentsService;

    @GetMapping
    public String index(Model model) {                          //admin only
        model.addAttribute("orderss", ordersService.getAll());
        model.addAttribute("paymentss", paymentsService.getAll());
        return "orders/index";
    }

//    @GetMapping("/create")                                      //buat pesanan  //user & admin
//    public String createView(Orders orders, Model model) {
//        model.addAttribute("ticketss", ticketsService.getAll());
//        model.addAttribute("paymentss", paymentsService.getAll());
//        return "orders/create-order";
//    }
    
    @PostMapping
    public String create(Orders orders){
        ordersService.create(orders);
        return "redirect:/orders";
    }
    
    @GetMapping("/myOrder/{id}")
    public String myOrder(@PathVariable Long id, Model model){
        model.addAttribute("orderss", ordersService.getById(id));
        model.addAttribute("paymentss", paymentsService.getById(id));
        return "orders/my-order";
    }  

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        ordersService.delete(id);
        return "redirect:/orders";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(Orders orders){
        return "orders/update-order";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Orders orders){
        ordersService.update(id, orders);
        return "redirect:/orders";
    }
    
    @GetMapping("/info/{id}")                                       //user&admin
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("orderss", ordersService.getById(id));
        return "orders/orders-detail";
    }    
}
