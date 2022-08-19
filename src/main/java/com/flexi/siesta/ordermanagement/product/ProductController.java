package com.flexi.siesta.ordermanagement.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import java.util.List;

@Tag(name = "Products")
@RestController
@RequestMapping("/siesta/api/product")
public class ProductController {

    @Autowired
    private ServletContext servletContext;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createProduct(@ModelAttribute ProductRequest productRequest) {
        String productCode = productService.createProduct(productRequest);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .replacePath("/siesta/api/product/{productCode}")
                        .buildAndExpand(productCode).toUri())
                .build();
    }

    @GetMapping(value = "{productCode}/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImageAsResource(@PathVariable String productCode,
                                                       @PathVariable String imageId) {
        Resource resource = new ByteArrayResource(productService.getImageByProductCodeAndImageId(productCode, imageId));
        return ResponseEntity.ok(resource);
    }


}
