package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Il nostro aggregato principale, che in qualche modo guida anche il linguaggio degli oggetti circostanti.
 */
public class Menu {

    private final String headline;
    private final User user;
    private final List<Portata> portate = new ArrayList<>();

    public Menu(String headline, User user) {

        this.headline = headline;
        this.user = user;
    }

    public static Menu createEmpty(String headline, User user) {
       return new Menu(headline, user);

    }

    public static Menu fromRecipe(Ricetta ricetta, User user, int persone) {
        Menu menu = new Menu(ricetta.getHeadline(), user);
        menu.addPortata(ricetta, persone);
        return menu;
    }

    /**
     * Aggiungo una portata al menu, indicando per quante persone voglio cucinare la ricetta.
     * @param ricetta la ricetta che ho intenzione di cucinare.
     * @param perQuanti il numero di persone per cui è pensato il piatto. <-- very DDD! Si legge meglio nel codice. :-)
     */
    public void addPortata(Ricetta ricetta, int perQuanti ) {
        this.portate.add(new Portata(ricetta, perQuanti));
    }

    public boolean containsRecipe(Ricetta ricetta) {
        return portate
                .stream()
                .map(Portata::getRecipe)
                .anyMatch(myRecipe -> myRecipe.equals(ricetta));
    }

    public List<Portata> getPortate() {
        return portate;
    }
}
