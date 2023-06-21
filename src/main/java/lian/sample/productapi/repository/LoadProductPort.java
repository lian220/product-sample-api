package lian.sample.productapi.repository;

import lian.sample.productapi.model.entiity.Product;
import lian.sample.productapi.model.entiity.ProductItem;

public interface LoadProductPort {

    Product findByProductId(long productId);

    ProductItem findByProductItem(long productProductId);
}
