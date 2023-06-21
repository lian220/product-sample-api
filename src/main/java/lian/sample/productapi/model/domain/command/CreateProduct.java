package lian.sample.productapi.model.domain.command;

import lian.sample.productapi.model.domain.ProductInfo;
import lian.sample.productapi.model.domain.ProductItemInfo;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateProduct extends ProductInfo {
    private List<ProductItemInfo> productItemInfoList;
}
