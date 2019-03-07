package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.client.CocktailDBClient;
import com.ezgroceries.shoppinglist.client.CocktailDBResponse;
import com.ezgroceries.shoppinglist.model.Cocktail;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    private final CocktailDBClient cocktailDBClient;

    public CocktailController(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    @GetMapping
    public ResponseEntity<List<Cocktail>> get(@RequestParam String search) {
        return ResponseEntity.ok(convert(cocktailDBClient.searchCocktails(search)));
    }

    private List<Cocktail> convert(CocktailDBResponse dbResponse) {
        return dbResponse.getDrinks().stream()
                .map(drinkResource -> new Cocktail(
                                UUID.randomUUID(),
                                drinkResource.getStrDrink(),
                                drinkResource.getStrGlass(),
                                drinkResource.getStrInstructions(),
                                drinkResource.getStrDrinkThumb(),
                                Stream.of(
                                        drinkResource.getStrIngredient1(),
                                        drinkResource.getStrIngredient2(),
                                        drinkResource.getStrIngredient3(),
                                        drinkResource.getStrIngredient4(),
                                        drinkResource.getStrIngredient5()
                                ).filter(StringUtils::isNotBlank).collect(Collectors.toList())
                        )
                ).collect(Collectors.toList());

    }
}
