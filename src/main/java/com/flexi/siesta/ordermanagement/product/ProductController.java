package com.flexi.siesta.ordermanagement.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import java.util.List;

@Tag(name = "Products", description = "Deals with lifecycle of Products & tied with actions specific to product domain")
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

    @Operation(summary = "Get Products", description = "Get all the products with image links")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @Operation(summary = "Get Product", description = "Get the product by productCode")
    @GetMapping(value = "{productCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> getProduct(String productCode) {
        return ResponseEntity.ok(productService.getProduct(productCode));
    }

    @Operation(summary = "Create Product", description = "Create a new product with image attachments")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createProduct(@ModelAttribute ProductRequest productRequest) {
        String productCode = productService.createProduct(productRequest);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .replacePath("/siesta/api/product/{productCode}")
                        .buildAndExpand(productCode).toUri())
                .build();
    }

    @Operation(summary = "Get Image", description = "Get an image with productCode and imageId")
    @GetMapping(value = "{productCode}/image/{imageId}",
            produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public ResponseEntity<Resource> getImageAsResource(@PathVariable String productCode,
                                                       @PathVariable String imageId) {
        Pair<byte[], String> pair = productService.getImageByProductCodeAndImageId(productCode, imageId);
        Resource resource = new ByteArrayResource(pair.getFirst());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaTypeFactory.getMediaType(pair.getSecond()).orElse(MediaType.IMAGE_JPEG))
                .body(resource);
    }


}
