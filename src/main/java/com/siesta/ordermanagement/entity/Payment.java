package com.siesta.ordermanagement.entity;

import com.siesta.ordermanagement.enums.PaymentMode;
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
@Table(name = "payments", schema = "siesta_service_db")
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