package darius.licenta.backend.dto.normal.story.request.update;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UpdateStoryCategories implements Serializable {
    private final Long id;
    private final Set<CategoryDto> categories;

    @Data
    public static class CategoryDto implements Serializable {
        private final Long id;
    }
}
