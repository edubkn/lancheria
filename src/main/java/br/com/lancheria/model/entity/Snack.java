package br.com.lancheria.model.entity;

import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Snack {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Servings> servings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Servings> getServings() {
        return servings;
    }

    public void setServings(Set<Servings> ingredients) {
        this.servings = ingredients;
    }

    /**
     * Retorna o pão do sanduíche.
     *
     * @throws LazyInitializationException caso tente chamar fora de uma transação ou query com FETCH explícito
     */
    public Servings getBread() {
        return servings.stream()
                .filter(s -> s.getIngredient().getType().getId().equals(1))
                .findAny().orElse(null);
    }

    public BigDecimal getSnackValue() {
        return servings.stream().map(s -> s.getIngredient().getValue().multiply(BigDecimal.valueOf(s.getQuantity()))).reduce(BigDecimal::add).get();
    }

    public void addServings(Servings servings) {
        if (this.servings == null) {
            this.servings = new HashSet<>();
        }
        this.servings.add(servings);
    }
}
