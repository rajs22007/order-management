package com.flexi.siesta.ordermanagement.payment;

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