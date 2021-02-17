package it.avanscoperta.homechef.ricette.domain;

/**
 * Sarà un Value Object
 */
public class Ricetta {
    private final RicettaId ricettaId;
    private final String title;

    public Ricetta(RicettaId menuId,String title) {
        this.ricettaId = menuId;
        
        this.title = title;
    }

    // TODO: Ma perché?
    public static Ricetta creaVuoto(RicettaId ricettaId) {
        return new Ricetta(ricettaId, "Ricetta");
    }

    public boolean isEmpty() {
        return true; // FIXME
    }
}
