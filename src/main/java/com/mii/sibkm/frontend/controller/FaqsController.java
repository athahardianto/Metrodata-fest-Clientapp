/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.Faqs;
import com.mii.sibkm.frontend.service.FaqsService;
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
@RequestMapping("/faqs")
public class FaqsController {
    private FaqsService faqsService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("faqss", faqsService.getAll());
        return "faqs/index";
    }

    @GetMapping("/create")
    public String createView(Faqs faqs) {
        return "faqs/create-faqs";
    }
    
    @PostMapping
    public String create(Faqs faqs){
        faqsService.create(faqs);
        return "redirect:/faqs";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        faqsService.delete(id);
        return "redirect:/faqs";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(Faqs faqs){
        return "faqs/update-faqs";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Faqs faqs){
        faqsService.update(id, faqs);
        return "redirect:/faqs";
    }
    
    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("faqss", faqsService.getById(id));
        return "faqs/faqs-detail";
    }
    
    @GetMapping("/search/{question}")
    public String search(@PathVariable String question, Model model){
        model.addAttribute("faqss", faqsService.searchByKeyword(question));
        return "faqs/search";
    }
}
