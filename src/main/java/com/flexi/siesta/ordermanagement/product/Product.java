package com.flexi.siesta.ordermanagement.product;

import com.flexi.siesta.ordermanagement.common.AuditInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends AuditInfo implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private UUID id = UUID.randomUUID();
    private String productCode;
    private String productName;
    private String productDesc;
    private String productCategory;
    private String brand;
    private String modelName;
    // https://stackoverflow.com/questions/50363639/how-spring-boot-jpahibernate-saves-images
    private Boolean active = Boolean.TRUE;
    private Boolean metaData = Boolean.FALSE;
    //@ElementCollection
    //private Map<String, Object> additionalProperties;
}
