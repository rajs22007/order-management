package com.flexi.siesta.ordermanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Contact implements Serializable {
    private String primaryNumber;
    private String secondaryNumber;
    private String landline;
    private String primaryEmailAddress;
    private String secondaryEmailAddress;
    private ContactMode preferredMode;
    private String preferredTime;

    enum ContactMode {
        EMAIL, MOBILE
    }
}
