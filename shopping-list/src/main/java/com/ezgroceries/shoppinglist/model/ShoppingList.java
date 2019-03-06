package com.ezgroceries.shoppinglist.model;

import java.util.UUID;

public class ShoppingList {

    private final UUID shoppingListId;
    private final String name;

    public ShoppingList(UUID shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public String getName() {
        return name;
    }
}
