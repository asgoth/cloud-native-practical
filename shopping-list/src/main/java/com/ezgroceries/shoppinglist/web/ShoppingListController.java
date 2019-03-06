package com.ezgroceries.shoppinglist.web;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import java.net.URI;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody Map<String, String> body) {
        UUID id = UUID.fromString("eb18bb7c-61f3-4c9f-981c-55b1b8ee8915");
        ShoppingList shoppingList = new ShoppingList(id, body.get("name"));
        logger.info("Created shopping list '" + shoppingList.getName() + "' with id '" + shoppingList.getShoppingListId() + "'");
        return entityWithLocation(id).body(new ShoppingList(id, body.get("name")));
    }

    private ResponseEntity.BodyBuilder entityWithLocation(Object resourceId) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{childId}").buildAndExpand(resourceId)
                .toUri();
        return ResponseEntity.created(location);
    }

}
