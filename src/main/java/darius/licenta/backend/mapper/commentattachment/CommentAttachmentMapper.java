package darius.licenta.backend.mapper.commentattachment;

import darius.licenta.backend.domain.CommentAttachment;
import darius.licenta.backend.dto.commentattachment.CommentAttachmentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentAttachmentMapper {
    CommentAttachment commentAttachmentDtoToCommentAttachment(CommentAttachmentDto commentAttachmentDto);

    CommentAttachmentDto commentAttachmentToCommentAttachmentDto(CommentAttachment commentAttachment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCommentAttachmentFromCommentAttachmentDto(CommentAttachmentDto commentAttachmentDto, @MappingTarget CommentAttachment commentAttachment);
}
