package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping
    public String displayAddUserForm(){
        return "/user/add";
    }
    @PostMapping
    public String ProcessAddUserForm(Model model, String verify, @ModelAttribute User user){
        if(user.getPassword().equals(verify)){
            model.addAttribute("username",user.getUsername());
            return "/user/index";
        }
        model.addAttribute("error","Password should match verify");
        return "redirect:";
    }
}
