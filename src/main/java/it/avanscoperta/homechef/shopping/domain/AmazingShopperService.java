package it.avanscoperta.homechef.shopping.domain;

import it.avanscoperta.homechef.menu.domain.Ingrediente;
import it.avanscoperta.homechef.menu.domain.Menu;
import it.avanscoperta.homechef.menu.domain.Portata;
import it.avanscoperta.homechef.menu.domain.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Implementazione "quasi reale" dello ShopperService: abbiamo ancora un po' di parti non ancora
 * ben specificate, ma siamo in grado di delineare parte del comportamento.
 */
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
                .forEach(ingrediente -> shoppingList.add(resolveItem(ingrediente)));
    }

    private ShoppingItem resolveItem(Ingrediente ingrediente) {

        /*
         * Questa è la mossa al confine tra la furberia e la porcata. Se sono nell'assunzione che
         * shoppingCatalog sia già ordinato secondo il mio criterio di ottimizzazione principale, allora
         * questo funzionamento potrebbe non essere impattato se decido successivamente di prioritizzare
         * per prezzo, qualità, tempi di consegna, o un famigerato 'CoefficienteOmega' che sia la combinazione
         * bilanciata di tutti questi fattori.
         * Passami uno shoppingCatalog ordinato secondo il nuovo criterio, ed io continuon a funzionare.
         */
        Optional<CatalogItem> maybeItem = shoppingCatalog.findFirst(ingrediente.getLabel());
        if (maybeItem.isPresent()) { // so che ci sono modi più eleganti, ma dopo mezzanotte... se il test verde è ok.
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
