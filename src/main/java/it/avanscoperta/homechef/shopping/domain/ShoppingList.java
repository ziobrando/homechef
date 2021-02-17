package it.avanscoperta.homechef.shopping.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of items to purchase, with shop-friendly information.
 */
public class ShoppingList {

    List<ShoppingItem> items = new ArrayList<>();

    public static ShoppingList empty() {
        return new ShoppingList();
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean includes(String searched) {
        return items
                .stream()
                .map(ShoppingItem::getDescription)
                .anyMatch(description -> description.contains(searched));
    }

    public void add(ShoppingItem item) {
        items.add(item);
    }
}
