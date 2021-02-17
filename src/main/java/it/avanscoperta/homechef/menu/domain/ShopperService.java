package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.shopping.domain.ShoppingList;

public interface ShopperService {

    ShoppingList getShoppingListForMenu(Menu menu);
}
