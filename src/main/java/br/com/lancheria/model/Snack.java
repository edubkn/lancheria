package br.com.lancheria.model;

import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Snack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinTable(name = "servings", joinColumns = @JoinColumn(name = "id_snack"), inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private Set<Servings> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Servings> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Servings> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Retorna o pão do sanduíche.
     *
     * @throws LazyInitializationException caso tente chamar fora de uma transação ou query com FETCH explícito
     */
    public Servings getBread() {
        return ingredients.stream()
                .filter(s -> s.getIngredient().getType().getId().equals(1))
                .findAny().orElse(null);
    }

    public BigDecimal getSnackValue() {
        return ingredients.stream().map(s -> s.getIngredient().getValue().multiply(BigDecimal.valueOf(s.getQuantity()))).reduce(BigDecimal::add).get();
    }
}
