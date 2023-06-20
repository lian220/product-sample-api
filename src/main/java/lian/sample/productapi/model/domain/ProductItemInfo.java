package lian.sample.productapi.model.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class ProductItemInfo {
    @NotEmpty(message = "상품명을 입력해주세요.")
    private String name;
    @Min(1)
    private int quantity;
    @Min(1)
    private long price;
    private String description;
    private boolean isUsed;
}
