package br.com.lancheria.service;

import br.com.lancheria.model.repository.IngredientRepository;
import br.com.lancheria.vo.IngredientVO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Cacheable
    public List<IngredientVO> getIngredientsByType(Integer typeId) {
        return ingredientRepository.findByTypeId(typeId).stream()
                .map(i -> new IngredientVO(i.getId(), i.getName(), i.getType().getId()))
                .collect(Collectors.toList());
    }

}
