package it.avanscoperta.homechef.shopping.domain;

import org.javamoney.moneta.Money;

public class ShoppingItem {
    private final ItemId itemId;
    private final String description;
    private final Money price;

    public ShoppingItem(ItemId itemId, String description, Money price) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public Money getPrice() {
        return price;
    }
}
