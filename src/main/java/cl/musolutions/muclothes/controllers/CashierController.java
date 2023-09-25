package cl.musolutions.muclothes.controllers;

import cl.musolutions.muclothes.models.Cashier;
import cl.musolutions.muclothes.services.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        cashier.setActive(true);
        Cashier newCashier = cashierService.add(cashier);

        return "redirect:/cashiers";
    }

    @GetMapping("/cashiers/edit/{id}")
    public String editCashiers(@PathVariable int id, Model model){
        Cashier foundCashier = cashierService.find(id);
        if(foundCashier == null){
            return null;
        }else{
            model.addAttribute("cashier", foundCashier);
        }

        return "edit-cashiers";
    }

    @PostMapping("/cashiers/edit/{id}")
    public String editCashier(@ModelAttribute("cashier")  Cashier cashier, @PathVariable int id, Model model){
        Cashier editedCashier = cashierService.edit(id, cashier);
        model.addAttribute("editedCashier", editedCashier);
        boolean didUpdate = true;
        model.addAttribute("didUpdate", didUpdate);
        return "redirect:/cashiers";

    }

    @PostMapping("/cashiers/delete/{id}")
    public String deleteCashier(@PathVariable int id){
        Cashier deactivatedCashier = cashierService.remove(id);
        return "redirect:/cashiers";
    }
}
