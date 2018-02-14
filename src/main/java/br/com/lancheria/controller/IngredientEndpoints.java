package br.com.lancheria.controller;

import br.com.lancheria.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.lancheria.controller.IngredientEndpoints.PATH_INGREDIENTS;

@RestController
@RequestMapping(PATH_INGREDIENTS)
public class IngredientEndpoints {

    public static final String PATH_INGREDIENTS = "/ingredients";
    public static final String PATH_BREADS = "/breads";
    public static final String PATH_CHEESES = "/cheeses";
    public static final String PATH_FILLINGS = "/fillings";

    private IngredientService ingredientService;

    public IngredientEndpoints(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(PATH_BREADS)
    public ResponseEntity<?> getBreads() {
        return ResponseEntity.ok(ingredientService.getIngredientsByType(1));
    }

    @GetMapping(PATH_CHEESES)
    public ResponseEntity<?> getCheeses() {
        return ResponseEntity.ok(ingredientService.getIngredientsByType(2));
    }

    @GetMapping(PATH_FILLINGS)
    public ResponseEntity<?> getFillings() {
        return ResponseEntity.ok(ingredientService.getIngredientsByType(3));
    }

}
