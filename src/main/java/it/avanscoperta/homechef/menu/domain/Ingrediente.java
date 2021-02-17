package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.common.domain.Quantity;

public class Ingrediente {
    private final String label;
    private final Quantity quantity;

    public Ingrediente(String label, Quantity quantity) {
        this.label = label;
        this.quantity = quantity;
    }

    public String getLabel() {
        return label;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
