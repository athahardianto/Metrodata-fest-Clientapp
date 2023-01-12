/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.Orders;
import com.mii.sibkm.frontend.model.Payments;
import com.mii.sibkm.frontend.model.dto.PaymentsRequest;
import com.mii.sibkm.frontend.service.OrdersService;
import com.mii.sibkm.frontend.service.PaymentsService;
import com.mii.sibkm.frontend.service.TicketsService;
import lombok.AllArgsConstructor;

import java.io.IOException;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author khali
 */

@Controller
@AllArgsConstructor
@RequestMapping("/payments")
public class PaymentsController {
    private TicketsService ticketsService;
    private PaymentsService paymentsService;

    @GetMapping
    public String index(@CurrentSecurityContext(expression="authentication?.name") String username, Model model) {                                  //user and admin    //melihat semua jenis pembayaran
        System.out.println("NAMA" + username);
        model.addAttribute("paymentss", paymentsService.getByUsername(username));
        return "payments/index";
    }
    
        @GetMapping("/detail")
    public String detail( @CurrentSecurityContext(expression="authentication?.name") String username, Model model) {                                  //user and admin    //melihat semua jenis pembayaran
        System.out.println("NAMA" + username);
        model.addAttribute("paymentss", paymentsService.getByUsername(username));
        return "payments/payments-detail";
    }

    @GetMapping("/create")                                              //buat metode pembayaran baru //admin only
    public String createView(PaymentsRequest paymentsRequest, Model model,
    @CurrentSecurityContext(expression="authentication?.name") String username){
        model.addAttribute("tickets", ticketsService.getAll());
        model.addAttribute("usernames", username);
        return "orders/create-order";
    }
    
    @PostMapping                                                        //buat
    public String create(PaymentsRequest paymentsRequest){
        paymentsService.create(paymentsRequest);
        return "redirect:/payments";
    }

    @DeleteMapping("/{id}")                                             //hapus jenis pembayaran //admiin
    public String delete(@PathVariable Long id){
        paymentsService.delete(id);
        return "redirect:/payments";
    }
    
    @GetMapping("/update/{id}")                                         //update jenis pembayaran
    public String updateForm(Payments payments){
        return "payments/update-payments";
    }
    
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, Payments payments){
        paymentsService.update(id, payments);
        return "redirect:/payments";
    }

    @PutMapping("/update/upload/{id}")
    public String updateUser(@PathVariable Long id, MultipartFile file) throws IOException{
        paymentsService.updateUser(id, file);
        return "redirect:/payments/detail";
    }
    
    @GetMapping("/info/{id}")                                       //detail cara bayar
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("paymentss", paymentsService.getById(id));
        return "payments/payments-detail";
    }
}