package com.siesta.ordermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class ProductRequest {
    private String productCode;
    private String productName;
    private String productDesc;
    private String productCategory;
    private String brand;
    private String modelName;
    private MultipartFile[] productImages;
    private Boolean active = true;
}
