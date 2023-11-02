package com.example.gleif.gleifapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Relationships {

    @JsonProperty("managing-lou")
    private ManagingLou managingLou;

    @JsonProperty("lei-issuer")
    private LeiIssuer leiIssuer;

    @JsonProperty("field-modifications")
    private FieldModifications fieldModifications;

    @JsonProperty("direct-parent")
    private DirectParent directParent;

    @JsonProperty("ultimate-parent")
    private UltimateParent ultimateParent;
}
