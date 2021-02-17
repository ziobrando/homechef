package it.avanscoperta.homechef;

import it.avanscoperta.homechef.MenuTest;
import it.avanscoperta.homechef.menu.domain.Menu;
import it.avanscoperta.homechef.menu.domain.Recipe;
import it.avanscoperta.homechef.menu.domain.ShopperService;
import it.avanscoperta.homechef.recipes.builder.RecipeBuilder;
import it.avanscoperta.homechef.shopping.domain.AmazingShopperService;
import it.avanscoperta.homechef.shopping.domain.ShoppingList;
import it.avanscoperta.homechef.users.User;
import it.avanscoperta.homechef.users.builders.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("ShopperService: dal menu alla lista della spesa.")
public class ShopperServiceTest {

    private User user;
    private Menu emptyMenu;

    @Autowired
    private ShopperService service;

    @BeforeEach
    void setUp() {
        user = new UserBuilder().build();
        emptyMenu = Menu.createEmpty("Digiuno, ma tra amici.", user);
        //service = new AmazingShopperService();
    }

    @Test
    @DisplayName("Un menu vuoto ritorna una lista vuota.")
    public void an_empty_menu_results_in_an_empty_shopping_list() {

        ShoppingList shoppingList = service.getShoppingListForMenu(emptyMenu);
        assertTrue(shoppingList.isEmpty());
    }

    @Test
    @DisplayName("Un menu semplice produce la lista della spesa.")
    public void a_simple_menu_will_return_the_corresponding_Shopping_list() {
        Recipe amatriciana = RecipeBuilder.amatriciana();
        Menu serataRomana = Menu.fromRecipe(amatriciana, user,4);

        ShoppingList shoppingList = service.getShoppingListForMenu(serataRomana);

        assertTrue(shoppingList.includes("Guanciale"));
    }




    private class MockShopperService implements ShopperService {
        @Override
        public ShoppingList getShoppingListForMenu(Menu menu) {
            return new ShoppingList();
        }
    }
}
