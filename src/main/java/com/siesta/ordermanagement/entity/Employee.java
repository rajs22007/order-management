package com.siesta.ordermanagement.entity;

import com.siesta.ordermanagement.enums.ERole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees", schema = "siesta_service_db")
public class Employee implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private Contact contact;
    private Address address;

    @ElementCollection(targetClass = ERole.class)
    @Enumerated(EnumType.STRING)
    private Set<ERole> roles;

    //@ElementCollection
    //private Map<String, Object> additionalProperties;

}
