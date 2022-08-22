package com.flexi.siesta.ordermanagement.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AuditInfo implements Serializable {
    private LocalDate placedOn;
    private LocalDate updatedOn;
    private String placedBy;
    private String updatedBy;
    private String message;
}
