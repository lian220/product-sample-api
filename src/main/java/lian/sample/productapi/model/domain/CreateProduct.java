package lian.sample.productapi.model.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateProduct extends ProductInfo {
    private List<ProductItemInfo> productItemInfoList;
}
