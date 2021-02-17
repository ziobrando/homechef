package it.avanscoperta.homechef;

import it.avanscoperta.homechef.menu.domain.Menu;
import it.avanscoperta.homechef.menu.domain.MenuId;
import it.avanscoperta.homechef.ricette.builders.RicettaBuilder;
import it.avanscoperta.homechef.ricette.domain.Ricetta;
import it.avanscoperta.homechef.ricette.domain.RicettaId;
import it.avanscoperta.homechef.users.User;
import it.avanscoperta.homechef.users.builders.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Menu: Unit Tests")
public class MenuTest {

    User user;
    MenuId menuId;
    Ricetta ricetta;

    @BeforeEach
    void setUp() {
        user = new UserBuilder().build();
        menuId = MenuId.generate();
        ricetta = new RicettaBuilder().build("ricetta");
    }

    @Test
    @DisplayName("Posso creare un menu vuoto")
    public void can_create_empty() {
        Menu menuVuoto = Menu.creaVuoto(menuId, user);

        assertNotNull(menuVuoto);
        assertTrue(menuVuoto.isEmpty());
    }

    @Test
    @DisplayName("Posso aggiungere una ricetta al menu")
    public void can_add_recipe_to_menu() {


        Menu menu = Menu.creaVuoto(menuId, user);
        menu.addRicetta(ricetta, 2);

        assertTrue(menu.containsRicetta(ricetta));
    }

    @Test
    @DisplayName("Se aggiungo una ricetta non è più vuoto")
    public void adding_recipe_makes_menu_not_empty() {

        Menu menu = Menu.creaVuoto(menuId, user);
        menu.addRicetta(ricetta, 2);

        assertFalse(menu.isEmpty());
    }

    @Test
    @DisplayName("Posso aggiungere più ricette al menu")
    public void can_add_many_recipes_to_menu() {

        Ricetta altraRicetta = new Ricetta(RicettaId.generate(), "Ricetta alternativa");

        Menu menu = Menu.creaVuoto(menuId, user);
        menu.addRicetta(ricetta, 2);
        menu.addRicetta(altraRicetta, 4);

        assertTrue(menu.containsRicetta(ricetta));
        assertTrue(menu.containsRicetta(altraRicetta));
    }


}
