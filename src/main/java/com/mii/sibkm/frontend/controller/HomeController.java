/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.service.FaqsService;
import com.mii.sibkm.frontend.service.LineupService;
import com.mii.sibkm.frontend.service.NewsService;
import com.mii.sibkm.frontend.service.TicketsService;
import com.mii.sibkm.frontend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author khali
 */
@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {
    private TicketsService ticketsService;
    private LineupService lineupService;
    private NewsService newsService;
    private FaqsService faqsService;
    private UserService userService;
    
    @GetMapping
    public String home(@CurrentSecurityContext(expression="authentication?.name") String username, Model model){
//        model.addAttribute("nama", "Johan");
        System.out.println(username);
        model.addAttribute("ticketss", ticketsService.getAll());
        model.addAttribute("lineups", lineupService.getAll());
        model.addAttribute("newss", newsService.getAll());
        model.addAttribute("faqss", faqsService.getAll());
        return "home-user";
    }
}
