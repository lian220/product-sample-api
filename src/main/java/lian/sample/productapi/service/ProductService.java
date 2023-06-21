package lian.sample.productapi.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lian.sample.productapi.exception.CustomErrorLog;
import lian.sample.productapi.model.domain.command.CreateProduct;
import lian.sample.productapi.model.domain.ProductItemInfo;
import lian.sample.productapi.model.domain.command.UpdateProduct;
import lian.sample.productapi.model.domain.query.ProductDto;
import lian.sample.productapi.model.entiity.Product;
import lian.sample.productapi.model.entiity.ProductItem;
import lian.sample.productapi.repository.LoadProductPort;
import lian.sample.productapi.repository.SaveProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final SaveProductPort saveProductPort;
    private final LoadProductPort loadProductPort;

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
    public void updateProduct(UpdateProduct updateProduct) {
        Product product = Product.builder()
                .productId(updateProduct.getProductId())
                .name(updateProduct.getName())
                .quantity(updateProduct.getQuantity())
                .price(updateProduct.getPrice())
                .description(updateProduct.getDescription())
                .isUsed(updateProduct.isUsed())
                .build();
        saveProductPort.save(product);
    }

    @Override
    public void updateProductItem(ProductItemInfo productItemInfo, long productId) {
        ObjectMapper objectMapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        ProductItem productItem = objectMapper.convertValue(productItemInfo, ProductItem.class);
        Product product = loadProductPort.findByProductId(productId);
        productItem.setProduct(product);
        saveProductPort.save(productItem);
    }

    @Override
    public ProductDto getProduct(long productId) {
        Product product = loadProductPort.findByProductId(productId);
        List<ProductItemInfo> productItemList = product.getItemList().stream().map(checkoutProductItem -> {
            ProductItemInfo productItemInfo = ProductItemInfo.builder()
                    .productItemId(checkoutProductItem.getProductItemId())
                    .name(checkoutProductItem.getName())
                    .price(checkoutProductItem.getPrice())
                    .quantity(checkoutProductItem.getQuantity())
                    .description(checkoutProductItem.getDescription())
                    .build();
            return productItemInfo;
        }).collect(Collectors.toList());
        ProductDto productDto = new ProductDto(product, productItemList);
        return productDto;
    }
}
