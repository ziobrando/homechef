package it.avanscoperta.homechef.menu.domain;

import java.util.UUID;

public class MenuId {
    private final String id;

    public MenuId(String id) {
        this.id = id;
    }

    public static MenuId generate() {
        return new MenuId(UUID.randomUUID().toString());
    }
}
