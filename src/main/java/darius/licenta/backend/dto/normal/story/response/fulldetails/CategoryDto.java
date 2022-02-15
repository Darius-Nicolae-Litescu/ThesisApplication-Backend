package darius.licenta.backend.dto.normal.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String categoryName;
}
