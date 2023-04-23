package com.example.lab420200334.controller;


import com.example.lab420200334.entity.Reserva;
import com.example.lab420200334.entity.User;
import com.example.lab420200334.repository.ReservaRepository;
import com.example.lab420200334.repository.UserRepository;
import com.example.lab420200334.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/homePage")
    public String homePage(Model model){
        List listaVuelos = vueloRepository.findAll();
        model.addAttribute("listaVuelos", listaVuelos);
        return "homePage";
    }



    @RequestMapping(value = "/login/inicioSesion",  method = { RequestMethod.GET, RequestMethod.POST } )
    public String validarcredencial(@RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena, Model model, RedirectAttributes attr ){
        Optional<User> optUser = Optional.ofNullable(userRepository.encontrarUsuario(correo, contrasena));

        if (optUser.isPresent()) {
            User user = optUser.get();
            //attr.addAttribute("user_iduser",user.getIduser());
            //System.out.println(user.getIduser());
            model.addAttribute("user",user);
            List listaVuelos = vueloRepository.findAll();
            model.addAttribute("listaVuelos", listaVuelos);
            return "homePage";


        } else {
            return "redirect:/";
        }
    }


    @RequestMapping(value ="/guardarReserva", method = { RequestMethod.GET, RequestMethod.POST })
    public String guardarReserva(@RequestParam("vuelo_idvuelo") int vuelo_idvuelo,
                                 @RequestParam("user_iduser") int user_iduser,
                                 Model model,
                                 @RequestParam("precio_total") String precio_total){
        Double precio = Double.parseDouble(precio_total);
        reservaRepository.guardarReserva(vuelo_idvuelo, user_iduser, precio);

        Optional<User> optUser = userRepository.findById(user_iduser);

        if (optUser.isPresent()) {
            User user = optUser.get();
            //attr.addAttribute("user_iduser",user.getIduser());
            //System.out.println(user.getIduser());
            model.addAttribute("user",user);
            List listaVuelos = vueloRepository.findAll();
            model.addAttribute("listaVuelos", listaVuelos);
            return "homePage";


        } else {
            return "redirect:/";
        }
    }


}
