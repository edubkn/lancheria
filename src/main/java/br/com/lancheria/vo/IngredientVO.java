package br.com.lancheria.vo;

import java.io.Serializable;

public class IngredientVO implements Serializable {

    private static final long serialVersionUID = 6207665773873155731L;

    private Long id;
    private String name;
    private Integer typeId;

    public IngredientVO() {
    }

    public IngredientVO(Long id, String name, Integer typeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
