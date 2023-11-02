package com.example.gleif.gleifapi.model;

import lombok.Data;

@Data
public class Attributes {
    private String lei;
    private Entity entity;
    private Registration registration;
    private Object bic;
    private Object mic;
    private Object ocId;
    private Object spGlobal;
}
