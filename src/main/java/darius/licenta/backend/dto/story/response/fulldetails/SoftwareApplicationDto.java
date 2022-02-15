package darius.licenta.backend.dto.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;

@Data
public class SoftwareApplicationDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}
