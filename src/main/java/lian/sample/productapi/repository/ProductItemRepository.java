package lian.sample.productapi.repository;

import lian.sample.productapi.model.entiity.ProductItem;
import org.springframework.data.repository.Repository;

public interface ProductItemRepository extends Repository<ProductItem, Long> {
    ProductItem save(ProductItem productItem);
}
