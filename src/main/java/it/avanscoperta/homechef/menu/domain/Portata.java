package it.avanscoperta.homechef.menu.domain;

/**
 * A Portata is a given dish served to a given number of people, possibly at the same time.
 */
public class Portata {

    private final Ricetta ricetta;
    private final int perQuanti;

    public Portata(Ricetta ricetta, int perQuanti) {
        this.ricetta = ricetta;
        this.perQuanti = perQuanti;
    }

    public Ricetta getRecipe() {
        return ricetta;
    }

    /**
     * Momento triste: lo Ubiquitous Language funziona meglio in inglese che nelle altre lingue, anche perché i
     * linguaggi di programmazione sono intrinsecamente in inglese. C'è poco da fare, qualche angolo "brutto"
     * ci sarà comunque.
     *
     * Ma nella conversazione, i termini di dominio erano principalmente in italiano, quindi ha senso spostare la
     * nostra modellazione di conseguenza.
     *
     * @return
     */
    public int getPerQuanti() {
        return perQuanti;
    }
}
