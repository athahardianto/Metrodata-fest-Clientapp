package com.mii.sibkm.frontend.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.sibkm.frontend.model.Profile;
import com.mii.sibkm.frontend.model.User;
import com.mii.sibkm.frontend.service.ProfileService;
import com.mii.sibkm.frontend.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
    
    private ProfileService profileService;
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("profiles", profileService.getAll());
        return "profile/profile-detail";
    }

    @GetMapping("/create")
    public String createView(Profile profile) {
        return "profile/create-profile";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Profile profile, Model model){
        model.addAttribute("profile", profileService.getById(id));
        return "profile/update-profile";
    }
    
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, Profile profile){
        User user = new User();
        user = userService.getById(id);
        profile.setUser(user);
        profileService.update(id, profile);
        return "redirect:/profiles/detail";
    }

    @GetMapping("/detail")
    public String info( @CurrentSecurityContext(expression="authentication?.name") String username, Model model){
        model.addAttribute("profiles", profileService.getByUsername(username));
        return "profile/profile-detail";
    }
}
