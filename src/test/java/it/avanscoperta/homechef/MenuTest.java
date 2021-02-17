package it.avanscoperta.homechef;

import it.avanscoperta.homechef.common.domain.Quantity;
import it.avanscoperta.homechef.menu.domain.ListaIngredienti;
import it.avanscoperta.homechef.menu.domain.Ingrediente;
import it.avanscoperta.homechef.menu.domain.Menu;
import it.avanscoperta.homechef.menu.domain.Ricetta;
import it.avanscoperta.homechef.recipes.builder.RecipeBuilder;
import it.avanscoperta.homechef.users.User;
import it.avanscoperta.homechef.users.builders.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Menu: Unit Tests")
public class MenuTest {

    private User user;
    private Menu emptyMenu;
    private ListaIngredienti ingredientiCarbonara;
    private Ricetta carbonara;

    @BeforeEach
    void setUp() {
        user = new UserBuilder().build();
        emptyMenu = Menu.createEmpty("Serata Digiuno", user);
        ingredientiCarbonara = new ListaIngredienti(2,
                new Ingrediente("Rigatoni", Quantity.grams(200)),
                new Ingrediente("Guanciale", Quantity.grams(80)),
                new Ingrediente("Pecorino Romano", Quantity.grams(80)),
                new Ingrediente("Uova", Quantity.units(3))
        );

        carbonara = new Ricetta("Rigatoni alla Carbonara", ingredientiCarbonara);
    }

    @Test
    @DisplayName("Posso creare un menu vuoto")
    public void can_create_empty() {
        assertNotNull(emptyMenu);
    }

    @Test
    @DisplayName("Posso aggiungere una ricetta al menu")
    public void can_add_recipe_to_menu() {

        emptyMenu.addPortata(carbonara, 4);

        assertTrue(emptyMenu.containsRecipe(carbonara));
    }

    @Test
    @DisplayName("Posso aggiungere più di una ricetta al menu")
    public void can_add_more_recipes_to_menu() {
        Ricetta amatriciana = RecipeBuilder.amatriciana();
        Menu serataRomana = Menu.createEmpty("Serata Romana", user);
        serataRomana.addPortata(carbonara, 4);
        serataRomana.addPortata(amatriciana, 4);
        
        assertTrue(serataRomana.containsRecipe(carbonara));
        assertTrue(serataRomana.containsRecipe(amatriciana));
    }

}
