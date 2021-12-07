package darius.licenta.backend.mapper.storycomment;

import darius.licenta.backend.domain.StoryComment;
import darius.licenta.backend.dto.storycomment.StoryCommentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoryCommentMapper {
    StoryComment storyCommentDtoToStoryComment(StoryCommentDto storyCommentDto);

    StoryCommentDto storyCommentToStoryCommentDto(StoryComment storyComment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryCommentFromStoryCommentDto(StoryCommentDto storyCommentDto, @MappingTarget StoryComment storyComment);
}
