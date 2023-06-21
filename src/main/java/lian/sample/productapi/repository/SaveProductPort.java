package lian.sample.productapi.repository;

import lian.sample.productapi.model.entiity.Product;
import lian.sample.productapi.model.entiity.ProductItem;

public interface SaveProductPort {
    void save(Product product);

    void save(ProductItem productItem);
}
