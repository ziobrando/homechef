package it.avanscoperta.homechef.recipes.builder;

import it.avanscoperta.homechef.common.domain.Quantity;
import it.avanscoperta.homechef.menu.domain.Ingrediente;
import it.avanscoperta.homechef.menu.domain.ListaIngredienti;
import it.avanscoperta.homechef.menu.domain.Recipe;

/**
 * A Test data builder that actually knows something.
 */
public class RecipeBuilder {
    public static Recipe amatriciana() {
        return new Recipe("Bucatini all'amatriciana",
                new ListaIngredienti(
                        4,
                        new Ingrediente("Bucatini", Quantity.grams(400)),
                        new Ingrediente("Guanciale", Quantity.grams(250)),
                        new Ingrediente("Polpa di pomodoro", Quantity.grams(250)),
                        new Ingrediente("Pecorino romano", Quantity.grams(150))
                )
        );
    }
}
