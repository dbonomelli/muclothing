package cl.musolutions.muclothes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(HttpSession httpSession, Model model){
        String email = (String) httpSession.getAttribute("email");
        if(email != null){
            model.addAttribute("email", email);
            return "home";
        }else{
            return "redirect:/login";
        }

    }

}
