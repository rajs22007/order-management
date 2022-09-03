package com.siesta.ordermanagement.entity;

import com.siesta.ordermanagement.enums.OrderStatus;
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
@Table(name = "orders", schema = "siesta_service_db")
public class OrderInfo extends AuditInfo implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String customerId;
    //@ElementCollection
    //private Set<String> orderItemIds;
    //@ElementCollection
    //private Set<String> paymentIds;
    private BigDecimal orderTotal;
    private BigDecimal amountPaid;
    private BigDecimal amountDue;

    //@Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    //@ElementCollection
    //private Map<String, Object> additionalProperties;

}
