package com.siesta.ordermanagement.entity;

import com.siesta.ordermanagement.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends AuditInfo implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String orderId;
    private String productId;
    private String customerId;
    private Integer quantity;
    private String desc;
    //@ElementCollection(targetClass = OrderStatus.class)
    //@Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}