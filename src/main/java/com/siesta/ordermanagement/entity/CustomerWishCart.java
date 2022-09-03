package com.siesta.ordermanagement.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customerWishCarts", schema = "siesta_service_db")
public class CustomerWishCart implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String customerId;
    private String productId;
    private String productName;
    private String productQuantity;
    private ShopSelection shopSelection;
    private LocalDate bucketEntryOn;

    public enum ShopSelection {
        CART, WISH_LIST
    }
}
