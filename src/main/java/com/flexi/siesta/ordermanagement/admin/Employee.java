package com.flexi.siesta.ordermanagement.admin;

import com.flexi.siesta.ordermanagement.common.Address;
import com.flexi.siesta.ordermanagement.common.Contact;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private Contact contact;
    private Address address;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    //@ElementCollection
    //private Map<String, Object> additionalProperties;

}
