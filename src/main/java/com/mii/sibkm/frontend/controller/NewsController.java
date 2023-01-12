/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.News;
import com.mii.sibkm.frontend.service.NewsService;
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
@RequestMapping("/news")
public class NewsController {
    
    private NewsService newsService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("newss", newsService.getAll());
        return "news/index";
    }

    @GetMapping("/create")
    public String createView(News news) {
        return "news/create-news";
    }
    
    @PostMapping
    public String create(News news){
        newsService.create(news);
        return "redirect:/news";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        newsService.delete(id);
        return "redirect:/news";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(News news){
        return "news/update-news";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, News news){
        newsService.update(id, news);
        return "redirect:/news";
    }
    
    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("newss", newsService.getById(id));
        return "news/news-detail";
    }
}
