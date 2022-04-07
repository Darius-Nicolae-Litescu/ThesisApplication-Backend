package darius.licenta.backend.dto.normal.story.request.update;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ChangeStoryGeneralDetails implements Serializable {
    private final Long id;
    private final Set<Long> categoryIds;
    private final Long priorityId;
}
