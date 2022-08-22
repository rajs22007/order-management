package com.flexi.siesta.ordermanagement.entity;

import com.flexi.siesta.ordermanagement.enums.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
