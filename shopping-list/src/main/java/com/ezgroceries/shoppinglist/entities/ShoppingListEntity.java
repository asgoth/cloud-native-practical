package com.ezgroceries.shoppinglist.entities;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppingListEntity {

    @Id
    private UUID id;

    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
