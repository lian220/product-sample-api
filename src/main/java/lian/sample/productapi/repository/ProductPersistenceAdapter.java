package lian.sample.productapi.repository;

import lian.sample.productapi.model.entiity.Product;
import lian.sample.productapi.model.entiity.ProductItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductPersistenceAdapter implements SaveProductPort{

    private final ProductRepository productRepository;
    private final ProductItemRepository productItemRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
        for (ProductItem productItem: product.getItemList()) {
            productItem.setProduct(product);
            productItemRepository.save(productItem);
        }
    }
}
