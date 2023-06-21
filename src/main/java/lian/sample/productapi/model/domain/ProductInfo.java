package lian.sample.productapi.model.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class ProductInfo {
    @NotEmpty(message = "상품명을 입력해주세요.")
    private String name;
    @Min(1)
    private int quantity;
    @Min(1)
    private long price;
    private String description;
    private boolean isUsed;

    private Instant created;
    private Instant updated;
    private Instant deleted;

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
