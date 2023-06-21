package lian.sample.productapi.repository;

import lian.sample.productapi.model.entiity.Product;
import lian.sample.productapi.model.entiity.ProductItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ProductPersistenceAdapter implements SaveProductPort, LoadProductPort{

    private final ProductRepository productRepository;
    private final ProductItemRepository productItemRepository;

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
        if(product.getItemList() != null)
            for (ProductItem productItem: product.getItemList()) {
                productItem.setProduct(product);
                productItemRepository.save(productItem);
            }
    }

    @Override
    public void save(ProductItem productItem) {
        productItemRepository.save(productItem);
    }

    @Override
    public Product findByProductId(long productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public ProductItem findByProductItem(long productProductId) {
        return productItemRepository.findByProductItemId(productProductId);
    }
}
