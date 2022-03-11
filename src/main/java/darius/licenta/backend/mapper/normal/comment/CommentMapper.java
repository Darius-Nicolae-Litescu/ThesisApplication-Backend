package darius.licenta.backend.mapper.normal.comment;

import darius.licenta.backend.domain.sql.Comment;
import darius.licenta.backend.dto.normal.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.normal.comment.storytask.InsertStoryTaskCommentDto;
import darius.licenta.backend.dto.normal.storycomment.StoryCommentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentMapper {
    Comment storyCommentDtoToStoryComment(StoryCommentDto storyCommentDto);

    StoryCommentDto storyCommentToStoryCommentDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryCommentFromStoryCommentDto(StoryCommentDto storyCommentDto, @MappingTarget Comment comment);

    @Mapping(source = "storyId", target = "story.id")
    @Mapping(target = "commentAttachments", ignore = true)
    Comment insertStoryCommentDtoToComment(InsertStoryCommentDto insertStoryCommentDto);

    @Mapping(source = "storyId", target = "story.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCommentFromInsertStoryCommentDto(InsertStoryCommentDto insertStoryCommentDto, @MappingTarget Comment comment);

    @Mapping(source = "storyTaskId", target = "storyTask.id")
    @Mapping(target = "commentAttachments", ignore = true)
    Comment insertStoryTaskCommentDtoToComment(InsertStoryTaskCommentDto insertStoryTaskCommentDto);

    @Mapping(source = "storyTaskId", target = "storyTask.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCommentFromInsertStoryTaskCommentDto(InsertStoryTaskCommentDto insertStoryTaskCommentDto, @MappingTarget Comment comment);
}
