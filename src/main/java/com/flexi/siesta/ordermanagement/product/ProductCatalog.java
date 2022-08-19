package com.flexi.siesta.ordermanagement.product;

import com.flexi.siesta.ordermanagement.common.AuditInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
