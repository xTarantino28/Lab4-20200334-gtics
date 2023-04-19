package com.example.lab420200334.controller;


import com.example.lab420200334.entity.User;
import com.example.lab420200334.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {


    final UserRepository userRepository;
    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    public String index(){
        return "inicio";
    }


    @PostMapping("/login/inicioSesion")
    public String validarcredencial(@RequestParam("correo") String correo, @RequestParam("constrasena") String constrasena, Model model ){
        Optional<User> optUser = Optional.ofNullable(userRepository.encontrarUsuario(correo, constrasena));

        if (optUser.isPresent()) {
            User user = optUser.get();
            model.addAttribute("user", user);
            return "homePage";
        } else {
            return "redirect:/";
        }





        return "inicio";
    }

}
