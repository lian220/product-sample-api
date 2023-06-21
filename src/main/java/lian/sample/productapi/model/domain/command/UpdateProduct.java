package lian.sample.productapi.model.domain.command;

import lian.sample.productapi.model.domain.ProductInfo;
import lombok.Getter;

@Getter
public class UpdateProduct extends ProductInfo {
    private long productId;
}
