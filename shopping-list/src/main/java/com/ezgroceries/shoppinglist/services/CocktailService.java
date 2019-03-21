package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.model.Cocktail;
import java.util.List;

public interface CocktailService {

    List<Cocktail> searchCocktails(String search);

    List<CocktailEntity> getAllById(List<String> cocktails);
}
