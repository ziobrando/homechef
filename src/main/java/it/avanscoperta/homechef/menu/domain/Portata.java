package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.ricette.domain.Ricetta;

public class Portata {
    private final Ricetta ricetta;
    private final int persone;

    public Portata(Ricetta ricetta, int persone) {
        this.ricetta = ricetta;
        this.persone = persone;
    }

    public Ricetta getRicetta() {
        return this.ricetta;
    }

}
