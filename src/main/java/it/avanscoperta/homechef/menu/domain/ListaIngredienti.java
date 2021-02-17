package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.menu.domain.Ingrediente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * is there any behaviour specific for this class except type check?
 */
public class ListaIngredienti {

    private int persone;
    List<Ingrediente> ingredienti = new ArrayList<>();

    public ListaIngredienti(int persone, Ingrediente... ingredients) {
        this.persone = persone;
        for(Ingrediente ingrediente: ingredients) {
            ingredienti.add(ingrediente);
        }
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }
}
