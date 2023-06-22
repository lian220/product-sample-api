package lian.sample.productapi.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(
            summary = "상품 생성",
            description = "User(사용자) 가 상품을 생성"
    )
    public ResponseEntity createProduct(@RequestBody @Valid CreateProduct createProduct) {
        productUseCase.createProduct(createProduct);
        ResponseData apiResponseDto = new ResponseData(HttpStatus.OK, "success", null);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    @Operation(
            summary = "상품 정보"
    )
    public ResponseEntity getProduct(@PathVariable long productId) {
        ProductDto product = productUseCase.getProduct(productId);
        ResponseData apiResponseDto = new ResponseData(HttpStatus.OK, "success", product);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @PutMapping("/product/{productId}")
    @Operation(
            summary = "상품 수정"
    )
    public ResponseEntity updateProduct(@RequestBody @Valid UpdateProduct UpdateProduct) {
        productUseCase.updateProduct(UpdateProduct);
        ResponseData apiResponseDto = new ResponseData(HttpStatus.OK, "success", null);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @PutMapping("/product/{productId}/item/{productItemId}")
    @Operation(
            summary = "상품 아이템 수정"
    )
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
