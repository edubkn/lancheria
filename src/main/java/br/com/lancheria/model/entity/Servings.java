package br.com.lancheria.model.entity;

import javax.persistence.*;

@Entity
public class Servings {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Integer quantity;

    public Servings(){}

    public Servings(Long ingredientId) {
        this(ingredientId, 1);
    }

    public Servings(Long ingredientId, Integer quantity) {
        this.ingredient = new Ingredient(ingredientId);
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
