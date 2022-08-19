package com.flexi.siesta.ordermanagement.product;

import com.flexi.siesta.ordermanagement.common.AuditInfoResponse;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.List;

@Getter
@Setter
public class ProductResponse {
    private String productCode;
    private String productName;
    private String productDesc;
    private String productCategory;
    private String brand;
    private String modelName;
    private List<URI> productImage;
    private Boolean active = Boolean.TRUE;
    private AuditInfoResponse audit;
}
