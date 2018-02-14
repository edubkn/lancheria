package br.com.lancheria.vo;

import br.com.lancheria.enums.PaymentType;
import br.com.lancheria.model.entity.Snack;
import br.com.lancheria.validator.constraint.IsHundredPercent;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderVO implements Serializable {
    
    private static final long serialVersionUID = -6345768865088219598L;

    @NotEmpty
    private List<SnackVO> snacks;

    @NotBlank
    private String userFacebookId;

    @NotBlank
    private String address;

    @NotNull
    private PaymentType paymentType;

    private Boolean needChange = false;

    @IsHundredPercent
    private Map<Integer, BigDecimal> paymentSplit;

    public List<SnackVO> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<SnackVO> snacks) {
        this.snacks = snacks;
    }

    public String getUserFacebookId() {
        return userFacebookId;
    }

    public void setUserFacebookId(String userFacebookId) {
        this.userFacebookId = userFacebookId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean getNeedChange() {
        return needChange;
    }

    public void setNeedChange(Boolean needChange) {
        this.needChange = needChange;
    }

    public Map<Integer, BigDecimal> getPaymentSplit() {
        return paymentSplit;
    }

    public void setPaymentSplit(Map<Integer, BigDecimal> paymentSplit) {
        this.paymentSplit = paymentSplit;
    }

    public void addSnack(SnackVO snack) {
        if (this.snacks == null) {
            this.snacks = new ArrayList<>();
        }
        this.snacks.add(snack);
    }
}
