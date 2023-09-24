package cl.musolutions.muclothes.services;

import cl.musolutions.muclothes.models.Cashier;
import cl.musolutions.muclothes.repository.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CashierServiceimpl implements CashierService{
    @Autowired
    private CashierRepository cashierRepository;

    @Override
    public List<Cashier> get() {
        Iterable<Cashier> cashiers = cashierRepository.findAll();
        List<Cashier> cashierList = new ArrayList<>();
        cashiers.forEach(cashierList::add);
        return cashierList;
    }

    @Override
    public Cashier add(Cashier cashier) {
        return cashierRepository.save(cashier);
    }

    @Override
    public Cashier edit(int id, Cashier cashier) {
        return null;
    }

    @Override
    public Cashier remove(int id) {
        return null;
    }
}
