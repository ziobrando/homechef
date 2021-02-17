package it.avanscoperta.homechef.shopping.domain;

import it.avanscoperta.homechef.common.domain.Quantity;
import org.javamoney.moneta.Money;

public class CatalogItem {

    private final ItemId itemId;
    private final String description;
    private final Money unitPrice;
    private final Quantity unit;

    public CatalogItem(ItemId itemId, String description, Money unitPrice, Quantity unit) {
        this.itemId = itemId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unit = unit;
    }

    public String getDescription() {
        return this.description;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public Quantity getUnit() {
        return unit;
    }
}
