package com.siesta.ordermanagement.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "productCatalog", schema = "siesta_service_db")
public class ProductCatalog extends AuditInfo implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String productId;
    private Integer quantity;
    private BigDecimal originalPrice;
    private BigDecimal offerPrice;

    //@ElementCollection
    //private Map<String, Object> additionalProperties;
}
