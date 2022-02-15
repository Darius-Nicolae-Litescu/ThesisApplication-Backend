package darius.licenta.backend.mapper.comment;

import darius.licenta.backend.domain.Comment;
import darius.licenta.backend.dto.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.comment.storytask.InsertStoryTaskCommentDto;
import darius.licenta.backend.dto.storycomment.StoryCommentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentMapper {
    Comment storyCommentDtoToStoryComment(StoryCommentDto storyCommentDto);

    StoryCommentDto storyCommentToStoryCommentDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryCommentFromStoryCommentDto(StoryCommentDto storyCommentDto, @MappingTarget Comment comment);

    @Mapping(source = "storyId", target = "story.id")
    Comment insertStoryCommentDtoToComment(InsertStoryCommentDto insertStoryCommentDto);

    @Mapping(source = "story.id", target = "storyId")
    InsertStoryCommentDto commentToInsertStoryCommentDto(Comment comment);

    @Mapping(source = "storyId", target = "story.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCommentFromInsertStoryCommentDto(InsertStoryCommentDto insertStoryCommentDto, @MappingTarget Comment comment);

    @Mapping(source = "storyTaskId", target = "storyTask.id")
    Comment insertStoryTaskCommentDtoToComment(InsertStoryTaskCommentDto insertStoryTaskCommentDto);

    @Mapping(source = "storyTask.id", target = "storyTaskId")
    InsertStoryTaskCommentDto commentToInsertStoryTaskCommentDto(Comment comment);

    @Mapping(source = "storyTaskId", target = "storyTask.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCommentFromInsertStoryTaskCommentDto(InsertStoryTaskCommentDto insertStoryTaskCommentDto, @MappingTarget Comment comment);
}
