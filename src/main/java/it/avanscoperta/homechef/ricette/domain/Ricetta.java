package it.avanscoperta.homechef.ricette.domain;

public class Ricetta {
    private final RicettaId ricettaId;
    private final String title;

    public Ricetta(RicettaId menuId,String title) {
        this.ricettaId = menuId;
        
        this.title = title;
    }

    public static Ricetta creaVuoto(RicettaId ricettaId) {
        return new Ricetta(ricettaId, "Ricetta");
    }

    public boolean isEmpty() {
        return true; // FIXME
    }
}