package lian.sample.productapi.model.domain;

import lombok.Getter;

@Getter
public class CreateProduct extends Product{
    private long productId;
    private long productDetailId;
//    private byte[] imageList;
}
