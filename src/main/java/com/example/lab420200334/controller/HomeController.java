package com.example.lab420200334.controller;


import com.example.lab420200334.entity.Reserva;
import com.example.lab420200334.entity.User;
import com.example.lab420200334.repository.ReservaRepository;
import com.example.lab420200334.repository.UserRepository;
import com.example.lab420200334.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {


    final UserRepository userRepository;
    final ReservaRepository reservaRepository;
    final VueloRepository vueloRepository;
    public HomeController(UserRepository userRepository, ReservaRepository reservaRepository,VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.userRepository = userRepository;
        this.vueloRepository = vueloRepository;
    }
    @GetMapping("/")
    public String index(){
        return "inicio";
    }


    @PostMapping("/login/inicioSesion")
    public String validarcredencial(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena, Model model ){
        Optional<User> optUser = Optional.ofNullable(userRepository.encontrarUsuario(correo, contrasena));

        if (optUser.isPresent()) {
            User user = optUser.get();

            List listaVuelos = vueloRepository.findAll();
            model.addAttribute("user", user);
            model.addAttribute("listaVuelos", listaVuelos);
            return "homePage";

        } else {
            return "redirect:/";
        }


    }

}
