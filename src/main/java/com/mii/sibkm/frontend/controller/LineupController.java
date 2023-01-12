/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.Lineup;
import com.mii.sibkm.frontend.service.LineupService;
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
@RequestMapping("/lineup")
public class LineupController {
    
    private LineupService lineupService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("lineups", lineupService.getAll());
        return "lineup/index";
    }

    @GetMapping("/create")
    public String createView(Lineup lineup) {
        return "lineup/create-lineup";
    }
    
    @PostMapping
    public String create(Lineup lineup){
        lineupService.create(lineup);
        return "redirect:/lineup";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        lineupService.delete(id);
        return "redirect:/lineup";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(Lineup lineup){
        return "lineup/update-lineup";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Lineup lineup){
        lineupService.update(id, lineup);
        return "redirect:/lineup";
    }
    
    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("lineups", lineupService.getById(id));
        return "lineup/lineup-detail";
    }
}
