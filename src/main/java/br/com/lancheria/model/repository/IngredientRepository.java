package br.com.lancheria.model.repository;

import br.com.lancheria.model.entity.Ingredient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByTypeId(Integer typeId);

    @Cacheable("ingredients")
    Ingredient findById(Long id);
}
