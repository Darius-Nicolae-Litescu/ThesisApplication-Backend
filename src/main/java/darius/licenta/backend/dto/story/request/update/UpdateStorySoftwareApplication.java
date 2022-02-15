package darius.licenta.backend.dto.story.request.update;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateStorySoftwareApplication implements Serializable {
    private final Long id;
    private final SoftwareApplicationDto softwareApplication;

    @Data
    public static class SoftwareApplicationDto implements Serializable {
        private final Long id;
    }
}
