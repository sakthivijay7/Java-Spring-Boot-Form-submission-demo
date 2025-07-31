package com.springbootweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springbootweb.Model.User;
import com.springbootweb.Service.Userservice;

// add controller
@Controller
public class Maincontroller {

    @Autowired
    private Userservice userservice;
    // get the data if pass param to get

    @GetMapping("/")
    public String formhome(Model model) {
        try {
            model.addAttribute("user", new User());
            model.addAttribute("submitted", false);
            return "index";
        } catch (Exception e) {
            System.out.println("Error message in Get Method" + e.getMessage());
            return "Error" + e;
        }
    }

    // pass the data to url
    @PostMapping("/submit")
    public String adddata(@ModelAttribute User user, Model model) {
        try {
            User processuser = userservice.getuser(user);
            model.addAttribute("user", processuser);
            model.addAttribute("submitted", true);
            return "index";
        } catch (Exception e) {
            System.out.println("Error in Post Method" + e.getMessage());
            return "Error" + e;
        }
    }
}