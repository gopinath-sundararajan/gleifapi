package com.example.gleif.gleifapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Registration {
    private Date initialRegistrationDate;
    private Date lastUpdateDate;
    private String status;
    private Date nextRenewalDate;
    private String managingLou;
    private String corroborationLevel;
    private ValidatedAt validatedAt;
    private String validatedAs;
    private List<Object> otherValidationAuthorities;
}
