package it.avanscoperta.homechef.menu.domain;

import it.avanscoperta.homechef.shopping.domain.ShoppingList;

/**
 * Questo sarà un oggetto di frontiera: la sua interfaccia è definita qui, ma l'implementazione
 * avrà le mani un po' più sporche.
 *
 * Però voglio che faccia queste cose, nel mio dominio, come è affar suo.
 */
public interface ShopperService {

    ShoppingList getShoppingListForMenu(Menu menu);
}
