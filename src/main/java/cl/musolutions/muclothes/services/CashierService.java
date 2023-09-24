package cl.musolutions.muclothes.services;

import cl.musolutions.muclothes.models.Cashier;

import java.util.List;

public interface CashierService {
    List<Cashier> get();
    Cashier add(Cashier cashier);
    Cashier edit(int id, Cashier cashier);
    Cashier remove(int id);
}
