package it.avanscoperta.homechef.menu.domain;

/**
 * A Portata is a given dish served to a given number of people, possibly at the same time.
 */
public class Portata {

    private final Recipe recipe;
    private final int commensali;

    public Portata(Recipe recipe, int commensali) {
        this.recipe = recipe;
        this.commensali = commensali;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
