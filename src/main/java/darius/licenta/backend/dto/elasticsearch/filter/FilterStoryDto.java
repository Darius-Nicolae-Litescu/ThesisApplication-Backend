package darius.licenta.backend.dto.elasticsearch.filter;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchStoryDto;
import lombok.Data;

import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Data
public class FilterStoryDto {
    private final String title;
    private final String description;
    private final String category;
    private final Long priorityId;
    private final String priorityTitle;
    private final String priorityDescription;
    private final Integer priorityLevel;
    private final String softwareApplicationName;
    private final String softwareApplicationDescription;

}
