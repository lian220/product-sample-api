package lian.sample.productapi.controller;

import jakarta.validation.Valid;
import lian.sample.productapi.model.domain.CreateProduct;
import lian.sample.productapi.service.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;

    @PostMapping("/api/product")
    @ResponseBody
    public String createProduct(@RequestBody @Valid CreateProduct createProduct) {
        productUseCase.createProduct(createProduct);
        return "hi";
    }
}
