package lian.sample.productapi.model.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class ProductInfo {
    @NotEmpty(message = "상품명을 입력해주세요.")
    private String name;
    @Min(1)
    private int quantity;
    @Min(1)
    private long price;
    private String description;
    private boolean isUsed;

    //detail
    private int maxChooseQuantity;
    private int initCycle;
    private Double saleRate;
    private boolean useSaleRate;
    private Long salePrice;
    private boolean useSalePrice;
    private Long savingPoint;
    private Double savingPointRate;
    private boolean useSavingPointRate;

}
