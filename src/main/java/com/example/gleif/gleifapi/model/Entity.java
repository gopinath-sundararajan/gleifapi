package com.example.gleif.gleifapi.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Entity {
    private LegalName legalName;
    private List<OtherName> otherNames;
    private List<Object> transliteratedOtherNames;
    private LegalAddress legalAddress;
    private HeadquartersAddress headquartersAddress;
    private RegisteredAt registeredAt;
    private String registeredAs;
    private String jurisdiction;
    public String category;
    public LegalForm legalForm;
    public AssociatedEntity associatedEntity;
    public String status;
    public Expiration expiration;
    public SuccessorEntity successorEntity;
    public List<Object> successorEntities;
    public Date creationDate;
    public Object subCategory;
    public List<OtherAddress> otherAddresses;
    public List<Object> eventGroups;
}
