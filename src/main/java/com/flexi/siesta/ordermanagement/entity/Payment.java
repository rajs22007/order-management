package com.flexi.siesta.ordermanagement.entity;

import com.flexi.siesta.ordermanagement.enums.PaymentMode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment extends AuditInfo implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String orderId;
    private PaymentMode paymentMode;
    private String paymentSubMode;
    private BigDecimal amount;

    //@ElementCollection
    //private Map<String, Object> additionalProperties;

}