package it.avanscoperta.homechef;

import it.avanscoperta.homechef.menu.domain.ShopperService;
import it.avanscoperta.homechef.users.User;
import it.avanscoperta.homechef.users.builders.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@DisplayName("ShopperService: dal menu alla lista della spesa.")
public class ShopperServiceTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Un menu vuoto ritorna una lista vuota.")
    public void an_empty_menu_results_in_an_empty_shopping_list() {

        fail("da fare");
    }

    @Test
    @DisplayName("Un menu semplice produce la lista della spesa.")
    public void a_simple_menu_will_return_the_corresponding_Shopping_list() {
        fail("da fare");
    }


}
