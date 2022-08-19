package com.flexi.siesta.ordermanagement.customer;

import com.flexi.siesta.ordermanagement.common.Address;
import com.flexi.siesta.ordermanagement.common.AuditInfo;
import com.flexi.siesta.ordermanagement.common.Contact;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends AuditInfo implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private Contact contact;
    private Address address;
    //@ElementCollection(targetClass = String.class)
    //private Set<String> customerWishCartIds;

    //@ElementCollection
    //private Map<String, Object> additionalProperties;

}
