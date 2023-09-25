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
        Cashier foundCashier = cashierRepository.findById(id).get();
        foundCashier.setName(cashier.getName());
        foundCashier.setStoreSection(cashier.getStoreSection());
        foundCashier.setFloor(cashier.getFloor());

        cashierRepository.save(foundCashier);

        return foundCashier;
    }

    @Override
    public Cashier find(int id) {
        boolean foundCashier = cashierRepository.findById(id).isPresent();
        if(!foundCashier){
            return null;
        }else{
            return cashierRepository.findById(id).get();
        }
    }
    @Override
    public Cashier remove(int id) {
        boolean findCashier = cashierRepository.findById(id).isPresent();
        if(findCashier){
            Cashier toDeactivate = cashierRepository.findById(id).get();
            toDeactivate.setActive(!toDeactivate.isActive());
            cashierRepository.save(toDeactivate);
            return toDeactivate;
        }
        return null;
    }
}
