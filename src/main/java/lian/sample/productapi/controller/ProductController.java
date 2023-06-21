package lian.sample.productapi.controller;

import jakarta.validation.Valid;
import lian.sample.productapi.model.domain.ProductItemInfo;
import lian.sample.productapi.model.domain.command.CreateProduct;
import lian.sample.productapi.model.domain.command.UpdateProduct;
import lian.sample.productapi.model.domain.query.ProductDto;
import lian.sample.productapi.model.response.ResponseData;
import lian.sample.productapi.service.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductUseCase productUseCase;

    @PostMapping("/product")
    @ResponseBody
    public ResponseEntity createProduct(@RequestBody @Valid CreateProduct createProduct) {
        productUseCase.createProduct(createProduct);
        ResponseData apiResponseDto = new ResponseData(HttpStatus.OK, "success", null);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity getProduct(@PathVariable long productId) {
        ProductDto product = productUseCase.getProduct(productId);
        ResponseData apiResponseDto = new ResponseData(HttpStatus.OK, "success", product);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity updateProduct(@RequestBody @Valid UpdateProduct UpdateProduct) {
        productUseCase.updateProduct(UpdateProduct);
        ResponseData apiResponseDto = new ResponseData(HttpStatus.OK, "success", null);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @PutMapping("/product/{productId}/item/{productItemId}")
    public ResponseEntity updateProductItem(@RequestBody @Valid ProductItemInfo productItemInfo,
                                            @PathVariable long productId,
                                            @PathVariable long productItemId) {
        productUseCase.updateProductItem(productItemInfo, productId);
        ResponseData apiResponseDto = new ResponseData(HttpStatus.OK, "success", null);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @GetMapping("/mdc/test")
    public String mdcTest() {
        return "hi2";
    }
}
