package lian.sample.productapi.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lian.sample.productapi.exception.CustomErrorLog;
import lian.sample.productapi.model.domain.CreateProduct;
import lian.sample.productapi.model.entiity.Product;
import lian.sample.productapi.model.entiity.ProductItem;
import lian.sample.productapi.repository.SaveProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final SaveProductPort saveProductPort;

    @CustomErrorLog
    @Override
    public void createProduct(CreateProduct createProduct) {
        ObjectMapper objectMapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        List<ProductItem> productItemList = objectMapper.convertValue(createProduct.getProductItemInfoList(), new TypeReference<List<ProductItem>>(){});
        Product product = Product.builder()
                .name(createProduct.getName())
                .quantity(createProduct.getQuantity())
                .price(createProduct.getPrice())
                .description(createProduct.getDescription())
                .isUsed(createProduct.isUsed())
                .itemList(productItemList)
                .build();
        saveProductPort.save(product);
    }

    @Override
    public Product getProduct(long productId) {
        return null;
    }
}
