package lian.sample.productapi.service;

import lian.sample.productapi.model.domain.CreateProduct;
import lian.sample.productapi.model.entiity.Product;

public interface ProductUseCase {
    void createProduct(CreateProduct product);

    Product getProduct(long productId);
}
