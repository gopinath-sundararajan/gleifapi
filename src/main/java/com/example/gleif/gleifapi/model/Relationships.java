package com.example.gleif.gleifapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Relationships {

    @SerializedName("managing-lou")
    private ManagingLou managingLou;

    @SerializedName("lei-issuer")
    private LeiIssuer leiIssuer;

    @SerializedName("field-modifications")
    private FieldModifications fieldModifications;

    @SerializedName("direct-parent")
    private DirectParent directParent;

    @SerializedName("ultimate-parent")
    private UltimateParent ultimateParent;
}
