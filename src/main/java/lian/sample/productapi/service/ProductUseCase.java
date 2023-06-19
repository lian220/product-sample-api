package lian.sample.productapi.service;

import lian.sample.productapi.model.domain.CreateProduct;

public interface ProductUseCase {
    CreateProduct createProduct(CreateProduct product);
}
