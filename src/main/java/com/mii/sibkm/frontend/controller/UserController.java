/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.User;
import com.mii.sibkm.frontend.model.User;
import com.mii.sibkm.frontend.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author khali
 */

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

        private UserService userService;
    
//    @GetMapping
//    public String index(Model model) {
//        model.addAttribute("users", userService.getAll());
//        return "profile/profile-detail";
//    }

    @GetMapping("/create")
    public String createView(User user) {
        return "profile/create-profile";
    }
    
    @PostMapping
    public String create(User user){
        userService.create(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/user";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, User user, Model model){
        model.addAttribute("users", userService.getById(id));
        return "profile/update-profile";
    }
    
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, User user){
        userService.update(id, user);
        return "redirect:/login?logout=true";
    }
    
    // @GetMapping("/info/{id}")
    // public String info(@PathVariable Long id, Model model){
    //     model.addAttribute("users", userService.getById(id));
    //     return "profile/profile-detail";
    // }

    @GetMapping("/detail")
    public String info( @CurrentSecurityContext(expression="authentication?.name") String username, Model model){
        model.addAttribute("users", userService.getByUsername(username));
        return "profile/profile-detail";
    }
}
