package com.flexi.siesta.ordermanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuditInfoResponse {
    private LocalDate placedOn;
    private LocalDate updatedOn;
    private String placedBy;
    private String updatedBy;
    private String message;
}
