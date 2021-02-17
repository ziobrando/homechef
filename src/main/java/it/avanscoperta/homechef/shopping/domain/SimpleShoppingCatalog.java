package it.avanscoperta.homechef.shopping.domain;

import it.avanscoperta.homechef.common.domain.Quantity;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SimpleShoppingCatalog implements ShoppingCatalog{

    List<CatalogItem> catalog = new ArrayList<CatalogItem>();

    public SimpleShoppingCatalog() {
        init();
    }

    @Override
    public Optional<CatalogItem> findFirst(String label) {
        return catalog.stream().filter(item -> item.getDescription().equals(label)).findFirst();
    }

    private void init() {
        catalog.add(new CatalogItem(ItemId.generate(), "Uova", Money.of(2.50, "EUR"), Quantity.units(6)));
        catalog.add(new CatalogItem(ItemId.generate(), "Guanciale", Money.of(18, "EUR"), Quantity.grams(1000)));
        catalog.add(new CatalogItem(ItemId.generate(), "Bucatini", Money.of(0.99, "EUR"), Quantity.grams(500)));
        catalog.add(new CatalogItem(ItemId.generate(),
                "Polpa di pomodoro",
                Money.of(1.5, "EUR"),
                Quantity.grams(500)));
        catalog.add(new CatalogItem(ItemId.generate(),
                "Pecorino romano",
                Money.of(2.89, "EUR"),
                Quantity.grams(250)));

    }
}
