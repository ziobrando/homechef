package it.avanscoperta.homechef.shopping.domain;

import it.avanscoperta.homechef.menu.domain.Ingrediente;
import it.avanscoperta.homechef.menu.domain.Menu;
import it.avanscoperta.homechef.menu.domain.Portata;
import it.avanscoperta.homechef.menu.domain.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AmazingShopperService implements ShopperService {

    @Autowired
    ShoppingCatalog shoppingCatalog;

    @Override
    public ShoppingList getShoppingListForMenu(Menu menu) {
        ShoppingList shoppingList = ShoppingList.empty();
        menu.getPortate()
                .stream()
                .forEach(portata -> selectItems(portata, shoppingList));
        return shoppingList;
    }

    private void selectItems(Portata portata, ShoppingList shoppingList) {
        portata.getRecipe()
                .getListaIngredienti()
                .getIngredienti()
                .stream()
                .forEach(ingrediente -> shoppingList.add(resolveItem(ingrediente)));
    }

    private ShoppingItem resolveItem(Ingrediente ingrediente) {

        Optional<CatalogItem> maybeItem = shoppingCatalog.findFirst(ingrediente.getLabel());
        if (maybeItem.isPresent()) {
            CatalogItem item = maybeItem.get();
            return toShoppingItem(item);
        } else {
            throw new IngredientNotFoundException(ingrediente.getLabel());
        }


    }

    private ShoppingItem toShoppingItem(CatalogItem catalogItem) {
        return new ShoppingItem(catalogItem.getItemId(),
                catalogItem.getDescription(),
                catalogItem.getUnitPrice());
    }
}
