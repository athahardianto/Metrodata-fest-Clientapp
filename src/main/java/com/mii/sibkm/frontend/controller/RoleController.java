/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.controller;

import com.mii.sibkm.frontend.model.Role;
import com.mii.sibkm.frontend.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {               //admin only
    private RoleService roleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", roleService.getAll());
        return "role/index";
    }

    @GetMapping("/create")
    public String createView(Role role) {
        return "role/create-role";
    }
    
    @PostMapping
    public String create(Role role){
        roleService.create(role);
        return "redirect:/role";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        roleService.delete(id);
        return "redirect:/role";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(Role role){
        return "role/update-role";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Role role){
        roleService.update(id, role);
        return "redirect:/role";
    }
    
    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model){
        model.addAttribute("roles", roleService.getById(id));
        return "role/role-detail";
    }
}
