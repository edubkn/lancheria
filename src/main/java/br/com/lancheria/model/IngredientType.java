package br.com.lancheria.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientType {

    @Id
    private Integer id;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
