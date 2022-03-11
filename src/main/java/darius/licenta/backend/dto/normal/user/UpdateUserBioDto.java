package darius.licenta.backend.dto.normal.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateUserBioDto implements Serializable {
    private final String bioDescription;
}
