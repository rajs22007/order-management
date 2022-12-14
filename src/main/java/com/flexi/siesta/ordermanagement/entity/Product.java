package com.flexi.siesta.ordermanagement.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends AuditInfo implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id = UUID.randomUUID().toString();
    private String productCode;
    private String productName;
    private String productDesc;
    private String productCategory;
    private String brand;
    private String modelName;
    // https://stackoverflow.com/questions/50363639/how-spring-boot-jpahibernate-saves-images
    private Boolean isActive = Boolean.TRUE;
    private Boolean hasMetaData = Boolean.FALSE;
    //@ElementCollection
    //private Map<String, Object> additionalProperties;
}
