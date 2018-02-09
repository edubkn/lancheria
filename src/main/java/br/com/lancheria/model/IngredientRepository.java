package br.com.lancheria.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository {

    List<Ingredient> findByTypeId(Integer typeId);
}
