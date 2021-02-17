package it.avanscoperta.homechef;

import it.avanscoperta.homechef.menu.domain.Menu;
import it.avanscoperta.homechef.menu.domain.MenuId;
import it.avanscoperta.homechef.ricette.builders.RicettaBuilder;
import it.avanscoperta.homechef.ricette.domain.Ricetta;
import it.avanscoperta.homechef.users.User;
import it.avanscoperta.homechef.users.builders.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Menu: Unit Tests")
public class MenuTest {


    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Posso creare un menu vuoto")
    public void can_create_empty() {
        User user = new UserBuilder().build();
        MenuId menuId = MenuId.generate();
        Menu menuVuoto = Menu.creaVuoto(menuId, user);

        assertNotNull(menuVuoto);
        assertTrue(menuVuoto.isEmpty());
    }

    @Test
    @DisplayName("Posso aggiungere una ricetta al menu")
    public void can_add_recipe_to_menu() {
        Ricetta ricetta = new RicettaBuilder().build("ricetta");
        
    }


}
