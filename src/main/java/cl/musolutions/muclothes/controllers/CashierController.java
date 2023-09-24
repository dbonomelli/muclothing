package cl.musolutions.muclothes.controllers;

import cl.musolutions.muclothes.models.Cashier;
import cl.musolutions.muclothes.services.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CashierController {
    @Autowired
    private CashierService cashierService;
    @GetMapping("/cashiers")
    public String listCashiers(Model model){
        List<Cashier> cashierList = cashierService.get();
        model.addAttribute("cashiers", cashierList);
        return "list-cashiers";
    }

    @GetMapping("/cashiers/create")
    public String createCashiers(){
        return "create-cashiers";
    }

    @PostMapping("/cashiers")
    public String addCashier(@ModelAttribute("cashier")  Cashier cashier){
        //TODO process the cashier object to see if there are any errors.
        Cashier newCashier = cashierService.add(cashier);

        return "redirect:/cashiers";
    }
}
