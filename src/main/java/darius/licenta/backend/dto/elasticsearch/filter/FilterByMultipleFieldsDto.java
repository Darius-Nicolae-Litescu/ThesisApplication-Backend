package darius.licenta.backend.dto.elasticsearch.filter;

import lombok.Data;

@Data
public class FilterByMultipleFieldsDto {
    FilterStoryDto filterStoryDto;
    FilterStoryTaskDto filterStoryTaskDto;
    FilterSoftwareApplicationDto filterSoftwareApplicationDto;
    FilterCommentDto filterCommentDto;
    FilterUserDto filterUserDto;
    int startFromResult;
    int pageSize;
}
