package br.com.lancheria.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SnackVO implements Serializable {

    private static final long serialVersionUID = 7555150845058710658L;

    @NotNull
    private Long breadId;
    @NotNull
    private Long cheeseId;
    private Boolean doubleCheese = false;
    @NotNull
    private Long fillingId;
    private Boolean doubleFilling = false;
    @NotNull
    private Long saladId;
    private Boolean doubleSalad = false;
    private Set<Long> sauceIds = new HashSet<>();
    private Set<Long> condimentIds = new HashSet<>();

    public Long getBreadId() {
        return breadId;
    }

    public void setBreadId(Long breadId) {
        this.breadId = breadId;
    }

    public Long getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(Long cheeseId) {
        this.cheeseId = cheeseId;
    }

    public Boolean getDoubleCheese() {
        return doubleCheese;
    }

    public void setDoubleCheese(Boolean doubleCheese) {
        this.doubleCheese = doubleCheese;
    }

    public Long getFillingId() {
        return fillingId;
    }

    public void setFillingId(Long fillingId) {
        this.fillingId = fillingId;
    }

    public Boolean getDoubleFilling() {
        return doubleFilling;
    }

    public void setDoubleFilling(Boolean doubleFilling) {
        this.doubleFilling = doubleFilling;
    }

    public Long getSaladId() {
        return saladId;
    }

    public void setSaladId(Long saladId) {
        this.saladId = saladId;
    }

    public Boolean getDoubleSalad() {
        return doubleSalad;
    }

    public void setDoubleSalad(Boolean doubleSalad) {
        this.doubleSalad = doubleSalad;
    }

    public Set<Long> getSauceIds() {
        return sauceIds;
    }

    public void setSauceIds(Set<Long> sauceIds) {
        this.sauceIds = sauceIds;
    }

    public Set<Long> getCondimentIds() {
        return condimentIds;
    }

    public void setCondimentIds(Set<Long> condimentIds) {
        this.condimentIds = condimentIds;
    }

    public void addSauce(Long sauceId) {
        if (this.sauceIds == null) {
            this.sauceIds = new HashSet<>();
        }
        this.sauceIds.add(sauceId);
    }
}
