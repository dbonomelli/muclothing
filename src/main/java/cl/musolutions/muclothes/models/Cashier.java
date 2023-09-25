package cl.musolutions.muclothes.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Cashier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCashier;

    private String name;
    private String storeSection;
    private int floor;
    private boolean active;
}
