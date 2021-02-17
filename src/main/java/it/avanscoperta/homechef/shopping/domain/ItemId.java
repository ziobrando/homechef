package it.avanscoperta.homechef.shopping.domain;

import java.util.UUID;

public class ItemId {

    private final String id;

    public ItemId(String id) {
        this.id = id;
    }

    public static ItemId generate() {
        return new ItemId(UUID.randomUUID().toString());
    }
}
