package it.avanscoperta.homechef.menu.domain;

public class Recipe {
    private final String headline;
    private final ListaIngredienti listaIngredienti;

    public Recipe(String headline, ListaIngredienti listaIngredienti) {
        this.headline = headline;
        this.listaIngredienti = listaIngredienti;
    }

    public String getHeadline() {
        return this.headline;
    }

    public ListaIngredienti getListaIngredienti() {
        return listaIngredienti;
    }
}
