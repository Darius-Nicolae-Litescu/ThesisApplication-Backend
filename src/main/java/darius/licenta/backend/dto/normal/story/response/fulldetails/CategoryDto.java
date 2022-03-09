package darius.licenta.backend.dto.normal.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String categoryName;
    private final Blob categoryPicture;
}
