package lian.sample.productapi.model.domain.query;

import lian.sample.productapi.model.domain.ProductInfo;
import lian.sample.productapi.model.domain.ProductItemInfo;
import lian.sample.productapi.model.entiity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto extends ProductInfo {
    private long productId;
    List<ProductItemInfo> productItemInfoList;

    public ProductDto(Product product, List<ProductItemInfo> productItemList) {
        setProductId(product.getProductId());
        setName(product.getName());
        setPrice(product.getPrice());
        setQuantity(product.getQuantity());
        setDescription(product.getDescription());
        setCreated(product.getCreated());
        setUpdated(product.getUpdated());
        setProductItemInfoList(productItemList);
    }
}
