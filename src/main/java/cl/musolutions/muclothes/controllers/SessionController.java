package cl.musolutions.muclothes.controllers;

import cl.musolutions.muclothes.models.User;
import cl.musolutions.muclothes.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {
    @Autowired
    private UserService userService;

    private boolean authenticateUser(String email, String password){
        User toAuth = userService.login(email, password);
        return toAuth != null;
    }

    private boolean checkSession(HttpSession httpSession){
        String email = (String) httpSession.getAttribute("email");
        return email != null;
    }

    @GetMapping("/login")
    public String getLogin(HttpSession httpSession){
        if(checkSession(httpSession)){
            return "home";
        }else{
            return "login";
        }
    }

    @PostMapping("/login")
    public String login(HttpSession httpSession, String email, String password){
        if(authenticateUser(email, password)){
            httpSession.setAttribute("email", email);
            return "redirect:/";
        }else{
            return "login";
        }

    }

    @PostMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegister(HttpSession httpSession){
        if(checkSession(httpSession)){
            return "home";
        }else{
            return "register";
        }
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user){
        User newUser = userService.register(user.getEmail(), user.getPassword());
        return "login";
    }
}
