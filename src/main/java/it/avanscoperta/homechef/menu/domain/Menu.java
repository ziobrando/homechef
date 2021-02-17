package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.ricette.domain.Ricetta;
import it.avanscoperta.homechef.users.User;

public class Menu {
    private final MenuId menuId;
    private final User user;
    private final String title;

    public Menu(MenuId menuId, User user, String title) {
        this.menuId = menuId;
        this.user = user;
        this.title = title;
    }

    public static Menu creaVuoto(MenuId menuId, User user) {
        return new Menu(menuId, user, "Menu");
    }

    public static Ricetta aggiungiRicetta(Ricetta ricetta) {
       return null;
    }
    
    public boolean isEmpty() {
        return true; // FIXME
    }
}
