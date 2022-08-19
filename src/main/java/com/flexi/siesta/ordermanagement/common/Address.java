package com.flexi.siesta.ordermanagement.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {
    private String addressFirstLine;
    private String addressSecondLine;
    private String addressThirdLine;
    private String landmark;
    private String city;
    private String state;
    private String country;
    private String zip;
}
