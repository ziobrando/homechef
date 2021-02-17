package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static Menu fromRecipe(Recipe recipe, User user, int persone) {
        Menu menu = new Menu(recipe.getHeadline(), user);
        menu.addPortata(recipe, persone);
        return menu;
    }

    /**
     * TODO: questa ora sembra strana.
     * @param recipe
     */
    public void addPortata(Recipe recipe, int perQuanti ) {
        this.portate.add(new Portata(recipe, perQuanti));
    }

    public boolean containsRecipe(Recipe recipe) {
        return portate
                .stream()
                .map(portata -> portata.getRecipe())
                .anyMatch(myRecipe -> myRecipe.equals(recipe));
    }

    public List<Portata> getPortate() {
        return portate;
    }
}
