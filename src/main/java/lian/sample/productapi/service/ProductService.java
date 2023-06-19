package lian.sample.productapi.service;

import lian.sample.productapi.model.domain.CreateProduct;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductUseCase {
    @Override
    public CreateProduct createProduct(CreateProduct product) {
        return null;
    }
}
