package lian.sample.productapi.service;

import lian.sample.productapi.model.domain.ProductItemInfo;
import lian.sample.productapi.model.domain.command.CreateProduct;
import lian.sample.productapi.model.domain.command.UpdateProduct;
import lian.sample.productapi.model.domain.query.ProductDto;

public interface ProductUseCase {
    void createProduct(CreateProduct product);

    ProductDto getProduct(long productId);

    void updateProduct(UpdateProduct updateProduct);

    void updateProductItem(ProductItemInfo productItemInfo, long productId);
}
