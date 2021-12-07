package darius.licenta.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleInsertDto {
    @NotNull
    @JsonProperty("roleName")
    private String roleName;

    @NotNull
    @JsonProperty("roleDescription")
    private String roleDescription;
}