package br.com.lancheria.service;

import br.com.lancheria.model.IngredientRepository;
import br.com.lancheria.vo.IngredientVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    private List<IngredientVO> getIngredientsByType(Integer typeId) {
        return ingredientRepository.findByTypeId(typeId).stream()
                .map(i -> new IngredientVO(i.getId(), i.getName(), i.getType().getId()))
                .collect(Collectors.toList());
    }

    public List<IngredientVO> getBreads() {
        return getIngredientsByType(1);
    }

    public List<IngredientVO> getCheeses() {
        return getIngredientsByType(2);
    }

    public List<IngredientVO> getFillings() {
        return getIngredientsByType(3);
    }



}
