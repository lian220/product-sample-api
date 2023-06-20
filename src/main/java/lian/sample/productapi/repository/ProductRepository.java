package lian.sample.productapi.repository;

import lian.sample.productapi.model.entiity.Product;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long> {
    Product save(Product product);
}
