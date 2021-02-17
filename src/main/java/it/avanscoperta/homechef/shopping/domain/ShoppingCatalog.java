package it.avanscoperta.homechef.shopping.domain;

import java.util.Optional;

public interface ShoppingCatalog {
    Optional<CatalogItem> findFirst(String label);
}
