package lian.sample.productapi.repository;

import lian.sample.productapi.model.entiity.Product;

public interface SaveProductPort {
    void save(Product product);
}
